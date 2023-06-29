package com.renewableenergy.SHS.service;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.EnergyConsumer.Status;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
@Service
public class VariabelConsumerService extends Creator {

	public VariabelConsumerService(SmartHomeRepository shr,EnergyConsumerRepository ecr) {
		super(shr,ecr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void factory(long id_smartHome,String name, double consumedElectricity, boolean isStandart) {
		// TODO Auto-generated method stub
		if (isStandart == false) {
			EnergyConsumer ecih = new EnergyConsumer(name, consumedElectricity);
			if(getTariffInfo()) {
				ecih.setMystatus(Status.ON);
			}else {
				ecih.setMystatus(Status.OFF);
			}
			ecih.setSmarthome(super.getShs().getById(id_smartHome));
			super.getEcr().save(ecih);	
		}
	}
	
	public void addVariabelConsumer(EnergyConsumer ec) {
		super.getEcr().save(ec);
	}
	public boolean deleteVariabelConsumer(long id) {
		try {
			super.getEcr().deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getTariffInfo() {
		//hier wird deklariert mit einem boolean ob 
		// status = ON or OFF ist
		return true;
	}

}
