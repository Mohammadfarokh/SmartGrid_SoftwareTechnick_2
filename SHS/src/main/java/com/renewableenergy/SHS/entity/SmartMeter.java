package com.renewableenergy.SHS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class SmartMeter implements Observer {
	@Id
	@SequenceGenerator(
	name= "smartmeter_sequence", sequenceName= "smartmeter_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "smartmeter_sequence") 
	private long id;
	private String name;
	private double producedEnergy;
	private double consumedEnergyWithTariff;
	private double consumedEnergyWithoutTariff;
	@OneToOne
	private SmartHome smartHome;
	
	public SmartMeter() {
	}
	
	public SmartMeter(String name, double producedEnergy, double consumedEnergyWithTariff,
			double consumedEnergyWithoutTariff) {
		this.name = name;
		this.producedEnergy = producedEnergy;
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTariff;
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
	public double getProducedEnergy() {
		return producedEnergy;
	}
	public void setProducedEnergy(double producedEnergy) {
		this.producedEnergy = producedEnergy;
	}
	public double getConsumedEnergyWithTariff() {
		return consumedEnergyWithTariff;
	}
	public void setConsumedEnergyWithTariff(double consumedEnergyWithTariff) {
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
	}
	public double getConsumedEnergyWithoutTariff() {
		return consumedEnergyWithoutTariff;
	}
	public void setConsumedEnergyWithoutTariff(double consumedEnergyWithoutTariff) {
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTariff;
	}
	public SmartHome getSmartHome() {
		return smartHome;
	}
	public void setSmartHome(SmartHome smartHome) {
		this.smartHome = smartHome;
	}

	@Override
	public String toString() {
		return "SmartMeter [id=" + id + ", name=" + name + ", producedEnergy=" + producedEnergy
				+ ", consumedEnergyWithTariff=" + consumedEnergyWithTariff + ", consumedEnergyWithoutTariff="
				+ consumedEnergyWithoutTariff + ", smartHome=" + smartHome + "]";
	}

	@Override
	public void update(double producedEnergy, double consumedEnergyWithTariff, double consumedEnergyWithoutTarif) {
		// TODO Auto-generated method stub
		this.producedEnergy = producedEnergy;
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTarif;
	}
	
	
}
