package com.renewableenergy.SGS;

import org.springframework.boot.SpringApplication;

import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.renewableenergy.SGS.entity.Battary;

@SpringBootApplication
public class SgsApplication {

	public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(SgsApplication.class, args) ;
    	

        SmartGridService smartGridDao = context.getBean(SmartGridService.class);
        System.out.println("SmartGridDao");
        smartGridDao.list().forEach(System.out::println);
        
        // Battery
        BattaryService  battaryService = context.getBean(BattaryService.class);
        
      //battaryService.addNewBattary(new Battary("Dortmund",2000,1500,true));
      //battaryService.addNewBattary(new Battary("Essen",3000,500,true));

    	int anzBattry=battaryService.anzBattary();
    	
    	List<Battary> battarylist = new ArrayList<>();
    	battarylist = battaryService.list();
    	 
        battaryService.list().forEach(System.out::println);
        
    	// SmartGridManagement
    	SmartGridManagement smartGridManagement = new SmartGridManagement(context);
    	double test = smartGridManagement.electrecityIncomingCalculator(0, battarylist);
        System.out.println("smartGridManagement = " + test);
    	
	}

}