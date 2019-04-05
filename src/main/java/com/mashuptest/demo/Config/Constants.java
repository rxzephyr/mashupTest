package com.mashuptest.demo.Config;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Constants
{
	public static final List<String> CITY_LIST=new LinkedList<>()
	{{
		push("beijing");
		push("chongqing");
//		push("shanghai");
		push("tianjin");
		push("chengdu");
		push("fuzhou");
		push("guangzhou");
		push("hangzhou");
		push("kunming");
		push("nanjing");
		push("wuhan");
		push("xian");
	}};
	public static final Map<String,String> CITY_CHINESE_NAME=new HashMap<>()
	{{
		put("beijing","北京");
		put("chongqing","重庆");
//		put("shanghai","上海");
		put("tianjin","天津");
		put("chengdu","成都");
		put("fuzhou","福州");
		put("guangzhou","广州");
		put("hangzhou","杭州");
		put("kunming","昆明");
		put("nanjing","南京");
		put("wuhan","武汉");
		put("xian","西安");
	}};

	//TODO 可考虑定时更新，由service进行计算
	public static Map<String,Map<String,Map<String,String>>> MAIN_DATA=new HashMap<>()//;//city_name,weather/train,section_name,data
	{{
		for(String city: CITY_LIST)
		{
			put(city,new HashMap<>()
			{{
				put("RecommendLevel",new HashMap<>()
				{{
					put("Data","一般");
					put("WeatherRaw","0");
					put("TrainRaw","0");
				}});
				put("WeatherTomorrow",new HashMap<>()
				{{
					put("Brief","");
				}});
				put("WeatherDayAfterTomorrow",new HashMap<>()
				{{
					put("Brief","");
				}});
				put("Train",new HashMap<>()
				{{
					put("TimeConsumption","");
					put("TicketPrice","");
				}});
			}});
		}
	}};

	public static final int TRAIN_TICKET_PRICE_AVERGE_GET_TIME=5;
	public static final int RECOMMEND_LOW_TEMPERATURE=10;
	public static final int RECOMMEND_HIGH_TEMPERATURE=25;
	public static final String START_POINT="shanghai";
	public static final int RECOMMEND_TICKET_UPPER_LIMIT=500;
	public static final int RECOMMEND_CONSUMED_TIME_UPPER_LIMIT=180;
	public static final int GET_TRAIN_CITY_INTERVAL=10000;
	public static final int GET_TRAIN_TRAIN_INTERVAL=1000;


}
