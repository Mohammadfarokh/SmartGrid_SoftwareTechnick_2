package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.HomeBattaryRepository;

@Service
public class HomeBattaryService {
	private final HomeBattaryRepository hbr;
	@Autowired
	public HomeBattaryService(HomeBattaryRepository hbr) {
		this.hbr = hbr;
	}
	public void addHomeBattary(String name,double maxCapacity) {
		HomeBattary v1 = new HomeBattary(name, maxCapacity);
		this.hbr.save(v1);
	}
	
	public List<HomeBattary> getBattary(){
		return this.hbr.findAll();
	}
}
