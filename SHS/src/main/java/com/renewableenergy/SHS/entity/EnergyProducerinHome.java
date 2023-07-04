package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import com.renewableenergy.SHS.ShsApplication;
import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table
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
	private boolean status;
	private double consumedElectrecity;
	private double producedElectrecity;
	private double totalProduce;
	private double realtimeCapacity;
	private double maxOutput;
	private double consume;
	private double efficiency;
	private LocalDateTime sunrise;
	private LocalDateTime sunset;
	private double wind_speed;
	private String type;
//	@ManyToOne
//	SmartHome smarthome;
	public EnergyProducerinHome() {
	}
	public EnergyProducerinHome(String name, LocalDateTime sunrise, LocalDateTime sunset) {
		this.name = name;
		this.status = true;
		this.consumedElectrecity = 0;
		this.producedElectrecity = 0;
		this.realtimeCapacity = 0;
		this.maxOutput = 100;
		calculateSunrise();
		calculateSunset();
		this.sunset = sunset;
		this.wind_speed = 0;
		this.consume = 10;
		this.efficiency = 0;
		this.type = "solarpanel";
	//	this.smarthome = null;
		this.totalProduce = 0;
	}
	public EnergyProducerinHome(String name, double wind_speed) {
		this.name = name;
		this.status = true;
		this.consumedElectrecity = 0;
		this.producedElectrecity = 0;
		this.realtimeCapacity = 0;
		this.maxOutput = 500;
		this.sunrise = null;
		this.sunset = null;
		calculateWindspeed();
		this.consume = 50;
		this.efficiency = 0;
		this.type = "turbine";
	//	this.smarthome = null;
		this.totalProduce = 0;
	}
	
	public void calculateProducSolarPanel() {
		this.totalProduce += maxOutput;
		if (ShsApplication.producedEnergy == 0) {
			ShsApplication.producedEnergy = maxOutput;
		}else {
			ShsApplication.producedEnergy += maxOutput;
		}
	}
	
	public void calculateProducTurbine() {
		this.totalProduce += maxOutput * 2;
		if (ShsApplication.producedEnergy == 0) {
			ShsApplication.producedEnergy = maxOutput * 2;
		}else {
			ShsApplication.producedEnergy += maxOutput * 2;
		}
	}
	
	public void calculateSunrise() {
		this.sunrise = LocalDateTime.of(2023, 07, 28, 5, 00, 00, 000000);
	}
	public void calculateSunset() {
		this.sunset = LocalDateTime.of(2023, 07, 28, 8, 00, 00, 000000);
	}
	public void calculateWindspeed() {
		this.wind_speed = 10;
	}
	public void calculate(EnergyProducerinHome ep) {
		Random random = new Random();
		
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
	public boolean isStatus() {
		return status;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public double getConsume() {
		return consume;
	}
	public void setConsume(double consume) {
		this.consume = consume;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
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
//	public SmartHome getSmarthome() {
//		return smarthome;
//	}
//	public void setSmarthome(SmartHome smarthome) {
//		this.smarthome = smarthome;
//	}
	@Override
	public String toString() {
		return "EnergyProducerinHome [id=" + id + ", name=" + name + ", status=" + status + ", consumedElectrecity="
				+ consumedElectrecity + ", producedElectrecity=" + producedElectrecity + ", realtimeCapacity="
				+ realtimeCapacity + ", maxOutput=" + maxOutput + ", consume=" + consume + ", efficiency=" + efficiency
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + ", wind_speed=" + wind_speed + /*", smarthome="
				+ smarthome +*/", type="
						+ type + "]";
	}
	
	
	
}
