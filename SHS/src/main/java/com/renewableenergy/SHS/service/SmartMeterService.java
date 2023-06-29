package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
import com.renewableenergy.SHS.repository.SmartMeterRepository;

@Service
public class SmartMeterService {
	private final SmartMeterRepository smr;
	private final SmartHomeRepository shr;
	@Autowired
	public SmartMeterService(SmartHomeRepository shr, SmartMeterRepository smr) {
		this.smr = smr;
		this.shr = shr;
	}
	public void addSmartMeter(long id_smartHome, String name, double producedEnergy, double consumedEnergyWithTariff,
			double consumedEnergyWithoutTariff) {
		SmartMeter v1 = new SmartMeter(name,producedEnergy,consumedEnergyWithTariff,consumedEnergyWithoutTariff);
		v1.setSmartHome(shr.getById(id_smartHome));
		this.smr.save(v1);
	}
	
	public List<SmartMeter> getSmartMeter(){
		return this.smr.findAll();
	}
	public boolean deleteSmartMeter(long id) {
		try {
			this.smr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
