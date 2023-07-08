package com.renewableenergy.SGS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.filter.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.renewableenergy.SGS.API.WeatherAPIExample;
import com.renewableenergy.SGS.Mqtt.MqttSubscriberImpl;
import com.renewableenergy.SGS.Mqtt.schedualtask;
import com.renewableenergy.SGS.entity.Battary;

@SpringBootApplication
public class SgsApplication {
	@Autowired
    MqttSubscriberImpl subscriber;
	public static double electrecity_incoming = 0 ;
	
	public static double electricity_producedv ;
	
	public static double lectricity_consumed ;
	


	public static void main(String[] args) {
		
    	ConfigurableApplicationContext context = SpringApplication.run(SgsApplication.class, args) ;
    	 new schedualtask(5);
	        System.out.format("Task scheduled.%n");

        SmartGridService smartGridDao = context.getBean(SmartGridService.class);
        
        System.out.println("**** Running ****");
      // smartGridDao.list().forEach(System.out::println);
        
        // Battery
     //   BattaryService  battaryService = context.getBean(BattaryService.class);
        
     // battaryService.addNewBattary(new Battary("Dortmund",2000,1500,true));
      //battaryService.addNewBattary(new Battary("Essen",3000,500,true));

    	//int anzBattry=battaryService.anzBattary();
    	
    	//List<Battary> battarylist = new ArrayList<>();
    //	battarylist = battaryService.list();
    	 
    //    battaryService.list().forEach(System.out::println);
        
    	// SmartGridManagement
    	/* SmartGridManagement smartGridManagement = new SmartGridManagement(context);
    	double test = smartGridManagement.electrecityIncomingCalculator(0, battarylist);
        System.out.println("smartGridManagement = " + test); */
    	//

	}
	
    
    @Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
    @Bean
    public CommandLineRunner schedulingRunner(TaskExecutor taskExecutor) {


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                while (true) {
                    
					subscriber.subscribeMessage("weather-data-test");
                }
                // taskExecutor.execute(MessageListener);
            }
        };
    }

}
