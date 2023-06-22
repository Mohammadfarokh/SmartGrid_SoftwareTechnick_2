package com.renewableenergy.SGS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class CleanEnergyProducer extends EnergyProducer {

	private String weather;

	public CleanEnergyProducer(Long id ,
							   double productionAmount,
							   boolean status,
							   String weather) {
		super(id,productionAmount,status);
		this.weather = weather;
	}

	public CleanEnergyProducer() {

	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

}
