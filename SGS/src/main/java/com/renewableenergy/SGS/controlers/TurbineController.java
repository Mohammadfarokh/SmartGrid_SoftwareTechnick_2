package com.renewableenergy.SGS.controlers;

import com.renewableenergy.SGS.SgsApplication;
import com.renewableenergy.SGS.API.WeatherAPIExample;
import com.renewableenergy.SGS.entity.*;
import com.renewableenergy.SGS.service.TurbineService;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

import jakarta.persistence.*;

@RestController
@RequestMapping("/turbine")
public class TurbineController {
	 Random random = new Random();
	
	  private final TurbineService turbineService ;
	  
	  public TurbineController (TurbineService turbineService) {
		  this.turbineService = turbineService;
	  }
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<Turbine>> getAllTurbine()
	  {
		  List<Turbine> turbine = turbineService.findAllTurbine();
		  
		  double summe=0;
		  double randumSumme=0;
		  for(Turbine turbin : turbine) {
			  // Sunshine duration
			  //double windspeed = WeatherAPIExample.getWindSpeed(turbin.getLocation());
			  
			  double windspeed = 3; 
			  turbin.setWind_speed(windspeed);
			  
			  double pamount=turbin.getProductionAmount();
			  double randomNumber=0;
			  if(turbin.isStatus()) {
			  // Production (W/h)
			  randomNumber = random.nextInt(10)  * windspeed;
			  pamount +=  randomNumber;
			  turbin.setProductionAmount(pamount);
			  turbineService.updateTurbine(turbin);
			  }
			  
				// set electricity_producedv
			  summe += pamount;
			  randumSumme += randomNumber;
  
		  }
		  
		  if(SgsApplication.electricity_producedv == 0 ) {
			  SgsApplication.electricity_producedv += summe ;
		  }else {
			  SgsApplication.electricity_producedv +=  randumSumme;
		  }
		  
		  return new ResponseEntity<>(turbine,HttpStatus.OK);
	  }
	  
	  @GetMapping("/find/{id}")
	  public ResponseEntity<Turbine> getTurbineById(@PathVariable("id") Long id )
	  {
		  Turbine turbine = turbineService.findTurbineByIdid(id);
		  return new ResponseEntity<>(turbine,HttpStatus.OK);
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<Turbine> addTurbine(@RequestBody Turbine turbine){
		  Turbine newTurbine = turbineService.addTurbine(turbine);
		  return new ResponseEntity<>(newTurbine,HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/update")
	  public ResponseEntity<Turbine> updateTurbine(@RequestBody Turbine turbine){
		  Turbine newTurbine = turbineService.updateTurbine(turbine);
		  return new ResponseEntity<>(newTurbine,HttpStatus.OK);
	  }
	  
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteTurbine(@PathVariable("id") Long id){
		  turbineService.deleteTurbine(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  }
}
