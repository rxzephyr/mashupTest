package com.mashuptest.demo.Entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class WeatherInfo
{
	public static class Location
	{
		private String id;
		private String name;
		private String country;
		private String path;
		private String timezone;
		private String timezone_offset;

		public Location()
		{
		}

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id=id;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name=name;
		}

		public String getCountry()
		{
			return country;
		}

		public void setCountry(String country)
		{
			this.country=country;
		}

		public String getPath()
		{
			return path;
		}

		public void setPath(String path)
		{
			this.path=path;
		}

		public String getTimezone()
		{
			return timezone;
		}

		public void setTimezone(String timezone)
		{
			this.timezone=timezone;
		}

		public String getTimezone_offset()
		{
			return timezone_offset;
		}

		public void setTimezone_offset(String timezone_offset)
		{
			this.timezone_offset=timezone_offset;
		}
	}

	public static class DailyWeatherDetail
	{
		private String date;
		private String text_day;
		private Integer code_day;
		private String text_night;
		private Integer code_night;
		private Integer high;
		private Integer low;
		private String precip;
		private String wind_direction;
		private Integer wind_direction_degree;
		private Integer wind_speed;
		private Integer wind_scale;

		public DailyWeatherDetail()
		{
		}

		public String getDate()
		{
			return date;
		}

		public void setDate(String date)
		{
			this.date=date;
		}

		public String getText_day()
		{
			return text_day;
		}

		public void setText_day(String text_day)
		{
			this.text_day=text_day;
		}

		public Integer getCode_day()
		{
			return code_day;
		}

		public void setCode_day(Integer code_day)
		{
			this.code_day=code_day;
		}

		public String getText_night()
		{
			return text_night;
		}

		public void setText_night(String text_night)
		{
			this.text_night=text_night;
		}

		public Integer getCode_night()
		{
			return code_night;
		}

		public void setCode_night(Integer code_night)
		{
			this.code_night=code_night;
		}

		public Integer getHigh()
		{
			return high;
		}

		public void setHigh(Integer high)
		{
			this.high=high;
		}

		public Integer getLow()
		{
			return low;
		}

		public void setLow(Integer low)
		{
			this.low=low;
		}

		public String getPrecip()
		{
			return precip;
		}

		public void setPrecip(String precip)
		{
			this.precip=precip;
		}

		public String getWind_direction()
		{
			return wind_direction;
		}

		public void setWind_direction(String wind_direction)
		{
			this.wind_direction=wind_direction;
		}

		public Integer getWind_direction_degree()
		{
			return wind_direction_degree;
		}

		public void setWind_direction_degree(Integer wind_direction_degree)
		{
			this.wind_direction_degree=wind_direction_degree;
		}

		public Integer getWind_speed()
		{
			return wind_speed;
		}

		public void setWind_speed(Integer wind_speed)
		{
			this.wind_speed=wind_speed;
		}

		public Integer getWind_scale()
		{
			return wind_scale;
		}

		public void setWind_scale(Integer wind_scale)
		{
			this.wind_scale=wind_scale;
		}
	}

	public static class Result
	{
		private Location location;
		private ArrayList<DailyWeatherDetail> daily;
		String last_update;

		public Location getLocation()
		{
			return location;
		}

		public void setLocation(Location location)
		{
			this.location=location;
		}

		public ArrayList<DailyWeatherDetail> getDaily()
		{
			return daily;
		}

		public void setDaily(ArrayList<DailyWeatherDetail> daily)
		{
			this.daily=daily;
		}

		public String getLast_update()
		{
			return last_update;
		}

		public void setLast_update(String last_update)
		{
			this.last_update=last_update;
		}
	}

	private ArrayList<Result> results;

	public WeatherInfo()
	{
	}

	public ArrayList<Result> getResults()
	{
		return results;
	}

	public void setResults(ArrayList<Result> results)
	{
		this.results=results;
	}

	public static void main(String[] args)
	{
		String origin="{\n"+
				"  \"results\": [\n"+
				"\t{\n"+
				"\t  \"location\": {\n"+
				"\t\t\"id\": \"WTW3SJ5ZBJUY\",\n"+
				"\t\t\"name\": \"上海\",\n"+
				"\t\t\"country\": \"CN\",\n"+
				"\t\t\"path\": \"上海,上海,中国\",\n"+
				"\t\t\"timezone\": \"Asia/Shanghai\",\n"+
				"\t\t\"timezone_offset\": \"+08:00\"\n"+
				"\t  },\n"+
				"\t  \"daily\": [\n"+
				"\t\t{\n"+
				"\t\t  \"date\": \"2019-03-31\",\n"+
				"\t\t  \"text_day\": \"多云\",\n"+
				"\t\t  \"code_day\": \"4\",\n"+
				"\t\t  \"text_night\": \"晴\",\n"+
				"\t\t  \"code_night\": \"1\",\n"+
				"\t\t  \"high\": \"15\",\n"+
				"\t\t  \"low\": \"8\",\n"+
				"\t\t  \"precip\": \"\",\n"+
				"\t\t  \"wind_direction\": \"东北\",\n"+
				"\t\t  \"wind_direction_degree\": \"45\",\n"+
				"\t\t  \"wind_speed\": \"15\",\n"+
				"\t\t  \"wind_scale\": \"3\"\n"+
				"\t\t},\n"+
				"\t\t{\n"+
				"\t\t  \"date\": \"2019-04-01\",\n"+
				"\t\t  \"text_day\": \"多云\",\n"+
				"\t\t  \"code_day\": \"4\",\n"+
				"\t\t  \"text_night\": \"多云\",\n"+
				"\t\t  \"code_night\": \"4\",\n"+
				"\t\t  \"high\": \"17\",\n"+
				"\t\t  \"low\": \"8\",\n"+
				"\t\t  \"precip\": \"\",\n"+
				"\t\t  \"wind_direction\": \"南\",\n"+
				"\t\t  \"wind_direction_degree\": \"180\",\n"+
				"\t\t  \"wind_speed\": \"15\",\n"+
				"\t\t  \"wind_scale\": \"3\"\n"+
				"\t\t}\n"+
				"\t  ],\n"+
				"\t  \"last_update\": \"2019-03-31T18:00:00+08:00\"\n"+
				"\t}\n"+
				"  ]\n"+
				"}\n";

		try
		{
			ObjectMapper mapper=new ObjectMapper();
			WeatherInfo info=mapper.readValue(origin,new TypeReference<WeatherInfo>()
			{
			});
			System.out.println(info.getResults().get(0).getDaily().get(0).getText_day());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
