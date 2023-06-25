package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.EnergyConsumer.Status;

public class EnergyConsumerDTO {
	long id;
	String name;
	double consumedElectrecity;
	Status mystatus;
	SmartHome smarthome;
	boolean isStandart; 
	
	public EnergyConsumerDTO(long id, String name, double consumedElectrecity, Status mystatus, SmartHome smarthome,
			boolean	isStandart) {
		this.id = id;
		this.name = name;
		this.consumedElectrecity = consumedElectrecity;
		this.mystatus = mystatus;
		this.smarthome = smarthome;
		this.isStandart = isStandart;
	}
	public EnergyConsumerDTO() {
		
	}
	
	public boolean isStandart() {
		return isStandart;
	}
	public void setStandart(boolean isStandart) {
		this.isStandart = isStandart;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getConsumedElectrecity() {
		return consumedElectrecity;
	}
	public void setConsumedElectrecity(double consumedElectrecity) {
		this.consumedElectrecity = consumedElectrecity;
	}
	public Status getMystatus() {
		return mystatus;
	}
	public void setMystatus(Status mystatus) {
		this.mystatus = mystatus;
	}
	public SmartHome getSmarthome() {
		return smarthome;
	}
	public void setSmarthome(SmartHome smarthome) {
		this.smarthome = smarthome;
	}
	
	
}
