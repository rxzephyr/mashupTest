package com.mashuptest.demo.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashuptest.demo.Entity.TrainInfo;
import com.mashuptest.demo.Entity.TrainTicketInfo;
import com.mashuptest.demo.Entity.WeatherInfo;
import com.mashuptest.demo.Utility.HttpUtility;
import com.mashuptest.demo.Utility.RedisUtility;
import com.mashuptest.demo.Utility.SeniverseUtility;
import com.mashuptest.demo.Utility.TrainUtility;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

import static com.mashuptest.demo.Config.Constants.*;

@Component
@Configuration
@EnableScheduling
public class ScheduledUpdateTask
{
	private ObjectMapper mapper=new ObjectMapper();

	private WeatherInfo weatherInfo=null;
	private TrainInfo trainInfo=null;
	private double ticketPrice=0;
	private int consumedTime=0;
	private boolean weatherUpdateSuccess=true;
	private boolean trainUpdateSuccess=true;
	private int weatherRecommendWeight=0;
	private int trainRecommendWeight=0;

	@Scheduled(cron="0 15 0/1 * * ?")
	public void UpdateAllCityWeather()
	{
		for(String city: CITY_LIST)
		{
			InitWeatherInfo();

			getWeatherInfo(city);
			updateWeatherMap(city);


			getTrainInfo(city);
			getTrainTicketInfo();//依赖于updateTrainInfo(city)的结果
			updateTrainMap(city);

			updateRecommendLevel(city);
		}
		InitWeatherInfo();
		updateRedisData();
	}

