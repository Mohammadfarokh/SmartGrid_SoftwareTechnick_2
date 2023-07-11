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
import com.renewableenergy.SGS.service.*;

import congif.Scheduler;




@SpringBootApplication
public class SgsApplication {
	@Autowired
    
	public static double electrecity_incoming = 0 ;
	
	public static double electricity_producedv ;
	
	public static double lectricity_consumed ;
	
	public static void main(String[] args) {

        //SpringApplication.run(SgsApplication.class, args).getBean(SmartGridService.class);

		
    	ConfigurableApplicationContext context = SpringApplication.run(SgsApplication.class, args) ;
    	 //new schedualtask(5);
	       // System.out.format("Task scheduled.%n");

        SmartGridService smartGridDao = context.getBean(SmartGridService.class);
        

        System.out.println("**** Running ****");
      Scheduler s=new Scheduler();
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
   

}
