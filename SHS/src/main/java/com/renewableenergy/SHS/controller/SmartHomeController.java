package com.renewableenergy.SHS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SGS.entity.Solarpanel;
import com.renewableenergy.SHS.DTO.HomeBattaryDTO;
import com.renewableenergy.SHS.DTO.SmartHomeDTO;
import com.renewableenergy.SHS.DTO.SmartMeterDTO;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.service.SmartHomeService;
import com.renewableenergy.SHS.service.SmartMeterService;

@RestController
@RequestMapping(value = "api/v1/smart-home")
public class SmartHomeController {
	public final SmartHomeService shs;
	@Autowired
	SmartHomeController(SmartHomeService shs){
		this.shs = shs;
	}
	@PostMapping(value = "/smart-home-add")
	public boolean addSmartHome(@RequestBody /*SmartHomeDTO*/ SmartHome request) {
		//you have to check for adding Exception
		try {
			shs.addSmartHome(request.getName(), request.getLocation());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@GetMapping(value = "/smart-meter-show")
	@CrossOrigin("*") 
	public List<SmartHome> getSmartHome(){
		return shs.getSmartHome();
	}
	 @PutMapping("/smart-home-update")
	  public boolean updateSolarpanel(@RequestBody SmartHome request){
		 try {
				shs.update(request);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
	  }
	@PostMapping(value = "/smart-home-remove")
	public boolean removeSmartHome(@RequestBody SmartHomeDTO request) {
		//you have to check for adding Exception
		try {
			shs.deleteSmartHome(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
}
