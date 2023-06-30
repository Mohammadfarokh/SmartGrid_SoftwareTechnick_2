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
	private double consumedElectrecity;
//	public enum Status{
//		ON,
//		OFF,
//		ALLWAYS
//	}
	private String mystatus;
	private String type;
//	@ManyToOne
//	SmartHome smarthome;
	public EnergyConsumer() {
	}
	public EnergyConsumer(String name, double consumedElectrecity) {
			this.name = name;
			this.consumedElectrecity = consumedElectrecity;	
	}
	public void addConsumedElectricity(double num) {
		this.consumedElectrecity += num;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getConsumedElectrecity() {
		return consumedElectrecity;
	}
	public void setConsumedElectrecity(double consumedElectrecity) {
		this.consumedElectrecity = consumedElectrecity;
	}

	public String getMystatus() {
		return mystatus;
	}
	public void setMystatus(String mystatus) {
		this.mystatus = mystatus;
	}
//	public SmartHome getSmarthome() {
//		return smarthome;
//	}
//	public void setSmarthome(SmartHome smarthome) {
//		this.smarthome = smarthome;
//	}
	@Override
	public String toString() {
		return "EnergyConsumer [id=" + id + ", name=" + name + ", consumedElectrecity=" + consumedElectrecity
				+ ", mystatus=" + mystatus + ", type=" + type + /*", smarthome=" + smarthome + */"]";
	}

}
