package com.renewableenergy.SHS.controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.DTO.EnergyConsumerDTO;
import com.renewableenergy.SHS.DTO.EnergyProducerinHomeDTO;
import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.EnergyConsumer.Status;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.service.SmartHomeService;
import com.renewableenergy.SHS.service.StandartConsumerService;
import com.renewableenergy.SHS.service.VariabelConsumerService;

@RestController
@RequestMapping(value = "api/v1/energy-consumer")
public class EnergyConsumerController {
	public final StandartConsumerService scs ;
	public final VariabelConsumerService vcs;
	public final SmartHomeService shs;
	public List<EnergyConsumer> listeEnergyConsumer;
	Random random = new Random();
	
	@Autowired
	public EnergyConsumerController(SmartHomeService shs,StandartConsumerService scs, VariabelConsumerService vcs) {
		this.scs = scs;
		this.vcs = vcs;
		this.shs = shs;
		this.listeEnergyConsumer  = new LinkedList<EnergyConsumer>();
	}
	
	@PostMapping(value = "/standart-consumer-add")
	public boolean addStandartConsumer(@RequestBody EnergyConsumerDTO request) {
		//you have to check for adding Exception
		try {
			scs.factory(request.getId_smartHome(),request.getName(), request.getConsumedElectrecity(), request.isStandart());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@PostMapping(value = "/standart-consumer-remove")
	public boolean removeStandartConsumer(@RequestBody EnergyConsumerDTO request) {
		//you have to check for adding Exception
		try {
			scs.deleteStandartConsumer(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
	
	@GetMapping(value = "/consumer-show")
	public List<EnergyConsumer> getEnergyConsumer(@RequestBody EnergyConsumerDTO request){
		listeEnergyConsumer = scs.getEnergyConsumer();
		double totalconsumewithTariff = 0;
		double totalconsumewithoutTariff = 0;
		  for(EnergyConsumer consumer : listeEnergyConsumer) {
			  // Sunshine duration
		  if(consumer.getMystatus() == Status.ALLWAYS ) {
			  double camount=consumer.getConsumedElectrecity();
			  totalconsumewithTariff += camount;
			  consumer.addConsumedElectricity(camount);
			  scs.addStandartConsumer(consumer);			  
		  } else if(consumer.getMystatus() == Status.ON) {
			  double camount=consumer.getConsumedElectrecity();
			  totalconsumewithoutTariff += camount;
			  consumer.addConsumedElectricity(camount);
			  vcs.addVariabelConsumer(consumer);
		  }
		  }
		  SmartHome sh = shs.getSmartHome(request.getId_smartHome());
		  sh.addToElectricityConsumedWithoutTariff(totalconsumewithoutTariff);
		  sh.addToElectricityConsumedWithTariff(totalconsumewithTariff);
		  return listeEnergyConsumer;
		//return scs.getEnergyConsumer();
	}
	
	@PostMapping(value = "/variabel-consumer-add")
	public boolean addVariabelConsumer(@RequestBody EnergyConsumerDTO request) {
		//you have to check for adding Exception
		try {
			vcs.factory(request.getId_smartHome(),request.getName(),request.getConsumedElectrecity(), request.isStandart());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@PostMapping(value = "/variabel-consumer-remove")
	public boolean removeVariabelConsumer(@RequestBody EnergyConsumerDTO request) {
		//you have to check for adding Exception
		try {
			vcs.deleteVariabelConsumer(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
}
