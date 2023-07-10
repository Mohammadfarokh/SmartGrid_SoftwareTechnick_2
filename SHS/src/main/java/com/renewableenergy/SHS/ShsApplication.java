package com.renewableenergy.SHS;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.renewableenergy.SHS.MQTT.MqttSubscriberImpl;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.service.SmartHomeService;
import com.renewableenergy.SHS.service.SmartMeterService;


@SpringBootApplication
public class ShsApplication {
	@Autowired
	static MqttSubscriberImpl subscriber;
	public static SmartMeter sm;
	public static SmartHome sh;
//	public static double producedEnergy;
//	public static double consumedEnergyWithTariff;
//	public static double consumedEnergyWithoutTariff;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(ShsApplication.class, args);
//		producedEnergy = 10;
//		consumedEnergyWithTariff = 10;
//		consumedEnergyWithoutTariff = 10;
		SmartHomeService shs = context.getBean(SmartHomeService.class);
		sh = new SmartHome("smartHome", "Dortmund");
		//add construktor for smarthome
		shs.addSmartHomeObjekt(sh);
		SmartMeterService sms = context.getBean(SmartMeterService.class);
		sm = new SmartMeter("SmartMeter");
		sms.addSmartMeterObjekt(sm);
		 subscriber = new MqttSubscriberImpl();
	        while(true) {
					subscriber.subscribeMessage("weather");
					subscriber.subscribeMessage("Tarif");
	        }
//		System.out.println(producedEnergy);
//		System.out.println(consumedEnergyWithTariff);
//		System.out.println(consumedEnergyWithoutTariff);
//		sh.druckObserver();
//		sh.attach(sm);
//		while(true) {
//			sh.notifyObserver();
//		}

	}
	
//	@Bean
//	public CorsFilter corsFilter() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		//die adresse von webserver
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(urlBasedCorsConfigurationSource);
//	}
}
