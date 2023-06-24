package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;


@Service
public class EnergyProducerinHomeService {
	
	private final EnergyProducerinHomeRepository epihr;
	@Autowired
	public EnergyProducerinHomeService(EnergyProducerinHomeRepository epihr) {
		this.epihr = epihr;
	}
	
	public void addHomeSolarPanel(String name,LocalDateTime sunrise, LocalDateTime sunset) {
		EnergyProducerinHome v1 = new EnergyProducerinHome(name, sunrise, sunset);
		this.epihr.save(v1);
	}
	
	public void addHomeTurbine(String name,double windspeed) {
		EnergyProducerinHome v1 = new EnergyProducerinHome(name, windspeed);
		this.epihr.save(v1);
	}
	
	public List<EnergyProducerinHome> getEnergyConsumer(){
		return this.epihr.findAll();
	}
}