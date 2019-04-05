package com.mashuptest.demo.Utility;

import java.util.HashMap;
import java.util.Map;

public class TrainUtility
{
	private final String TRAIN_API_URL_PREFIX="http://kyfw.12306.cn/otn/leftTicket/";
	public final Map<String,String> StationMap=new HashMap<>()
	{
		{
			put("beijing","BJP");
			put("chongqing","CQW");
			put("shanghai","SHH");
			put("tianjin","TJP");
			put("chengdu","CDW");
			put("fuzhou","FZS");
			put("guangzhou","GZQ");
			put("hangzhou","HZH");
			put("kunming","KMM");
			put("nanjing","NJH");
			put("wuhan","WHN");
			put("xian","XAY");
		}
	};


	public String getPriceURL(String trainNumber,
					   String fromStationNumber,
					   String toStationNumber,
					   String trainDate)
	{
		return TRAIN_API_URL_PREFIX
				+"queryTicketPrice?"
				+"train_no="+trainNumber
				+"&from_station_no="+fromStationNumber
				+"&to_station_no="+toStationNumber
				+"&seat_types=OM9"
				+"&train_date="+trainDate;
	}

	public String getTrainsInfoURL(String trainDate,
							String fromStation,
							String toStation)
	{
		return TRAIN_API_URL_PREFIX
				+"query?"
				+"leftTicketDTO.train_date="+trainDate
				+"&leftTicketDTO.from_station="+fromStation
				+"&leftTicketDTO.to_station="+toStation
				+"&purpose_codes=ADULT";
	}

	public static void main(String[] args)
	{
		TrainUtility trainUtility=new TrainUtility();
		String trainInfourl=trainUtility.getTrainsInfoURL("2019-04-02",
				trainUtility.StationMap.get("shanghai"),
				trainUtility.StationMap.get("tianjin"));
		String result=HttpUtility.sendGet(trainInfourl);
		System.out.println(result);
	}
}
