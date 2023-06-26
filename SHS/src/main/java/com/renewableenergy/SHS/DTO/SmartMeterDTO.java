package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.OneToOne;

public class SmartMeterDTO {
	 long id;
	 String name;
	 double producedEnergy;
	 double consumedEnergyWithTariff;
	 double consumedEnergyWithoutTariff;
	 SmartHome smartHome;
	public SmartMeterDTO() {
	}
	public SmartMeterDTO(long id, String name, double producedEnergy, double consumedEnergyWithTariff,
			double consumedEnergyWithoutTariff, SmartHome smartHome) {
		this.id = id;
		this.name = name;
		this.producedEnergy = producedEnergy;
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTariff;
		this.smartHome = smartHome;
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
	
	 
}
