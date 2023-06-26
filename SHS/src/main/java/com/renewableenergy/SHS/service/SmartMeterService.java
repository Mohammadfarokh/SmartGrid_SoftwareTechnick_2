package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.SmartMeterRepository;

@Service
public class SmartMeterService {
	private final SmartMeterRepository smr;
	@Autowired
	public SmartMeterService(SmartMeterRepository smr) {
		this.smr = smr;
	}
	public void addSmartMeter(String name, double producedEnergy, double consumedEnergyWithTariff,
			double consumedEnergyWithoutTariff) {
		SmartMeter v1 = new SmartMeter(name,producedEnergy,consumedEnergyWithTariff,consumedEnergyWithoutTariff);
		this.smr.save(v1);
	}
	
	public List<SmartMeter> getSmartMeter(){
		return this.smr.findAll();
	}
}
