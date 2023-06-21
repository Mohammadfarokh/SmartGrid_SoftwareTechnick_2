package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
@Service
public class StandartConsumerService extends Creator {

	public StandartConsumerService(EnergyConsumerRepository ecr) {
		super(ecr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void factory(String name, int tariff, double consumedElectricity, SmartHome smarthome) {
		// TODO Auto-generated method stub
		EnergyConsumer ecih = new EnergyConsumer(name, tariff, consumedElectricity, smarthome);
		super.getEcr().save(ecih);
	}
	
	public List<EnergyConsumer> getEnergyConsumer(){
		return super.getEcr().findAll();
	}


}
