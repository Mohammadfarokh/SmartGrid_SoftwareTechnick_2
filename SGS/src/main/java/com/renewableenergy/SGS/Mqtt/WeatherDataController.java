package com.renewableenergy.SGS.Mqtt;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "api/v1")
public class WeatherDataController {
	@Autowired
	private WeatherService ws;
	
	public WeatherDataController(WeatherService ws) {
		this.ws = ws;
	}
	@GetMapping(value = "/weather-show")
	@CrossOrigin("*") 
	public String getWeatherData() {
	//	MqttPublisherImpl kk = new MqttPublisherImpl();
		//kk.publishMessage("weather/topic", getWeatherData());
		this.ws.getWeatherDAta();
		return "Done";
	}
	@GetMapping(value = "/weather-show-all")
	@CrossOrigin("*") 
	public String getWeatherDataAll() {
		MqttSubscriberImpl mm = new MqttSubscriberImpl();
		//return mm.subscribeMessage("weather/topic").toString();
	return "ende";
	}
}
