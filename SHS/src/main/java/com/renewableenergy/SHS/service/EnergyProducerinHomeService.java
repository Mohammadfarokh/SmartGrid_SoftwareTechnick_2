package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;


@Service
public class EnergyProducerinHomeService {
	@Autowired
	private final EnergyProducerinHomeRepository epihr;
	
	public EnergyProducerinHomeService(EnergyProducerinHomeRepository epihr) {
		this.epihr = epihr;
	}
	
	public void addHomeSolarPanel(String name,double consumedElectrecity, double producedElectrecity, double realtimeCapacity
	 ,double maxOutput, LocalDateTime sunrise, LocalDateTime sunset) {
		EnergyProducerinHome v1 = new EnergyProducerinHome(name, consumedElectrecity, producedElectrecity,
				realtimeCapacity, maxOutput, sunrise, sunset, (Double) 0.0, null);
		this.epihr.save(v1);
	}
}