package com.renewableenergy.SHS.Models;

public class WeatherData {
	WeatherData(){
		
	}
	public String lat;
	public String lon;
	public int elevation;
	public String timezone;
	public String units;
	public Current current;
	
	public class Current{
		public Wind wind;
		public String icon;
		public int icon_num;
		public String summary;
		public int temperature;
		public int feels_like;
		public int wind_chill;
		public int dew_point;
	}
	public class Wind{
		public double speed;
		public double gusts;
		public double angle;
		public String dir;
       
	}
	@Override
	public String toString() {
		return "WeatherData [lat=" + lat + ", lon=" + lon + ", elevation=" + elevation + ", timezone=" + timezone
				+ ", units=" + units + ", current=" + current + "]";
	}
	
	
}
