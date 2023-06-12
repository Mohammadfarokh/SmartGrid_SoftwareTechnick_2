package com.renewableenergy.SHS.entity;

import java.util.Set;

import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

public class SmartHome {
	@Id
	@SequenceGenerator(
	name= "smarthome_sequence", sequenceName= "smarthome_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "smarthome_sequence") 
	private long id;
	private String name;
	private double electricityConsume;
	private double electricityProduced;
	private double realtimeCapasity;

	@ManyToMany
	@JoinTable(
	  name = "SmartHome_Battary", 
	  joinColumns = @JoinColumn(name = "smarthome_id"), 
	  inverseJoinColumns = @JoinColumn(name = "homebattary_id"))
	Set<HomeBattary> battarys;
	
	@ManyToMany
	@JoinTable(
	  name = "SmartHome_EnergyProducer", 
	  joinColumns = @JoinColumn(name = "smarthome_id"), 
	  inverseJoinColumns = @JoinColumn(name = "energyproducer_id"))
	Set<EnergyProducerinHome> energyproducer;
	
	@ManyToMany
	@JoinTable(
	  name = "SmartHome_EnergyConsumer", 
	  joinColumns = @JoinColumn(name = "smarthome_id"), 
	  inverseJoinColumns = @JoinColumn(name = "energyconsumer_id"))
	Set<EnergyConsumer> energyconsumer;

	public SmartHome() {
		super();
	}
	
	public SmartHome(long id, String name, double electricityConsume, double electricityProduced,
			double realtimeCapasity, Set<HomeBattary> battarys, Set<EnergyProducerinHome> energyproducer,
			Set<EnergyConsumer> energyconsumer) {
		super();
		this.id = id;
		this.name = name;
		this.electricityConsume = electricityConsume;
		this.electricityProduced = electricityProduced;
		this.realtimeCapasity = realtimeCapasity;
		this.battarys = battarys;
		this.energyproducer = energyproducer;
		this.energyconsumer = energyconsumer;
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

	public double getElectricityConsume() {
		return electricityConsume;
	}

	public void setElectricityConsume(double electricityConsume) {
		this.electricityConsume = electricityConsume;
	}

	public double getElectricityProduced() {
		return electricityProduced;
	}

	public void setElectricityProduced(double electricityProduced) {
		this.electricityProduced = electricityProduced;
	}

	public double getRealtimeCapasity() {
		return realtimeCapasity;
	}

	public void setRealtimeCapasity(double realtimeCapasity) {
		this.realtimeCapasity = realtimeCapasity;
	}

	public Set<HomeBattary> getBattarys() {
		return battarys;
	}

	public void setBattarys(Set<HomeBattary> battarys) {
		this.battarys = battarys;
	}

	public Set<EnergyProducerinHome> getEnergyproducer() {
		return energyproducer;
	}

	public void setEnergyproducer(Set<EnergyProducerinHome> energyproducer) {
		this.energyproducer = energyproducer;
	}

	public Set<EnergyConsumer> getEnergyconsumer() {
		return energyconsumer;
	}

	public void setEnergyconsumer(Set<EnergyConsumer> energyconsumer) {
		this.energyconsumer = energyconsumer;
	}
	
	@Override
	public String toString() {
		return "SmartHome [id=" + id + ", name=" + name + ", electricityConsume=" + electricityConsume
				+ ", electricityProduced=" + electricityProduced + ", realtimeCapasity=" + realtimeCapasity
				+ ", battarys=" + battarys + ", energyproducer=" + energyproducer + ", energyconsumer=" + energyconsumer
				+ "]";
	}

	
}
