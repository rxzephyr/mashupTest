package com.mashuptest.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashuptest.demo.Service.ScheduledUpdateTask;
import com.mashuptest.demo.Utility.RedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static com.mashuptest.demo.Config.Constants.*;

@RestController
public class MainController
{
	@Autowired
	RedisUtility redisUtility;

	@RequestMapping("/")
	public ModelAndView MainFunction()
	{
		ModelAndView modelAndView=new ModelAndView("main_display_page");
		List<List<String>> dataList=new LinkedList<>();
		for(String city: CITY_LIST)
		{
			List<String> list=new LinkedList<>();
			list.add(CITY_CHINESE_NAME.get(city));
			list.add(MAIN_DATA.get(city).get("RecommendLevel").get("Data"));//recommend_level
			list.add(MAIN_DATA.get(city).get("WeatherTomorrow").get("Brief"));
			list.add(MAIN_DATA.get(city).get("WeatherDayAfterTomorrow").get("Brief"));
			list.add(MAIN_DATA.get(city).get("Train").get("TimeConsumption"));
			list.add(MAIN_DATA.get(city).get("Train").get("TicketPrice"));
			dataList.add(list);
		}

		modelAndView.addObject("dataList",dataList);
		return modelAndView;
	}

	void test()
	{
		try
		{
			ScheduledUpdateTask scheduledUpdateTask=new ScheduledUpdateTask();
			scheduledUpdateTask.UpdateAllCityTrain();
			scheduledUpdateTask.UpdateAllCityWeather();

			ObjectMapper mapper=new ObjectMapper();
			String result=mapper.writeValueAsString(MAIN_DATA);

			redisUtility.set("MainData",result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
