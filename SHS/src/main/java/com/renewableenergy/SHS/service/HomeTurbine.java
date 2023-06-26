package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;

@Service
public class HomeTurbine {
	private final EnergyProducerinHomeRepository epihr;
	@Autowired
	public HomeTurbine(EnergyProducerinHomeRepository epihr) {
		this.epihr = epihr;
	}
	public void addHomeTurbine(String name,double windspeed) {
		EnergyProducerinHome v1 = new EnergyProducerinHome(name,windspeed);
		this.epihr.save(v1);
	}
	
	public List<EnergyProducerinHome> getHomeTurbine(String type){
		return this.epihr.findByType(type);
	}
	public boolean deleteHomeTurbine(long id) {
		try {
			this.epihr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
