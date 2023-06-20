package com.renewableenergy.SHS.DTO;

import java.time.LocalDateTime;

public class addHomeSolarPanelDTO {
	public long id;
	public String name;
	public double consumedElectrecity;
	public double producedElectrecity;
	public double realtimeCapacity;
	public double maxOutput;
	public LocalDateTime sunrise;
	public LocalDateTime sunset;
	public double wind_speed;
	public addHomeSolarPanelDTO(long id, String name, double consumedElectrecity, double producedElectrecity,
			double realtimeCapacity, double maxOutput, LocalDateTime sunrise, LocalDateTime sunset, double wind_speed) {
		this.id = id;
		this.name = name;
		this.consumedElectrecity = consumedElectrecity;
		this.producedElectrecity = producedElectrecity;
		this.realtimeCapacity = realtimeCapacity;
		this.maxOutput = maxOutput;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.wind_speed = wind_speed;
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
	public double getMaxOutput() {
		return maxOutput;
	}
	public void setMaxOutput(double maxOutput) {
		this.maxOutput = maxOutput;
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
	
}
