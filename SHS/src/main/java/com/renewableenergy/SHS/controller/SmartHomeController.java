package com.renewableenergy.SHS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public boolean addSmartHome(@RequestBody SmartHomeDTO request) {
		//you have to check for adding Exception
		try {
			shs.addSmartHome(request.getName(), request.getLocation(),request.getNeededElectricity(),
					request.getElectricityConsumedWithoutTariff(), request.getElectricityConsumedWithTariff(), request.getElectricityProduced(),
					request.getRealtimeCapasity());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@GetMapping(value = "/smart-meter-show")
	public List<SmartHome> getSmartHome(){
		return shs.getSmartHome();
	}
}
