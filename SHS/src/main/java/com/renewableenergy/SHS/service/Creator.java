package com.renewableenergy.SHS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;

public abstract class Creator{
	private final EnergyConsumerRepository ecr;
	
	@Autowired
	public Creator(EnergyConsumerRepository ecr) {
		this.ecr = ecr;
	}
	
	public abstract void factory(String name, int tariff, double consumedElectricity, SmartHome smarthome);

	public EnergyConsumerRepository getEcr() {
		return ecr;
	}
	
}
