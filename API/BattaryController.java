package com.renewableenergy.SGS;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SGS.entity.Battary;
import com.renewableenergy.SGS.entity.Turbine;

@RestController
@RequestMapping("/Battary")
public class BattaryController {
	
	
	private final BattaryService battaryService;

	public BattaryController(BattaryService battaryService) {
		super();
		this.battaryService = battaryService;
	}
	
	
	 
	  
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<Battary>>getAllBattary(){
		  List<Battary> battary = battaryService.list();
		  for (Battary battaryList : battary) {
			 battaryList.toString() ;
			
		}
		  return new ResponseEntity<>(battary,HttpStatus.OK);
	  }
	 @GetMapping("/find/{id}")
	  public ResponseEntity<Battary> getBattaryIdid(@PathVariable("id") Long id )
	  {
		  Battary battary = battaryService.findBattaryByIdid(id);
		  return new ResponseEntity<>(battary,HttpStatus.OK);
	  }
	
	 
	 @PostMapping("/add")
	 public ResponseEntity<Battary> addBattary(@RequestBody Battary battary){
		 
		 Battary newBattary= battaryService.addNewBattary(battary);
		 return new ResponseEntity<>(newBattary,HttpStatus.CREATED);
		 
	 }
	 
	 @PutMapping("/update")
	  public ResponseEntity<Battary> updateBattary(@RequestBody Battary battary){
		  Battary newBattary = battaryService.updateBattary(battary);
		  return new ResponseEntity<>(newBattary,HttpStatus.OK);
	  }

	 
	 
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteBattary(@PathVariable("id") Long id){
		  battaryService.deletBattary(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  }
	 
}
