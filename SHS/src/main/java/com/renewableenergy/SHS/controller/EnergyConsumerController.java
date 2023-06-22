package com.renewableenergy.SHS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.DTO.EnergyConsumerDTO;
import com.renewableenergy.SHS.DTO.addHomeSolarPanelDTO;
import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.service.StandartConsumerService;
import com.renewableenergy.SHS.service.VariabelConsumerService;

@RestController
@RequestMapping(value = "api/v1/energy-consumer")
public class EnergyConsumerController {
	private final StandartConsumerService scs ;
	private final VariabelConsumerService vcs;
	
	@Autowired
	public EnergyConsumerController(StandartConsumerService scs, VariabelConsumerService vcs) {
		this.scs = scs;
		this.vcs = vcs;
	}
	
	@PostMapping(value = "/standart-consumer-add")
	public boolean addStandartConsumer(@RequestBody EnergyConsumerDTO request) {
		//you have to check for adding Exception
		try {
			scs.factory(request.getName(),-1, request.getConsumedElectrecity(), request.getSmarthome());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	
	@GetMapping(value = "/consumer-show")
	public List<EnergyConsumer> getEnergyConsumer(){
		return scs.getEnergyConsumer();
	}
	
	@PostMapping(value = "/variabel-consumer-add")
	public boolean addVariabelConsumer(@RequestBody EnergyConsumerDTO request) {
		//you have to check for adding Exception
		try {
			vcs.factory(request.getName(), request.getTariff(),request.getConsumedElectrecity(), request.getSmarthome());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}


}
