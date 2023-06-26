package com.renewableenergy.SGS.controlers;

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

import com.renewableenergy.SGS.SolarpanelService;
import com.renewableenergy.SGS.TurbineService;
import com.renewableenergy.SGS.entity.Solarpanel;
import com.renewableenergy.SGS.entity.Turbine;

@RestController
@RequestMapping("/solarpanel")
public class SolarpanelController {
	
	  private final SolarpanelService solarpanelService ;
	  
	  public SolarpanelController (SolarpanelService solarpanelService) {
		  this.solarpanelService = solarpanelService;
	  }
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<Solarpanel>> getAllSolarpanel()
	  {
		  List<Solarpanel> solarpanel = solarpanelService.findAllSolarpanel();
		  return new ResponseEntity<>(solarpanel,HttpStatus.OK);
	  }
	  
	  @GetMapping("/find/{id}")
	  public ResponseEntity<Solarpanel> getTurbineById(@PathVariable("id") Long id )
	  {
		  Solarpanel solarpanel = solarpanelService.findSolarpanelByIdid(id);
		  return new ResponseEntity<>(solarpanel,HttpStatus.OK);
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<Solarpanel> addTurbine(@RequestBody Solarpanel solarpanel){
		  Solarpanel newSolarpanel = solarpanelService.addSolarpanel(solarpanel);
		  return new ResponseEntity<>(newSolarpanel,HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/update")
	  public ResponseEntity<Solarpanel> updateSolarpanel(@RequestBody Solarpanel solarpanel){
		  Solarpanel newSolarpanel = solarpanelService.updateSolarpanel(solarpanel);
		  return new ResponseEntity<>(newSolarpanel,HttpStatus.OK);
	  }
	  
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteSolarpanel(@PathVariable("id") Long id){
		  solarpanelService.deleteTurbine(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  }

}
