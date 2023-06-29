package com.renewableenergy.SHS.service;

import java.util.LinkedList;
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
		//attach(this.shr.getSmartMeter(null));
	}
	public void addSmartHome(String name,String location,  double neededElectricity, double electricityConsumedWithoutTariff,
			double electricityConsumedWithTariff,double electricityProduced, double realtimeCapasity) {
		SmartHome v1 = new SmartHome(name,location, neededElectricity,electricityConsumedWithoutTariff, electricityConsumedWithTariff,
				electricityProduced, realtimeCapasity);
		//entity smarthome add function that creats smartmeter
		//attach(v1.getSmartmeter());
		this.shr.save(v1);
	}
	
	public List<SmartHome> getSmartHome(){
		return this.shr.findAll();
	}
	
	public SmartHome getSmartHome(long id) {
		return this.shr.getById(id);
	}
	public boolean deleteSmartHome(long id) {
		try {
			this.shr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