	@Scheduled(cron="0 0 7 1/1 * ?")
	public void UpdateAllCityTrain()
	{
		for(String city: CITY_LIST)
		{
			InitTrainInfo();

			getWeatherInfo(city);
			updateWeatherMap(city);


			getTrainInfo(city);
			getTrainTicketInfo();//依赖于updateTrainInfo(city)的结果
			updateTrainMap(city);

			updateRecommendLevel(city);
			try
			{
				Thread.sleep(GET_TRAIN_CITY_INTERVAL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		InitTrainInfo();
		updateRedisData();
	}

	public ScheduledUpdateTask()
	{
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}

	void InitWeatherInfo()
	{
		weatherInfo=null;
		weatherUpdateSuccess=true;
		weatherRecommendWeight=0;
	}

	void InitTrainInfo()
	{
		trainInfo=null;
		ticketPrice=0;
		consumedTime=0;
		trainUpdateSuccess=true;
		trainRecommendWeight=0;
	}

	void getWeatherInfo(String city)
	{
		try
		{
			SeniverseUtility seniverseUtility=new SeniverseUtility();
			String weatherURL=seniverseUtility.generateGetDiaryWeatherURL(city,
					"zh-Hans",
					"c",
					"0",
					"2");
			String weatherResult=HttpUtility.sendGet(weatherURL);
			weatherInfo=mapper.readValue(weatherResult,new TypeReference<WeatherInfo>()
			{
			});
		}
		catch(Exception e)
		{
			weatherUpdateSuccess=false;
		}
	}

	void getTrainInfo(String city)
	{
		try
		{
			TrainUtility trainUtility=new TrainUtility();
			String trainURL=trainUtility.getTrainsInfoURL(LocalDate.now().plusDays(1).toString(),
					trainUtility.StationMap.get(START_POINT),
					trainUtility.StationMap.get(city));

			String trainResult=HttpUtility.sendGet(trainURL);
			trainInfo=mapper.readValue(trainResult,new TypeReference<TrainInfo>()
			{
			});

		}
		catch(Exception e)
		{
			trainUpdateSuccess=false;
		}
	}

	void getTrainTicketInfo()
	{
		try
		{
			TrainUtility trainUtility=new TrainUtility();
			TrainInfo.DetailInfo[] detailInfos=trainInfo.getData().Simplify();
			double averageTicketPrice=0.0;
			int averageConsumedTime=0;

			for(int i=0;i<detailInfos.length&&i<TRAIN_TICKET_PRICE_AVERGE_GET_TIME;i++)
			{
				String trainTicketInfoURL=trainUtility.getPriceURL(detailInfos[i].getTrainNumber(),
						detailInfos[i].getStartStationNumber(),
						detailInfos[i].getEndStationNumber(),
						LocalDate.now().plusDays(1).toString());
				String trainTicketInfoResult=HttpUtility.sendGet(trainTicketInfoURL);
				TrainTicketInfo trainTicketInfo=mapper
						.readValue(trainTicketInfoResult,new TypeReference<TrainTicketInfo>()
						{
						});
				averageTicketPrice+=Double.parseDouble(trainTicketInfo.getData().getWZ().substring(1));

				String[] consumedTimeSplit=detailInfos[i].getPeriod().split(":");
				averageConsumedTime+=Integer.parseInt(consumedTimeSplit[0])*60+Integer
						.parseInt(consumedTimeSplit[1]);
				try
				{
					Thread.sleep(GET_TRAIN_TRAIN_INTERVAL);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			averageTicketPrice/=Math.min(detailInfos.length,TRAIN_TICKET_PRICE_AVERGE_GET_TIME);
			averageConsumedTime/=Math.min(detailInfos.length,TRAIN_TICKET_PRICE_AVERGE_GET_TIME);
			ticketPrice=averageTicketPrice;
			consumedTime=averageConsumedTime;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	void updateWeatherMap(String city)
	{
		if(weatherUpdateSuccess)
		{
			MAIN_DATA.get(city).get("WeatherTomorrow").put("Brief",
					weatherInfo.getResults().get(0).getDaily().get(0).getText_day()
							+" "
							+weatherInfo.getResults().get(0).getDaily().get(0).getLow()
							+"-"
							+weatherInfo.getResults().get(0).getDaily().get(0).getHigh()
							+"℃");
			MAIN_DATA.get(city).get("WeatherDayAfterTomorrow").put("Brief",
					weatherInfo.getResults().get(0).getDaily().get(1).getText_day()
							+" "
							+weatherInfo.getResults().get(0).getDaily().get(1).getLow()
							+"-"
							+weatherInfo.getResults().get(0).getDaily().get(1).getHigh()
							+"℃");
			weatherRecommendWeight=0;
			if(weatherInfo.getResults().get(0).getDaily().get(0).getText_day().equals("晴")
					||weatherInfo.getResults().get(0).getDaily().get(0).getText_day().equals("多云"))
				weatherRecommendWeight+=1;
			if(weatherInfo.getResults().get(0).getDaily().get(0).getLow()>RECOMMEND_LOW_TEMPERATURE
					&&weatherInfo.getResults().get(0).getDaily().get(0).getLow()<RECOMMEND_HIGH_TEMPERATURE)
				weatherRecommendWeight+=1;
			MAIN_DATA.get(city).get("RecommendLevel").put("WeatherRaw",Integer.toString(weatherRecommendWeight));
		}
	}

	void updateTrainMap(String city)
	{
		if(trainUpdateSuccess)
		{
			MAIN_DATA.get(city).get("Train")
					.put("TimeConsumption",Integer.toString(consumedTime/60)+":"+Integer.toString(consumedTime%60));
			MAIN_DATA.get(city).get("Train")
					.put("TicketPrice",Double.toString(ticketPrice));
			trainRecommendWeight=0;
			if(ticketPrice<RECOMMEND_TICKET_UPPER_LIMIT)
				trainRecommendWeight+=1;
			if(consumedTime<RECOMMEND_CONSUMED_TIME_UPPER_LIMIT)
				trainRecommendWeight+=1;
			MAIN_DATA.get(city).get("RecommendLevel").put("TrainRaw",Integer.toString(trainRecommendWeight));
		}
	}

	void updateRecommendLevel(String city)
	{
		int count=Integer.parseInt(MAIN_DATA.get(city).get("RecommendLevel").get("WeatherRaw"))
				+Integer.parseInt(MAIN_DATA.get(city).get("RecommendLevel").get("TrainRaw"));
		switch(count)
		{
			case 0:
				MAIN_DATA.get(city).get("RecommendLevel").put("Data","非常适宜");
				break;
			case 1:
				MAIN_DATA.get(city).get("RecommendLevel").put("Data","比较适宜");
				break;
			case 2:
				MAIN_DATA.get(city).get("RecommendLevel").put("Data","一般");
				break;
			case 3:
				MAIN_DATA.get(city).get("RecommendLevel").put("Data","不推荐");
				break;
		}
	}


	void updateRedisData()
	{
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(MAIN_DATA);
			RedisUtility redisUtility=new RedisUtility();
			redisUtility.set("MainData",result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public static void main(String[] args)
	{
		System.out.println("Started");
		ScheduledUpdateTask scheduledUpdateTask=new ScheduledUpdateTask();
		scheduledUpdateTask.UpdateAllCityWeather();
		scheduledUpdateTask.UpdateAllCityTrain();


		try
		{
			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(MAIN_DATA);


			System.out.println("\n"+result+"\n");

			RedisUtility redisUtility=new RedisUtility();
			redisUtility.set("MainData",result);


			Map<String,Map<String,Map<String,String>>> restoreMap=mapper
					.readValue(redisUtility.getByKey("MainData").toString(),
							new TypeReference<Map<String,Map<String,Map<String,String>>>>()
							{
							});

			System.out.println("Finished");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
