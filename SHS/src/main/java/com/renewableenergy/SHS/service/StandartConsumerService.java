package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.EnergyConsumer.Status;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
import com.renewableenergy.SHS.entity.EnergyConsumer.Status;;
@Service
public class StandartConsumerService extends Creator {

	public StandartConsumerService(EnergyConsumerRepository ecr) {
		super(ecr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void factory(String name, double consumedElectricity, boolean isStandart) {
		// TODO Auto-generated method stub
		if (isStandart == true) {
			EnergyConsumer ecih = new EnergyConsumer(name, consumedElectricity);
			ecih.setMystatus(Status.ALLWAYS);
			super.getEcr().save(ecih);	
		}
	}
	
	public List<EnergyConsumer> getEnergyConsumer(){
		return super.getEcr().findAll();
	}
}
