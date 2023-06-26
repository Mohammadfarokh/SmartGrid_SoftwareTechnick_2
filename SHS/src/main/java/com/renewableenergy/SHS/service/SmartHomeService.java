package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
import com.renewableenergy.SHS.repository.SmartMeterRepository;

@Service
public class SmartHomeService {
	private final SmartHomeRepository shr;
	@Autowired
	public SmartHomeService(SmartHomeRepository shr) {
		this.shr = shr;
	}
	public void addSmartHome(String name,String location,  double neededElectricity, double electricityConsumedWithoutTariff,
			double electricityConsumedWithTariff,double electricityProduced, double realtimeCapasity) {
		SmartHome v1 = new SmartHome(name,location, neededElectricity,electricityConsumedWithoutTariff, electricityConsumedWithTariff,
				electricityProduced, realtimeCapasity);
		this.shr.save(v1);
	}
	
	public List<SmartHome> getSmartHome(){
		return this.shr.findAll();
	}
	
}
