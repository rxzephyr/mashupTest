package com.mashuptest.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainTicketInfo
{

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data
	{
		@JsonProperty(value = "OT")
		private String[] OT;
		@JsonProperty(value = "WZ")
		private String WZ;
		@JsonProperty(value = "M")
		private String M;
		@JsonProperty(value = "A9")
		private String A9;
		@JsonProperty(value = "9")
		private String _9;
		@JsonProperty(value = "O")
		private String O;
		private String train_no;

		public Data()
		{
		}

		public String[] getOT()
		{
			return OT;
		}

		public void setOT(String[] OT)
		{
			this.OT=OT;
		}

		public String getWZ()
		{
			return WZ;
		}

		public void setWZ(String WZ)
		{
			this.WZ=WZ;
		}

		public String getM()
		{
			return M;
		}

		public void setM(String m)
		{
			M=m;
		}

		public String getA9()
		{
			return A9;
		}

		public void setA9(String a9)
		{
			A9=a9;
		}

		public String get_9()
		{
			return _9;
		}

		public void set_9(String _9)
		{
			this._9=_9;
		}

		public String getO()
		{
			return O;
		}

		public void setO(String o)
		{
			O=o;
		}

		public String getTrain_no()
		{
			return train_no;
		}

		public void setTrain_no(String train_no)
		{
			this.train_no=train_no;
		}
	}

	private String validateMessagesShowId;
	private Boolean status;
	private Integer httpstatus;
	private Data data;
//	private String[] messages;
	private Object validateMessages;

	public String getValidateMessagesShowId()
	{
		return validateMessagesShowId;
	}

	public void setValidateMessagesShowId(String validateMessagesShowId)
	{
		this.validateMessagesShowId=validateMessagesShowId;
	}

	public Boolean getStatus()
	{
		return status;
	}

	public void setStatus(Boolean status)
	{
		this.status=status;
	}

	public Integer getHttpstatus()
	{
		return httpstatus;
	}

	public void setHttpstatus(Integer httpstatus)
	{
		this.httpstatus=httpstatus;
	}

	public Data getData()
	{
		return data;
	}

	public void setData(Data data)
	{
		this.data=data;
	}

//	public String[] getMessages()
//	{
//		return messages;
//	}
//
//	public void setMessages(String[] messages)
//	{
//		this.messages=messages;
//	}

	public Object getValidateMessages()
	{
		return validateMessages;
	}

	public void setValidateMessages(Object validateMessages)
	{
		this.validateMessages=validateMessages;
	}

	public static void main(String[] args)
	{
		String origin="{\n"+
				"  \"validateMessagesShowId\": \"_validatorMessage\",\n"+
				"  \"status\": true,\n"+
				"  \"httpstatus\": 200,\n"+
				"  \"data\": {\n"+
				"\t\"OT\": [],\n"+
				"\t\"WZ\": \"¥553.0\",\n"+
				"\t\"M\": \"¥933.0\",\n"+
				"\t\"A9\": \"¥1748.0\",\n"+
				"\t\"9\": \"17480\",\n"+
				"\t\"O\": \"¥553.0\",\n"+
				"\t\"train_no\": \"5l0000G10200\"\n"+
				"  },\n"+
				"  \"messages\": [],\n"+
				"  \"validateMessages\": {}\n"+
				"}";
		try
		{
			ObjectMapper mapper=new ObjectMapper();
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			TrainTicketInfo info=mapper.readValue(origin,new TypeReference<TrainTicketInfo>()
			{
			});
			System.out.println(info.getData().getWZ());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
