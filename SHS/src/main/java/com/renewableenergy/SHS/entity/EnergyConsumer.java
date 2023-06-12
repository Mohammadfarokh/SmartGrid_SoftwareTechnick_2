package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

public class EnergyConsumer {
	@Id
	@SequenceGenerator(
	name= "energyconsumer_sequence", sequenceName= "energyconsumer_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "energyconsumer_sequence") 
	private long id;
	private String name;
	private int tariff;
	private double consumedElectrecity;
	@ManyToMany(mappedBy = "energyconsumer")
	Set<SmartHome> smarthomes;
	public EnergyConsumer() {
		super();
	}
	public EnergyConsumer(long id, String name, int tariff, double consumedElectrecity, Set<SmartHome> smarthomes) {
		super();
		this.id = id;
		this.name = name;
		this.tariff = tariff;
		this.consumedElectrecity = consumedElectrecity;
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
	public Set<SmartHome> getSmarthomes() {
		return smarthomes;
	}
	public void setSmarthomes(Set<SmartHome> smarthomes) {
		this.smarthomes = smarthomes;
	}
	@Override
	public String toString() {
		return "EnergyConsumer [id=" + id + ", name=" + name + ", tariff=" + tariff + ", consumedElectrecity="
				+ consumedElectrecity + ", smarthomes=" + smarthomes + "]";
	}
	
	
}
