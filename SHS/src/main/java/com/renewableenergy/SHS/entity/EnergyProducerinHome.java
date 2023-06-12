package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

public class EnergyProducerinHome {
	@Id
	@SequenceGenerator(
	name= "energyproducerinHome_sequence", sequenceName= "energyproducerinHome_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "energyproducerinHome_sequence") 
	private long id;
	private String name;
	private double consumedElectrecity;
	private double producedElectrecity;
	private double realtimeCapacity;
	private LocalDateTime sunrise;
	private LocalDateTime sunset;
	private double wind_speed;
	@ManyToMany(mappedBy = "energyproducer")
	Set<SmartHome> smarthomes;
	public EnergyProducerinHome() {
		super();
	}
	public EnergyProducerinHome(long id, String name, double consumedElectrecity, double producedElectrecity,
			double realtimeCapacity, LocalDateTime sunrise, LocalDateTime sunset, long wind_speed,
			Set<SmartHome> smarthomes) {
		super();
		this.id = id;
		this.name = name;
		this.consumedElectrecity = consumedElectrecity;
		this.producedElectrecity = producedElectrecity;
		this.realtimeCapacity = realtimeCapacity;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.wind_speed = wind_speed;
		this.smarthomes = smarthomes;
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
	public double getProducedElectrecity() {
		return producedElectrecity;
	}
	public void setProducedElectrecity(double producedElectrecity) {
		this.producedElectrecity = producedElectrecity;
	}
	public double getRealtimeCapacity() {
		return realtimeCapacity;
	}
	public void setRealtimeCapacity(double realtimeCapacity) {
		this.realtimeCapacity = realtimeCapacity;
	}
	public LocalDateTime getSunrise() {
		return sunrise;
	}
	public void setSunrise(LocalDateTime sunrise) {
		this.sunrise = sunrise;
	}
	public LocalDateTime getSunset() {
		return sunset;
	}
	public void setSunset(LocalDateTime sunset) {
		this.sunset = sunset;
	}
	public double getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	public Set<SmartHome> getSmarthomes() {
		return smarthomes;
	}
	public void setSmarthomes(Set<SmartHome> smarthomes) {
		this.smarthomes = smarthomes;
	}
	@Override
	public String toString() {
		return "EnergyProducerinHome [id=" + id + ", name=" + name + ", consumedElectrecity=" + consumedElectrecity
				+ ", producedElectrecity=" + producedElectrecity + ", realtimeCapacity=" + realtimeCapacity
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + ", wind_speed="
				+ wind_speed + ", smarthomes=" + smarthomes + "]";
	}
	
	
}
