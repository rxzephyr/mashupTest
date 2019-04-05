package com.mashuptest.demo.Utility;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpUtility
{
	public static String sendGet(String url)
	{
		CloseableHttpClient httpClient=null;
		CloseableHttpResponse httpResponse=null;
		String result="";

		try
		{
			httpClient=HttpClients.createDefault();
			HttpGet httpGet=new HttpGet(url);

			RequestConfig requestConfig=RequestConfig.custom().setConnectionRequestTimeout(45000)
					.setConnectTimeout(45000)
					.setSocketTimeout(75000)
					.build();

			httpGet.setConfig(requestConfig);
			httpResponse=httpClient.execute(httpGet);
			HttpEntity entity=httpResponse.getEntity();
			result=EntityUtils.toString(entity);
		}
		catch(ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(httpResponse!=null)
			{
				try
				{
					httpResponse.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String sendPost(String url,Map<String,Object> params)
	{
		CloseableHttpClient httpClient=null;
		CloseableHttpResponse httpResponse=null;
		String result="";

		httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		RequestConfig requestConfig=RequestConfig.custom().setConnectionRequestTimeout(45000)
				.setConnectTimeout(45000)
				.setSocketTimeout(75000)
				.build();
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
		if(params!=null&&params.size()>0)
		{
			List<NameValuePair> nameValuePairs=new ArrayList<>();
			Set<Map.Entry<String,Object>> entrySet=params.entrySet();
			Iterator<Map.Entry<String,Object>> iterator=entrySet.iterator();
			for(;iterator.hasNext();)
			{
				Map.Entry<String,Object> entry=iterator.next();
				nameValuePairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue().toString()));
			}
			try
			{
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
			}
			catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
		}
		try{
			httpResponse=httpClient.execute(httpPost);
			HttpEntity entity=httpResponse.getEntity();
			result=EntityUtils.toString(entity);
		}
		catch(ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(httpResponse!=null)
			{
				try
				{
					httpResponse.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;

	}
}
