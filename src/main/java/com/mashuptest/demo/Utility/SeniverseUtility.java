package com.mashuptest.demo.Utility;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Date;

public class SeniverseUtility
{
	private String DAILY_WEATHER_URL="https://api.seniverse.com/v3/weather/daily.json";
	private String WEATHER_API_KEY="lqoxwdsgeirygqph";
	private String WEATHER_USER_ID="U5C3BCABC0";

	private String generateSignature(String data,String key) throws SignatureException
	{
		String result;
		try
		{
			SecretKeySpec signingKey=new SecretKeySpec(key.getBytes("UTF-8"),"HmacSHA1");
			Mac mac=Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHmac=mac.doFinal(data.getBytes("UTF-8"));
			result=Base64.encodeBase64String(rawHmac);
		}
		catch(Exception e)
		{
			throw new SignatureException("Failed to generate Hmac. "+e.getMessage());
		}
		return result;
	}

	public String generateGetDiaryWeatherURL(
			String location,
			String language,
			String unit,
			String start,
			String days) throws SignatureException, UnsupportedEncodingException
	{
		String timestamp=String.valueOf(new Date().getTime());
		String params="ts="+timestamp+"&ttl=30&uid="+WEATHER_USER_ID;
		String signature=URLEncoder.encode(generateSignature(params,WEATHER_API_KEY),"UTF-8");
		return DAILY_WEATHER_URL+"?"
				+params+"&sig="+signature
				+"&location="+location
				+"&language="+language
				+"&unit="+unit
				+"&start="+start
				+"&days="+days;
	}

	public static void main(String[] args)
	{
		SeniverseUtility seniverseUtility=new SeniverseUtility();
		try{
			String url=seniverseUtility.generateGetDiaryWeatherURL(
					"shanghai",
					"zh-Hans",
					"c",
					"0",
					"2");
			String result=HttpUtility.sendGet(url);
			System.out.println(result);

		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
		}
	}
}

//TODO 完成对json数据的解析，可选手动或者建立Entity对应
//TODO 增加持久层，即redis的模块
//TODO 设计展示模板
//TODO 完成对数据的操作逻辑