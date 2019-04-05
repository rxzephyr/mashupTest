package com.mashuptest.demo.Entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashuptest.demo.Entity.TrainInfo.DetailInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainInfo
{
	public static class Data
	{
		private String flag;
		private HashMap<String,String> map;
		private ArrayList<String> result;

		public Data()
		{
		}

		public String getFlag()
		{
			return flag;
		}

		public void setFlag(String flag)
		{
			this.flag=flag;
		}

		public HashMap<String,String> getMap()
		{
			return map;
		}

		public void setMap(HashMap<String,String> map)
		{
			this.map=map;
		}

		public ArrayList<String> getResult()
		{
			return result;
		}

		public void setResult(ArrayList<String> result)
		{
			this.result=result;
		}

		public DetailInfo[] Simplify()
		{
			DetailInfo[] output=new DetailInfo[result.size()];
			for(int i=0;i<result.size();i++)
			{
				output[i]=new DetailInfo();
				String[] list=result.get(i).split("\\|");
				output[i].setTrainNumber(list[2]);
				output[i].setTrainTitle(list[3]);
				output[i].setOriginator(list[4]);
				output[i].setTerminus(list[5]);
				output[i].setDeparture(list[6]);
				output[i].setArrival(list[7]);
				output[i].setDep_time(list[8]);
				output[i].setArr_time(list[9]);
				output[i].setPeriod(list[10]);
				output[i].setStartStationNumber(list[16]);
				output[i].setEndStationNumber(list[17]);
			}
			return output;
		}
	}

	public static class DetailInfo
	{
		private String trainNumber;
		private String trainTitle;
		private String originator;
		private String terminus;
		private String departure;
		private String arrival;
		private String dep_time;
		private String arr_time;
		private String period;
		private String startStationNumber;
		private String endStationNumber;

		public String getTrainNumber()
		{
			return trainNumber;
		}

		public void setTrainNumber(String trainNumber)
		{
			this.trainNumber=trainNumber;
		}

		public String getTrainTitle()
		{
			return trainTitle;
		}

		public void setTrainTitle(String trainTitle)
		{
			this.trainTitle=trainTitle;
		}

		public String getOriginator()
		{
			return originator;
		}

		public void setOriginator(String originator)
		{
			this.originator=originator;
		}

		public String getTerminus()
		{
			return terminus;
		}

		public void setTerminus(String terminus)
		{
			this.terminus=terminus;
		}

		public String getDeparture()
		{
			return departure;
		}

		public void setDeparture(String departure)
		{
			this.departure=departure;
		}

		public String getArrival()
		{
			return arrival;
		}

		public void setArrival(String arrival)
		{
			this.arrival=arrival;
		}

		public String getDep_time()
		{
			return dep_time;
		}

		public void setDep_time(String dep_time)
		{
			this.dep_time=dep_time;
		}

		public String getArr_time()
		{
			return arr_time;
		}

		public void setArr_time(String arr_time)
		{
			this.arr_time=arr_time;
		}

		public String getPeriod()
		{
			return period;
		}

		public void setPeriod(String period)
		{
			this.period=period;
		}

		public String getStartStationNumber()
		{
			return startStationNumber;
		}

		public void setStartStationNumber(String startStationNumber)
		{
			this.startStationNumber=startStationNumber;
		}

		public String getEndStationNumber()
		{
			return endStationNumber;
		}

		public void setEndStationNumber(String endStationNumber)
		{
			this.endStationNumber=endStationNumber;
		}
	}

	private Data data;
	private Integer httpstatus;
	private String messages;
	private Boolean status;

	public Data getData()
	{
		return data;
	}

	public void setData(Data data)
	{
		this.data=data;
	}

	public Integer getHttpstatus()
	{
		return httpstatus;
	}

	public void setHttpstatus(Integer httpstatus)
	{
		this.httpstatus=httpstatus;
	}

	public String getMessages()
	{
		return messages;
	}

	public void setMessages(String messages)
	{
		this.messages=messages;
	}

	public Boolean getStatus()
	{
		return status;
	}

	public void setStatus(Boolean status)
	{
		this.status=status;
	}

	public static void main(String[] args)
	{
		String origin="{\n"+
				"  \"data\": {\n"+
				"\t\"flag\": \"1\",\n"+
				"\t\"map\": {\n"+
				"\t  \"AOH\": \"上海虹桥\",\n"+
				"\t  \"SHH\": \"上海\",\n"+
				"\t  \"SNH\": \"上海南\",\n"+
				"\t  \"TIP\": \"天津南\",\n"+
				"\t  \"TJP\": \"天津\",\n"+
				"\t  \"TXP\": \"天津西\"\n"+
				"\t},\n"+
				"\t\"result\": [\n"+
				"\t  \"1gLOht1dTQKPjIseOTQFraBYSiI2RyKnc8uNtjHrm%2B2rr1F0uYfF3sgG0O9E6eMqAkDtVH69roLK%0ACJqWsjCmxH53MN6JT0OINpLFR%2BaPcfJdfEfux93LPudjVJLf9mzymKjdQUzpf9pUkubHfu9NXmhh%0AkMIBSPWl7%2FF%2Bz2fbIuqjc2uz9mQ7arM36MzSzsRRPSrqkiUvnrMk92Og2SkQ9rmZKsym1oqE5E7Y%0AvgWCYQCOR8eJJP1lAKizlHMXeVrRV%2BfnAMyx720az1VLVoUGS3cK%2BrOhiUWTClPL%2B83Edi%2Brb0%2Bi%0A|预订|5l0000G10880|G108|AOH|VNP|AOH|TIP|07:22|12:45|05:23|Y|tGPc%2FZq%2FaS2lfry83dzttgM8nl5eiGVAYOGO9YhQ9I%2FsJicv|20190402|3|HY|01|11|1|0|||||||||||有|有|8||O0M090|OM9|1|0|null\",\n"+
				"\t  \"%2BJRsJsVHi25MQ%2FGTUdUN4k6MCs0KtQTloXQbbMxMjLG0ImvEfLKWS2sCnU0hMMO1yg4duRSO%2FJMP%0ANU7F34%2F8D2d1wEIA5zYKCilFDWfmN6%2F5YPzo3Fhl7Ntznm3j%2FVaEIzJzYQ650f2Ed45AIe2fAafu%0AEJByQUm9nzuFRU%2BIrRFVwgd9RX8GTDWOnUq2WNIt0DHXmP8MFf00Eh5mKHOOJQeMPsZLxKDYT0rD%0A1o0NOlFOFB4gr65SxGhHfwlH%2FRs2PMEYrbwV4GkIIdI%2F6Mp37y0uHJJat5eWGEqNOO5gOS9N4Aj3%0A%2BtyqcA%3D%3D|预订|5l000G1232C0|G1232|AOH|DUT|AOH|TXP|07:34|13:45|06:11|Y|Erz4DdOKZcoaehZ7fF49wMm7xiyHqASvw3o4YuAOJz4Usw13|20190402|3|H2|01|13|1|0|||||||||||有|16|5||O0M090|OM9|1|0|null\",\n"+
				"\t  \"y3Z5tJXzq6aWEXuKwvv3oB%2Fyb%2B81bAe291eSay1ouOyW%2BYccIbJ7KzR%2Fo8MCrmWX0S4MiRUxFN69%0ABQgzh8WWWyCU9E7ywyew%2BREoinYOqM5O50TKWdZhv%2BkbqSr40iPyAlYzIEU36xMFFfILa0qGbe%2Fp%0AQTThNkhI%2FGTIB%2B8fKJtu3CWkkLh6cJkrzLCcXui6tLXzHzZ3ZycAvCFUo4Cg3OPIYQYxua2rnmQb%0Aj414PyBqBgnJGmIwpXdtgG%2BzMVTWLwIRWspZSRq4nc5Me8r%2B11ssxZpQ%2BkbIsoXCQ7XLP4UHh4DB%0A|预订|5l0000G120S0|G120|AOH|VNP|AOH|TIP|07:51|12:49|04:58|Y|p1zCX32yo9RR6kpj4CcYoO8qeDD%2BtLsa5TMJPcguH4ISyJZy|20190402|3|H6|01|07|1|0|||||||||||无|有|6||O0M090|OM9|0|0|null\",\n"+
				"\t  \"13Th0MEHrDIX%2Fe7aJGtxdhcLFlrjJc1U%2BQw21sfQOzk4afr77xifo4wZaYNH0radNrhgmHPMYygM%0AV3ioyEI%2FypYc2WW2MYlRyYrm3N2TIy62Ivphg0cYG67kwuaW%2Ffge2ojmuX%2BvuC09IVWwY7p3ds5i%0Af4TLuCBZnJxFq6AEaR4IGKAqEdFXlvr2kiGaAceIFp7dy4qos7VGGFnOkOwLoKHHSWD9UIrn3%2BNt%0A5Z2OGzpnz67EyO1FhbScjQXwRzWKfR6uK18dTxVzXCGXe5vGhfVpoi%2FwUD89ZAJSPCfkbM2Wd9fw%0A|预订|5l0000G11295|G112|AOH|VNP|AOH|TIP|08:05|13:24|05:19|Y|gc5V8GpZYhct%2BtcdP001amqgAbBOC7xnBNVZ5bP7igaG4TR9|20190402|3|HY|01|09|1|0|||||||||||有|6|6||O0M090|OM9|0|0|null\",\n"+
				"\t  \"hYJfHVfbInr2ruPwlQvJkY0zyuUK0z4s7MDg%2FVte%2FiN%2FVaGCzcHDUFHdxXjZOOtJENLDKd%2B1L3xa%0ATmBKwvyr96srMfmDPpqalkwl9UhGIBBniIX7d1G2g%2FNqYuI9OJf6fyRqIk8jwV9v5IBfEBIB7sZn%0AlR1mcYJWnfcmQwFny1VyphsEKduyipwxcaiMrZDzVHqHhvQvwMyRdfu4XDjWw5%2BpdAJa5DevjQ37%0AVQ3O6z9YxVQrasZFS3JBCHfIiIZT9Q8FFsrHMJC6I2b407t88qFuoyDJBSY6RlrAAtbVIHcflw0Q%0A|预订|5l0000G21231|G212|AOH|TXP|AOH|TXP|08:42|14:26|05:44|Y|r9vhFxLqeid6oT1M48Q6YMRb0UZYKSeeryIGICIF5mc3MmwG|20190402|3|HY|01|10|1|0|||||||||||1|有|10||O0M090|OM9|0|0|null\",\n"+
				"\t  \"bu4r7mhgT1U1yFSVp45ZjDU39hHS1OSFlQbHTZrd38Fdt7OLJ6CN7NEugfzQwmQtScc5%2F6z8uaf2%0AbzHFw0wr16q5wmRzZotYjqjExUNvWQWacDdQC1svOgYyCBXj%2F50hZj5AdtDZ241sKl6Zb2ViXqU%2B%0A11rnC6CKD5xIm9ihccndu9qwVqoUYRUoolTCMk4yt96Cs2UF9qEAQ5bhNKvgOdAZVYqk627h3ggE%0A8XOgnHfHZswAnrgVPRHC7Jhrgdx1gcpKrTmMngw5amYTtj7zUiuIkfPp6ZkcECdLOvdqvgXD%2BAZw%0ArAHzZA%3D%3D|预订|5l000G1258C0|G1258|AOH|CRT|AOH|TXP|09:08|14:34|05:26|Y|zL3Yx%2BsSWWAFrpl4zVUTe3rq6MWLrhH91VITVNlnFTo6fMMF|20190402|3|H6|01|10|1|0||||||无|||||7|9|||O0M0P0|OMP|0|0|null\",\n"+
				"\t  \"IQ%2BZf1Pk%2B9Up7A7oja3WW%2BWA3mFWdHZuvVp%2B2Pamri57KGIgBHxbYdhWWzKTjexrb45mC8i6sJPa%0AV%2Br2mADL9ZO5gWrkagh36QeetAQ2hWpjYrADBwMVZV%2B%2FFfIWK6vMs%2BIZklUh5B4NPz5qoNaSqh2f%0AfppSZqJLacADfIvNhDAqTZF2pzt0rLN7Q32P3A8sqv3Ls4oiiAulN1mQHX%2BHUpfv%2FNXwmWSbwNjw%0AvnzHU27Z0thZA%2BqqWkaPR3Lbwi%2B8035Km%2BQuvioOnir%2FDP6vLpiYp%2BRYcPAAmdVkbFr42j7FltL5%0AL%2FPb%2Bg%3D%3D|预订|550000K516A2|K516|SHH|JLL|SHH|TJP|09:16|03:42|18:26|Y|31IrjVC%2BHjXKO3gEYCtaZMHXreTjTHdWIjtY9MXsoiSUlwamU0varoNiM7k%3D|20190402|3|HY|01|21|0|0||||无|||有||无|无|||||10401030|1413|0|0|null\",\n"+
				"\t  \"k%2Fnday6DgPBnIeF%2BKqGi1M8GL%2BFe4kLQ8OJVHpN9y2tkw7vrA1RsX%2FwiY2GPleIqf0w9ew5a%2Frew%0AyABiuXFYGmggjRPiax0McICT%2BE8XTK%2F%2B3mXd87rXZ3y%2FibUWzrVl04wiwJCmbiOULVGXpS1CnQxf%0AWUUwrUfu5iUu9uNbw5qziLyioYfQss9RY%2FzZW9B9XeBDVVAvWfypDARXORJTLnUkJhLytvSdJ9R0%0AFZykWFI9qmox9p0IR7DM55pnaultx6%2B1PJAF7BN3%2B17iigXGh%2B56yYkQcHgMfhwYatrPQmO%2B3iEp%0AxLokLQ%3D%3D|预订|5l000G120442|G1204|AOH|VAB|AOH|TXP|09:39|15:18|05:39|Y|op4t8v1y7%2FGLBqWZA5LZ%2BETlkh3oMbTdw2lve2TlbCWV5HL8|20190402|3|H2|01|10|1|0|||||||||||8|14|无||O0M090|OM9|1|0|null\",\n"+
				"\t  \"BJ4jPATSc%2Fbdo5acYrL4K0qj3AAQfvuSjhSHlmitYcXovF9AwByDe03MDM7oLWLUGpNYsQDn2z0B%0AqLDvMIKbPR5HgGXp5eF6a7FPVxQ2LuLoAzVHyOXeKWNn5ScvPdmvD6mZtlB%2Bhp4bG0aQGxEmu85p%0AenHDlrfUTNzUID4GziL1f3KI0UBoGNeOaz2cHusX8xMj8aKoks7OEOJN98KPEwrmIS8YL8QGdjWD%0AooeNGQCdhd%2BABvymhq6h7f8liCBT%2BJw4a4XmSVEoydIM%2FtAMjMbFxdsIDAKulutQNpjBSEpCQYU6%0ASc1mew%3D%3D|预订|5l000G121490|G1214|AOH|CCT|AOH|TXP|10:20|15:50|05:30|Y|QTR7udHQcTXDKrihlLfTplHG%2FoxBmQIq87TxwjnPcTfHm4vr|20190402|3|H2|01|10|1|0||||||无|||||无|1|||O0M0P0|OMP|1|0|null\",\n"+
				"\t  \"|预订|5600000G4200|G42|HGH|VNP|AOH|TIP|10:26|15:31|05:05|N|1WhTSvkw%2BvJHfxfOZe3GR42F1i67sqBAIKkRJYJXNNsasH6L|20190402|3|H6|04|11|1|0|||||||||||无|无|无||O0M090|OM9|0|0|null\",\n"+
				"\t  \"WeXrPLu4ZDH8G%2FqGl%2Fmu5AK%2BuoNR%2B7Xr87gURdiAr1KWJ7YtWb52l5S1gm2wtleO7UxEElAWiFqJ%0AfS3Itl58H%2FG2VZk9KgbTU%2B6DVh8Xcn92sHUJorW9GMWJKZLRxvkh8eOrJ4kmAwaIN%2Blw4O5AmSKL%0AeuGe%2BLHcVD%2BrOl32l9bBDFp4DX5s3xnUTG9UUmM9ybQ1%2BX4f4F8i9vghMxg9iTF5H5wzWpoVCcgI%0ABTGtZZxPUHNU0r%2BGaGu%2Fgjx%2BC3LeUwzy2rp%2F6vGMQSHW8DabzDBhV7T84jocDwM%2F0fmZ6ZCspX5c%0A|预订|5l000G123690|G1236|AOH|CCT|AOH|TJP|10:36|16:24|05:48|Y|nTL%2Fp9MijrQx30UrODG9aK%2FfBiGule4DRqT3Cy4lJBY3CGCs|20190402|3|H2|01|13|1|0||||||11|||||9|11|||O0M0P0|OMP|0|0|null\",\n"+
				"\t  \"%2BfSAv0Zo9Tj3Nxahgc6Lf3RxTnxsuPbo6wikOo8iVQ54znQQH6HLL4DalRO52WCpQp57rEOHFDRN%0AwJ988DQOcOd0K1cwZMC4SUiF4F3a8556GHjBmYB9euCshRd90hqI5mzuFX66idKgzp4BICGKHL%2BS%0AQwCdr1QPrXpZO8SR8uclTUb0ZFACdmQYwmIsDyD7kWSx9Wt1X1PF%2F%2BvnPIps5xYYqmoktgyCbxUm%0AQk%2B39b1J8m3DAEKzSRHX1DgID9oRJ2bJ7%2FpPl226ebE1J6hFGn4AZjtd09jtNg79WA0fe6%2FwPAMD%0A|预订|5l0000G12601|G126|AOH|VNP|AOH|TIP|11:05|16:29|05:24|Y|UhUSlTYbEDb9PmPiDjwW4noA%2FsXCEEPTKSemxUwN6HH4X6Ct|20190402|3|H6|01|11|1|0|||||||||||有|有|6||O0M090|OM9|0|0|null\",\n"+
				"\t  \"Yb%2Bx%2B2vIeoqNwcovL50sZqX4PcDt5HqiNjNYAbqkAmpI7gBdDCC7aSAIuO8T%2F0wopL9shheJNF94%0A8KP8aD%2BWWmcEud40yXyWWMnZbBdErYjihqL%2BY2QiuOs9nRnkjeAuGoYxWmn1DNmhwapMwzdQ8S7C%0AgbpoNSOp3scsD8CWXO5G0GW4UA1YxxDhtSTc8gLAZ269HZUyUQkmwKX81U9YmN2y%2Fafg5TqK5Gl0%0AfQS4sJvPTOHD8AkwgcAtoDHQznd%2BU3luJ3r3yx2tEyfWsb%2BN0%2BS8ELEoM8HRaPx6jlG5Ft6phPa0%0ANAZrcQ%3D%3D|预订|5l000G125280|G1252|AOH|DFT|AOH|TXP|11:10|16:56|05:46|Y|KmHOiQLjIpXoWs%2FiUyr6WBoGwDqBAHMq7YGmcyeYgqm4zFxA|20190402|3|H2|01|11|1|0|||||||||||有|无|无||O090M0|O9M|0|0|null\",\n"+
				"\t  \"|预订|5j000G1228A0|G1228|CEH|SBT|AOH|TXP|11:25|17:08|05:43|N|HUBjbouncRIq2eZ99VdfFdLL%2FM0y7vzhk6pbJghyGH9ycdK8|20190402|3|H6|15|26|1|0|||||||||||无|无|无||O0M090|OM9|0|0|null\",\n"+
				"\t  \"uT3C80Wa3LuQ29GHsDkpwCkgLW3spnbM8W7tC59JbhX%2F39m6PP7NkXPjA0qcXAN4VuYuE6SBSjcd%0AxyWR%2FJ5VHy%2BRLdkmZtfuxFyab4yJW%2BD8%2FpeP777bKpApjrSf0KsmonO3s4DjqMyTqwm%2BYoc2gJsP%0A1J2k7fb0wBCFZIt8ecXdHhSzIZETTs57j90aVSsD8x8k9vDZ%2BrKWtU%2BmvUnXyPV4KHxgTgOw8LZ7%0AKryb2sB3kMC%2Bm7XKWv05%2Fh%2F4d%2BUrjvH5L0WB87OQz3rjdXSRRyIb4dzeyEeJofsUKY90KK9TWqBR%0A|预订|5l0000G132E0|G132|AOH|VNP|AOH|TIP|12:17|17:49|05:32|Y|LhD71XpPC3rh8sD1yAzRjJjDMVLxV%2BSJQcp9aDfmcBfWemnd|20190402|3|H1|01|12|1|0|||||||||||有|有|5||O0M090|OM9|0|0|null\",\n"+
				"\t  \"T6yReotE4OLlxpthMBOZAYT3q%2BD%2FdC8t%2FMs5g%2F7Td5JlC9Tr2iaJ9zjLFGKcA4LlNFTRa%2BiKste5%0Ax6UI34JOI2kZCa1otSRDYhd1cmcwe1wE7ig%2BWvRajiFf%2Bv06F8CC1VtIaGIzlGaBJKUkXIPJmO2x%0AdHIvMOjZHsq02NVh%2FQt6F%2FqaOn4%2BMS%2FuJCu%2BMe41EH%2BS037DeJZU%2FBEDVRLw0fKntRwYm%2Fh4FOex%0ADa83Ik415IpHw29c5vrFCQ173kZkUYhKwDP1G%2FyRpTaTeJjQfD1embxFei6031KKz0maEwF23DC6%0AJtDyIg%3D%3D|预订|550000146200|1462|SHH|BJP|SHH|TXP|12:18|07:44|19:26|Y|1ZrHL5VuECcwpyC5skg%2BSCTalhaxfg%2FMPAIU5pJqZ%2FPAh1NtAhd19Z%2Fdq%2FI%3D|20190402|3|H2|01|20|0|0||||8|||有||无|有|||||10401030|1413|0|0|null\",\n"+
				"\t  \"kpAn7z8l3N9TBnAQqXPhIL7uJ0tG%2Bbi65kuOzVw04pROiZZ5eb8%2FpHDAfBfQCwn7oxSKhXI8kQhf%0A9TWlHJN9cAFkc9P27PUmv9qPnBWaUBWwNh3OLDySBkBbCmmd6YeYbOAcQP6zNRoRAs9bAKGaOLdQ%0AcxQBgMYWUShPxAXlTNkUM857X3%2FQQuj3xqVVMimgTf1veEHFgbXmjqT5h8hLp122RaER7dcpM0QU%0AZ%2BYrldRr8Lb2LfTozb9sN1bASo6trO19Om9kqKGFduKSiK9hBN8qo6cEubqK9XXHKpi43JwwCYmm%0A|预订|5l0000G134B0|G134|AOH|VNP|AOH|TIP|13:00|18:21|05:21|Y|bLal0W4cjSregG3EqZG8%2B4LbqOSewp5Npd%2FQi2xlu5j7iFUF|20190402|3|H6|01|10|1|0|||||||||||有|16|8||O0M090|OM9|0|0|null\",\n"+
				"\t  \"76oLj5hq0iHHtW4NIb72hUxEamMug%2FgCmVZeyZqo6uf2YXbReyHd9Bw%2F648lr4MCqihP0Hl5k4Lx%0AgMPmPgaGAs5SKvZno9kWP983QHeKOjzIFDlCIiNEFZZSJNeil%2Bl51f%2FgQ06OXAD7aNAvT07g4Bhp%0AEtah6yvR9QrfQZcmgN%2BKgYGGfIJIJQjk2QFSdwO3pygiei3xNWWuoIiPVUy1U9j7JP%2FQ6QeE61Tg%0Alo4w%2FXZSKpdNQztoUbQalF9xaddzkOVVtsA0zIslsAaf7Wtk5E8p8qTAsoIxGW0J0148ugk%2BhQnF%0A|预订|5l0000G13861|G138|AOH|VNP|AOH|TIP|13:29|18:49|05:20|Y|mlbAiABFFAvB5OoCFHVQWetfI6ilPUr1DRCxNIFMzkcrtISO|20190402|3|H6|01|11|1|0|||||||||||有|8|4||O0M090|OM9|0|0|null\",\n"+
				"\t  \"v6KFcFOk11nyUue8dp2w2GyIeXLH4wMjCZUq%2FRZmXcQJ9LpFPbJLHvUSacwCRaLuAFogT6nSpXcJ%0AaK2ZWbGnnLx7yebPTlPB90pM8Rw2mlzXmJLND4%2BU0S878v7bKz5wSoVWNrSebpv4QmKIK1eWS2QS%0A%2FLofjEPX1seHejdvs7IFqQWYU4vePUpi0LRcf5MjqihUBlpB7VOZm1T0L%2BOAO3tNGIxMIGSxIajz%0A5Wj%2FeG%2FqDdSkudoRah%2B8ndDFshN0A%2FuDD3VMLS1glk%2BE9tUuFnLCjxtiesc8Y75SW%2Fkmux5HY8I1%0A|预订|5l0000G14051|G140|AOH|VNP|AOH|TIP|13:34|19:05|05:31|Y|kFicJxyy%2F6rMmUv1uIu3pYxQUYKpRP3FZdMQXvOP80mxiM43|20190402|3|H6|01|12|1|0|||||||||||有|8|8||O090M0|O9M|1|0|null\",\n"+
				"\t  \"sZQOD58MaWO3VXbeKcAprhoXIrE6YKJOnkFHGPsL5DF53QP%2Bues24nbO0RB7AX8Q2dZaMcor5sZV%0Ab%2FjFIM1WhkFV1CwcQ%2FpT2sQ6ddtbEWWaFdGG1EV0ZoHS9G%2BTr4z4cfJDUHmdGUTI6rBvdFdH3qmd%0AbmFDDiWdcHv83LfseLowsqWMV1sZV4lIHZomKNfikUKnG0wWNGO3SK3jpQObB3C%2BMM3gGOpkRyqD%0A30s8FXY%2Fd8rfH2YT123RybYTR2rI8neVnYGiJRjru7e4JE4pZaksvMnNejc%2BuFX6RzE1g7kXb7w1%0ATElQ9g%3D%3D|预订|550000T132C0|T132|SHH|DLT|SHH|TJP|14:23|05:04|14:41|Y|AZJV7pGSNfsWOzl6jkZVk7Ewu2ihNfkxn760VlBAHwIWKthAqOJEQWbQajk%3D|20190402|3|H3|01|12|0|0||||8|||有||无|无|||||10401030|1413|0|0|null\",\n"+
				"\t  \"pJg8LNWA954Vf0cRVi%2BN8smO6rDfYqZsCTWwUjSZOmI2hNLxNcJ0H95LAbkwySg2jj%2BSOkutEX4w%0A3OY%2B4t4dAJEFAdHV9F56Uk%2B9P2Z18s1rrQ7OFPDv3XGpjcSjQTrvABx8saA0UJ7gQTk4cmM7Pxni%0A4LeF7gf%2BySjSg2pN8wgjPF7q0YoqQHG56FMvyxWY99fDmy%2FjgQvZ3wrb4H7URX21EFmIj6SP4xTM%0AHIWz9zwx7viC5ihYtfGjc4dJTTz4nPB%2FDpmzhuuEeNbBC%2Bf6v8lYO6%2FjUMqYdWALiQFvAXVoolY3%0A|预订|5l0000G146F0|G146|AOH|VNP|AOH|TIP|14:52|20:08|05:16|Y|%2FTv3yRvyqVtO3cre34rK%2FVdz9%2Fusfcm73ags3WIQRj9qZD6v|20190402|3|H6|01|09|1|0|||||||||||有|有|8||O0M090|OM9|1|0|null\",\n"+
				"\t  \"0rvabMoOmTLB1P%2BAr8UA%2F3bsLmzqb%2FGE6GAHSZ7KbAtN11lKNNTnlWEZnPAkteCJt7f38V4Bm5oq%0APZgqP1USpHG44P92IfWpV2b5IsHqwRdYNk2jiIaXZ8JMFrkjDpmfQSFJtm9gP2h7iRU9kQ%2FgN%2Fm1%0ArMfmsqIXzC7cBoFk8j8Av7gFBTC37B%2BYq8m2%2FApLuwG91HUyYb6XL9wqoS%2BYt0w9fbeSz4r%2Fpp%2Be%0A12df6VSGtxvCmxoTqT6G2VoB4CUw966zbZlaL5%2Fn8m%2B%2BJr5B%2F7ydfT9aSEArOQf0lKBt%2BWHuoY55%0A|预订|5l00000G1443|G14|AOH|VNP|AOH|TIP|15:00|18:59|03:59|Y|k2GUxpVDjFNPWdj6D78TBjO2JQApUogKVsUnxARy9K8haMoK|20190402|3|H6|01|04|1|0|||||||||||无|8|5||O0M090|OM9|0|0|null\",\n"+
				"\t  \"|列车停运|5l0000G214D0|G214|AOH|TXP|AOH|TIP|24:00|24:00|99:59|IS_TIME_NOT_BUY||20190402||H6|01|09|0|1|||||||||||||||||1|0|null\",\n"+
				"\t  \"NFroMILhSysiewocp6U%2FrWEOVtPYV5eF8mMlzgaDhfkF6v1UFn%2FyeET9Vag83hodVzrOqYjHLBRq%0Ab%2B8SQMPiCB7JrZiwyrA0tUNaZevwrGop7%2BUwpQ0n3G35ms%2FujoyICg2yoCoKJPYt3eh%2BWahMiHqk%0AV9OPhVIWP8%2BVh3w7126MY8WRjNGKeOAy6Y0alMi7AoBkmSM55IQwUPRw3B8Anj29uTDWxIRmG%2BDr%0A7VS6DbrBq%2FwQYkGgE6kJeFVYXdmA7Htd2cUB8UGY3eX40OTYSRFzNCyPkutjrAHVf8iFEhhCaltk%0A|预订|5l0000G152E0|G152|AOH|VNP|AOH|TIP|16:18|21:35|05:17|Y|Lz20IFGAP1UZMN18e61mFLIYbXVObKJ6Qj%2FVphcO6K9v4MBE|20190402|3|H6|01|09|1|0|||||||||||有|有|19||O0M090|OM9|1|0|null\",\n"+
				"\t  \"%2BHWQ1V63c23T%2FIudhH8vMDTTac5dChUeSCIHxuZUcUDL%2FwwbLS%2F01kKIsrwy2%2F%2BnI5acEuZ%2Briks%0AQiRMOeAKNVpVqd9dYnhColMBe7IPd%2F4m7Zc0PRY4Ohv10Zw1GYbOy0uSPTNOise6T4%2FdUXhbTltl%0AzAimg6KQfT32CcRXMxjBriCxsX5wDgonqAXw2AXMja2cFzBvZn%2BkUD%2B7rF%2BQ%2BavHHC1vIaqfEj1N%0AbvLpu2IpEGJknHJuwBEek2VVUCIdQrLioHc%2FuyksTUqdEXjDvIv8ewRafoZnkVCZyd%2FrcL%2Fc2qBP%0AnE1jgg%3D%3D|预订|5600000K4830|K48|HZH|QHX|SNH|TJP|16:34|12:52|20:18|Y|5aqRIIfzkdHPlbCCO3bQ1FkArtmr6FKfEYWX%2BTnSftJaGStrrgL73wiGFjs%3D|20190402|3|H6|06|29|0|0||||6|||有||无|有|||||10401030|1413|0|0|null\",\n"+
				"\t  \"|列车停运|5l0000G21680|G216|AOH|TXP|AOH|TXP|24:00|24:00|99:59|IS_TIME_NOT_BUY||20190402||H6|01|10|0|1|||||||||||||||||1|0|null\",\n"+
				"\t  \"oH8l6D4H1VAJuDZ5Y%2B2jWlvEdZPy6RpTbwhfwGmXdpogU1IUoJPV1N6LJkiFrmz7PxdZzn%2BqT1CF%0APL9jpktPOnwtKymCIq1hPIrMlY3zQw4%2BOiaMP0pW87au7PLYOLr9ifOGRQkgOSEtwH1wZYF5jnZW%0AOVlQx85rGj%2FoRXPKCFry25S8JkgU5NVqDvyN8XNBSXdF35xWZPQ9zgfveaJTQ%2FcFNkd1ISEVFcuw%0A9gdJN55%2FxJ1dWvjxSp%2BQzyYRyhvA88dflptGCgSEkx46L2G%2FkGDFjLp7sv1HgZK%2FXLf6I9U40jDn%0AIcIk2KEsqbGyASKTbfV43w%3D%3D|预订|550000T11062|T110|SHH|BJP|SHH|TXP|17:57|08:41|14:44|Y|t91tRt07dAqsuepfAiIWssMRzbGn4%2FfH8FZBdz7xoj2mM%2F4Zqj1YKJMr9yBDLw8un7oW%2BT9eqxk%3D|20190402|3|H3|01|09|0|0||9||有|||有||16|有|||||1040601030|14613|0|0|null\",\n"+
				"\t  \"MY75bgxi9Of20xXiVePAw0uI%2BS8E6KSXbP4lAveoPMJ1EecTqHtvnvqZDyTDTkYG9n%2F5DheQV661%0ANXwaI3mVVG8Y8FBMR9Vy0y5oCfHhfV%2FMJAUfQR1DVuj35Kj4gN%2BINnKj%2F4AnwRPKqEw%2FgV1fLlHC%0AKM%2B4FWmFA4ZK6imxLYjDxDKN8t90oYg4KnI5Wczw3yzvfX4%2F0bQf3x%2FoDsY3PeFgp675amYMmz19%0A1TqNPSi8guKNWiicb22Kg2bG2Tre6SPA4LdZrhg%2BagI%2BTiVI5yqJEF81ZXQrEDD%2FzRyfeUTaL5NP%0APtSbiQ%3D%3D|预订|550000K188C0|K188|SHH|SBT|SHH|TJP|18:09|12:26|18:17|Y|Lkpn3R2ACHIRlQa7EvRQ4V41qyictsgtpB3wdQ2nY%2Bap%2FFtjV8fbjLu16ws%3D|20190402|3|H6|01|19|0|0||||7|||有||4|有|||||10401030|1413|1|0|null\",\n"+
				"\t  \"xOsKOvOCYuYvpjO1XT64o8rNfUZbpmnaKiOZnmLi4xsteLszkJe%2B1KdLyWEt%2B1crRviX5m8GJrx7%0AYDqQY156OW9VmR7hTEjupF%2FyszDdKBTn2n0%2FYiQEWDKIxSZKkf3QMXBqpePH9Ojay%2FV%2FVuYyaNJl%0AcVbbunVw6Hpo9ShiQn2mX%2B7zSnctaAAyp1H6SlxlnrSqZguC15jYNk5R8HiMBUXMvYQk9TI1MYq3%0A4V2X9rV3QgpjFMn%2BksSYwfU9BZB9%2BmgXBl1dfsNY6YHhGt8eeKjXcv3cX6ku%2BVaXpj5lWW9x0ddu%0AjwmH0w%3D%3D|预订|550000Z17250|Z172|SHH|VAB|SHH|TJP|18:56|07:19|12:23|Y|da06rgN4Lq38hatFUXaBpJ2RzT6bwfcdxYlyrY8qJZZKp6TY9zCih9A3J1Q%3D|20190402|3|H3|01|10|0|0||||无|||有||无|1|||||10401030|1413|0|0|null\",\n"+
				"\t  \"3XNtu3fBZcU77t4f%2F3UUqzBwBNm4E9jxOcK9j1THgKc2Lo0WBr7KgMtNyl70iQvQ44gMXTCV89uY%0AiDDzsay5eX3P7igbju5K5hDgSZkNbt%2FhF0H%2BajOK415RjiVkFSWArEQoD9oqtAHNh1qYtS4MBOYv%0Ah9sMvnibkCenqvYhdOQrH%2BfPYG75NNpWh8%2Fn9xOydd4YmTa%2BzPLplyFboMq9%2FAPQY7G%2BFdZC0mne%0Ah7toxFo3YyA1OfozOWfAbg9Zvyy6th%2B3t0rVpCkwe9Rjju7KiY1HwjRtDs78kYOzbdoJluElSTpx%0A6wnnFRXdRTQ%3D|预订|560000Z28230|Z282|HZH|BTC|SNH|TXP|19:30|09:03|13:33|Y|8wQ%2F8beOJlv6Ut3l8aLbbboqsmEKJExGCGkE5WUKM8sKEFl2QnP09VttaJE%3D|20190402|3|H6|04|14|0|0||||无|||有||无|无|||||10401030|1413|0|0|null\",\n"+
				"\t  \"odhkXUifQVyfRJixYjOJJzYUfWT57rNucr36bV0qENvMo1FOdZa9RSi%2FcNSlVPvDEizsC%2FGHyhce%0Aa0PE7pINqPXr2Hb8eVuSZSvvy0az7toiZ28lfV7YwY2XWYcr1ZSRLRpJISEMopxzoxB0wTySwaL1%0AvHjInxKiggNghC2IsF%2BuhGKArJ%2Fptt37POe9JIfdyhZ7Hc7KUShADqh8s2fOiQr5ukmDdaiVuB9F%0AYhpfgp7ITHc8wppGfAGES3thXBXYmyLWXHfkwjrlLrhvdIdLwcp06wCaZsfipSz70xX3YwL%2Fo64I%0ApRynLg%3D%3D|预订|550000122891|1228|SHH|FXD|SHH|TJP|20:22|14:59|18:37|Y|BOc0%2B4Zh%2B2H7vf66C6GVwRQZIhV%2BY677qJSkesgHEZ5NcbUTEpRqERBhB64%3D|20190402|3|H3|01|25|0|0||||8|||有||无|无|||||10401030|1413|1|0|null\",\n"+
				"\t  \"KbEAqbckgLPK9OlfyRY4Cnxl29R4bmoaE2lVT8CCVXMNSor0bw4SM2D96eVixGUFL3rmASlD6Z4I%0AfbrEPUdQQDpAkGNHVbclz1tWmFvZSDnjnKnoWPR1zmfMAc2KKpj%2B%2FP9xNZFZu%2FXPPsRLw8rlWnb3%0A8X3vz1dL165K6uLPzwOQfcwrL1jp6uyR61UC3qrh40y1qzWsjj%2BlYwYmmxL4Xy%2Bd2sJgGVdY1UMa%0Az8YWm5Srh10BlOrE8dpclk0%2FkaOMZaLiMO9M71GAVB4uHbRcg%2Bgc3yN5WpgpbXGbzOH9LXuv8NSd%0AuTQAUg%3D%3D|预订|5e00000K76C0|K76|NGH|CCT|SNH|TJP|21:16|14:40|17:24|Y|mINY3W37PZSB%2BUPkHmsP7EDTcIWwHtriouZz1%2FrHDf%2FMV3gZ4HcZXUSF6co%3D|20190402|3|H3|09|25|0|0||||无|||有||无|无|||||10401030|1413|0|0|null\",\n"+
				"\t  \"T9%2FBH7ZxZFORQJNhtr2%2B1Z98qCmmF9ZWOivYP0H2BExgIdrHBlZ6m%2F2%2FbajABtMwIW79Cb6aC%2Bxs%0AOCAN4U1NommyTK5cPnNnukuTE32uhruX7RC%2Fa7lTGvILOkymNNTx8UlHZS2petcfnlEYIUttMbpC%0A0OfQp64GsXXf8VIzBlRYGLlB55gQhjqBa9nCZGqU8PQJh5MQ8BOW4sqnJaX2iqhZ8D9MFA8T%2Fqt0%0Abe4%2Fbv9f6UqvJ%2F4QQxe%2B8AgDMtTyxqHmovyxQEd27qwrfL9VvsZPqa32btJFwPz97Q%2F022s%3D|预订|550000D70600|D706|SHH|BJP|SHH|TXP|21:18|08:08|10:50|Y|HauUQSArlhC%2BGbGf5njeC4TwOmekrjn6EkvWdxDL9EZng5mj|20190402|3|H6|01|04|1|0||||5|||||无||有||||O0I0J0|OIJ|0|0|null\"\n"+
				"\t]\n"+
				"  },\n"+
				"  \"httpstatus\": 200,\n"+
				"  \"messages\": \"\",\n"+
				"  \"status\": true\n"+
				"}\n";

		try
		{
			ObjectMapper mapper=new ObjectMapper();
			TrainInfo info=mapper.readValue(origin,new TypeReference<TrainInfo>()
			{
			});
			DetailInfo[] detailInfos=info.getData().Simplify();
			for(DetailInfo d:detailInfos)
			{
				System.out.println(d.getTrainNumber());
				System.out.println(d.getTrainTitle());
				System.out.println(d.getOriginator());
				System.out.println(d.getTerminus());
				System.out.println(d.getDeparture());
				System.out.println(d.getArrival());
				System.out.println(d.getDep_time());
				System.out.println(d.getArr_time());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
