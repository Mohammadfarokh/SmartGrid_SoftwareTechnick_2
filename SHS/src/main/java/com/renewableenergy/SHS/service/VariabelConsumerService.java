package com.renewableenergy.SHS.service;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.EnergyConsumer.Status;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
@Service
public class VariabelConsumerService extends Creator {

	public VariabelConsumerService(EnergyConsumerRepository ecr) {
		super(ecr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void factory(String name, double consumedElectricity, boolean isStandart) {
		// TODO Auto-generated method stub
		if (isStandart == false) {
			EnergyConsumer ecih = new EnergyConsumer(name, consumedElectricity);
			if(getTariffInfo()) {
				ecih.setMystatus(Status.ON);
			}else {
				ecih.setMystatus(Status.OFF);
			}
			super.getEcr().save(ecih);	
		}
	}
	
	public boolean getTariffInfo() {
		//hier wird deklariert mit einem boolean ob 
		// status = ON or OFF ist
		return true;
	}

}
