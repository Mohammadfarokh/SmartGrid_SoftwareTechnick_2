package com.renewableenergy.SGS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table	
public class Turbine extends CleanEnergyProducer {
	
	public Turbine(double wind_speed) {
		super();
		this.wind_speed = wind_speed;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private double wind_speed;

	@Override
	public String toString() {
		return "Turbine [id=" + id + ", wind_speed=" + wind_speed + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}

}
