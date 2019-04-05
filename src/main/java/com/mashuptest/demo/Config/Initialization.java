package com.mashuptest.demo.Config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashuptest.demo.Utility.RedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.mashuptest.demo.Config.Constants.MAIN_DATA;

@Component
public class Initialization implements ApplicationRunner
{
	@Autowired
	RedisUtility redisUtility;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		if(redisUtility.getByKey("MainData")!=null)
		{
			String cachedData=redisUtility.getByKey("MainData").toString();
			ObjectMapper mapper=new ObjectMapper();

			MAIN_DATA=mapper.readValue(redisUtility.getByKey("MainData").toString(),
					new TypeReference<Map<String,Map<String,Map<String,String>>>>()
					{
					});
		}
	}
}
