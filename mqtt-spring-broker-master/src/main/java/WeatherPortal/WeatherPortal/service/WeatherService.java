package WeatherPortal.WeatherPortal.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WeatherPortal.WeatherPortal.MqttConnection.MqttPublisherImpl;
@Service
public class WeatherService {

MqttPublisherImpl publischer = new MqttPublisherImpl();
	
 public void getWeatherDAta() {
		try {
//			 HttpRequest request = HttpRequest.newBuilder()
//						.uri(URI.create("https://ai-weather-by-meteosource.p.rapidapi.com/current?lat=37.81021&lon=-122.42282&timezone=auto&language=en&units=auto"))
//						.header("X-RapidAPI-Key", "1f02b2a510msh6ae2058bc6f3a57p179e5fjsn021c37f149e3")
//						.header("X-RapidAPI-Host", "ai-weather-by-meteosource.p.rapidapi.com")
//						.method("GET", HttpRequest.BodyPublishers.noBody())
//						.build();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://weather-by-api-ninjas.p.rapidapi.com/v1/weather?city=Seattle"))
					.header("X-RapidAPI-Key", "1f02b2a510msh6ae2058bc6f3a57p179e5fjsn021c37f149e3")
					.header("X-RapidAPI-Host", "weather-by-api-ninjas.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
				HttpResponse<String> response;
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			publischer.publishMessage("weather", response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}
