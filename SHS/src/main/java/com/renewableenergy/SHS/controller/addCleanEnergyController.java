package com.renewableenergy.SHS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.DTO.addHomeSolarPanelDTO;
import com.renewableenergy.SHS.service.EnergyProducerinHomeService;

@RestController
@RequestMapping(value = "api/v1/add-clean-energy")
public class addCleanEnergyController {
	private final EnergyProducerinHomeService service ;
	@Autowired
	addCleanEnergyController(EnergyProducerinHomeService service){
		this.service = service;
	}
	@PostMapping(value = "/solarpanel")
	public boolean addSolarPanel(@RequestBody addHomeSolarPanelDTO request) {
		//you have to check for adding Exception
		service.addHomeSolarPanel(request.getName(), request.getConsumedElectrecity(), request.getProducedElectrecity()
				, request.getRealtimeCapacity(), request.getMaxOutput(), request.getSunrise(), request.getSunset());
	    return true;
	}
	@PostMapping(value = "/turbin")
	public boolean addTurbin() {
	    return true;
	}
}
