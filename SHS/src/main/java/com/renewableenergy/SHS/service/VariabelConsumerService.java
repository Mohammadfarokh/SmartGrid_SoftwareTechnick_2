package com.renewableenergy.SHS.service;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
@Service
public class VariabelConsumerService extends Creator {

	public VariabelConsumerService(EnergyConsumerRepository ecr) {
		super(ecr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void factory(String name, int tariff, double consumedElectricity, SmartHome smarthome) {
		EnergyConsumer ecih = new EnergyConsumer(name, tariff, consumedElectricity, smarthome);
		super.getEcr().save(ecih);
	}

}
