package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.ManyToOne;

public class EnergyConsumerDTO {
	private long id;
	private String name;
	private int tariff;
	private double consumedElectrecity;
	SmartHome smarthome;
	public EnergyConsumerDTO(long id, String name, int tariff, double consumedElectrecity, SmartHome smarthome) {
		super();
		this.id = id;
		this.name = name;
		this.tariff = tariff;
		this.consumedElectrecity = consumedElectrecity;
		this.smarthome = smarthome;
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
	public int getTariff() {
		return tariff;
	}
	public void setTariff(int tariff) {
		this.tariff = tariff;
	}
	public double getConsumedElectrecity() {
		return consumedElectrecity;
	}
	public void setConsumedElectrecity(double consumedElectrecity) {
		this.consumedElectrecity = consumedElectrecity;
	}
	public SmartHome getSmarthome() {
		return smarthome;
	}
	public void setSmarthome(SmartHome smarthome) {
		this.smarthome = smarthome;
	}
	
	
}
