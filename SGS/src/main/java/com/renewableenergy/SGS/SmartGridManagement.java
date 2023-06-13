package com.renewableenergy.SGS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.renewableenergy.SGS.entity.Battary;



public class SmartGridManagement {
	
	private double electrecityIncoming;
	private double electricityConsumed;
	
	ConfigurableApplicationContext context ; 
	
    public SmartGridManagement(ConfigurableApplicationContext context) {
		super();
		this.context = context;
	}
    
	SmartGridService smartGridService = context.getBean(SmartGridService.class);

	
    
    // Battery
    BattaryService battaryService = context.getBean(BattaryService.class);

    
  //battaryService.addNewBattary(new Battary("Dortmund",2000,1500,true));
  //battaryService.addNewBattary(new Battary("Essen",3000,500,true));
    int s;
	int anzBattry = battaryService.anzBattary();
   
	
	//List<Battary> battarylist = new ArrayList<>();
	//battarylist = battaryService.list();
	 
   // battaryService.list().forEach(System.out::println);
	
	
	
	 public double electrecityIncomingCalculator(double electricityConsumed,List<Battary> battary) { 
		 for (int i = 0; i < anzBattry ; i++){
			 electrecityIncoming += battary.get(i).getSaveAmount(); 
			 }
		 
		 return electrecityIncoming+electricityConsumed;
		
	 } 

}
