package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
import java.util.Set;

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
//	@ManyToMany(mappedBy = "energyconsumer")
//	Set<SmartHome> smarthomes;
	@ManyToOne
	SmartHome smarthome;
	public EnergyConsumer() {
		super();
	}
	public EnergyConsumer(String name, int tariff, double consumedElectrecity, SmartHome smarthome) {
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
	public SmartHome getSmarthomes() {
		return smarthome;
	}
	public void setSmarthomes(SmartHome smarthome) {
		this.smarthome = smarthome;
	}
	@Override
	public String toString() {
		return "EnergyConsumer [id=" + id + ", name=" + name + ", tariff=" + tariff + ", consumedElectrecity="
				+ consumedElectrecity + ", smarthomes=" + smarthome + "]";
	}
	
	
}
