package com.renewableenergy.SGS;

import com.renewableenergy.SGS.API.WeatherAPIExample;
import com.renewableenergy.SGS.entity.*;
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
		  for(Turbine turbin : turbine) {
			  // Sunshine duration
			  double windspeed = WeatherAPIExample.getWindSpeed(turbin.getLocation());
			  turbin.setWind_speed(windspeed);
			  
			  if(turbin.isStatus()) {
			  // Production (W/h)
			  double randomNumber = random.nextInt(10) + 1;
			  turbin.setProductionAmount(turbin.getProductionAmount() + randomNumber);
			  turbineService.updateTurbine(turbin);
			  }
			  
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
