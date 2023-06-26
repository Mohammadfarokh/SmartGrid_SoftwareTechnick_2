package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;

@Service
public class HomeSolarPanel{
	private final EnergyProducerinHomeRepository epihr;
	@Autowired
	public HomeSolarPanel(EnergyProducerinHomeRepository epihr) {
		this.epihr = epihr;
	}
	
	public void addHomeSolarPanel(String name,LocalDateTime sunrise, LocalDateTime sunset) {
		EnergyProducerinHome v1 = new EnergyProducerinHome(name, sunrise, sunset);
		this.epihr.save(v1);
	}
	
	public List<EnergyProducerinHome> getSolarPanel(String type){
		return this.epihr.findByType(type);
	}
	public boolean deleteSolarPanel(long id) {
		try {
			this.epihr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
