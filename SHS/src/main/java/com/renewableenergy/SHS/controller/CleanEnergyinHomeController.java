package com.renewableenergy.SHS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.DTO.EnergyConsumerDTO;
import com.renewableenergy.SHS.DTO.EnergyProducerinHomeDTO;
import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.service.EnergyProducerinHomeService;
import com.renewableenergy.SHS.service.HomeSolarPanel;
import com.renewableenergy.SHS.service.HomeTurbine;
@RestController
@RequestMapping(value = "api/v1/energy-producer")
public class CleanEnergyinHomeController {
	public final HomeSolarPanel hsp;
	public final HomeTurbine ht;
	@Autowired
	CleanEnergyinHomeController(HomeSolarPanel hsp, HomeTurbine ht){
		this.hsp = hsp;
		this.ht = ht;
	}
	
	@PostMapping(value = "/solar-panel-add")
	public boolean addHomeSolarPanel(@RequestBody EnergyProducerinHomeDTO request) {
		//you have to check for adding Exception
		try {
			hsp.addHomeSolarPanel(request.getName(), request.getSunrise(), request.getSunset() );
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@GetMapping(value = "/solar-panel-show")
	public List<EnergyProducerinHome> getSolarPanel(@RequestBody EnergyProducerinHomeDTO request){
		return hsp.getSolarPanel(request.getType());
	}
	
	@PostMapping(value = "/turbine-add")
	public boolean addHomeTurbine(@RequestBody EnergyProducerinHomeDTO request) {
		//you have to check for adding Exception
		try {
			ht.addHomeTurbine(request.getName(), request.getWind_speed());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@GetMapping(value = "/solar-panel-show")
	public List<EnergyProducerinHome> getHomeTurbine(@RequestBody EnergyProducerinHomeDTO request){
		return ht.getHomeTurbine(request.getType());
	}

}
