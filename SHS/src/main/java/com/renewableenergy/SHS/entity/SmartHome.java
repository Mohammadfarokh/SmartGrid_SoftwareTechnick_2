
package com.renewableenergy.SHS.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


//tariff and SmartGrid from SGS muss be imported
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.renewableenergy.SGS.entity.SmartGrid;
import com.renewableenergy.SGS.entity.Tariff;

<<<<<<< HEAD

=======
@Entity
@Table
>>>>>>> branch 'main' of https://git.inf.fh-dortmund.de/01/mofar003/software_technik_2.git
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
	private String location;
	private double neededElectricity;
	private double electricityConsumed;
	private double electricityProduced;
	private double realtimeCapasity;
	@OneToMany
	Set<HomeBattary> homebattarylist = new HashSet<>();
	@OneToMany
	Set<EnergyProducerinHome> energyproducerlist = new HashSet<>();
	@OneToMany
	Set<EnergyConsumer> energyconsumerlist = new HashSet<>();
	@OneToOne
	private SmartMeter smartmeter;
//  @OneToOne
//	private Tariff tariff;
//	@ManyToOne
//	private SmartGrid smartGrid;
	public SmartHome() {
	}
	public SmartHome(String name,String location,  double neededElectricity, double electricityConsumed,
			double electricityProduced, double realtimeCapasity) {
		this.name = name;
		this.location = location;
		this.neededElectricity = 0;
		this.electricityConsumed = 0;
		this.electricityProduced = 0;
		this.realtimeCapasity = 0;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getNeededElectricity() {
		return neededElectricity;
	}
	public void setNeededElectricity(double neededElectricity) {
		this.neededElectricity = neededElectricity;
	}
	public double getElectricityConsumed() {
		return electricityConsumed;
	}
	public void setElectricityConsumed(double electricityConsumed) {
		this.electricityConsumed = electricityConsumed;
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
	public Set<HomeBattary> getHomebattarylist() {
		return homebattarylist;
	}
	public void setHomebattarylist(Set<HomeBattary> homebattarylist) {
		this.homebattarylist = homebattarylist;
	}
	public Set<EnergyProducerinHome> getEnergyproducerlist() {
		return energyproducerlist;
	}
	public void setEnergyproducerlist(Set<EnergyProducerinHome> energyproducerlist) {
		this.energyproducerlist = energyproducerlist;
	}
	public Set<EnergyConsumer> getEnergyconsumerlist() {
		return energyconsumerlist;
	}
	public void setEnergyconsumerlist(Set<EnergyConsumer> energyconsumerlist) {
		this.energyconsumerlist = energyconsumerlist;
	}
	public SmartMeter getSmartmeter() {
		return smartmeter;
	}
	public void setSmartmeter(SmartMeter smartmeter) {
		this.smartmeter = smartmeter;
	}
	@Override
	public String toString() {
		return "SmartHome [id=" + id + ", name=" + name + ", location=" + location + ", neededElectricity="
				+ neededElectricity + ", electricityConsumed=" + electricityConsumed + ", electricityProduced="
				+ electricityProduced + ", realtimeCapasity=" + realtimeCapasity + ", homebattarylist="
				+ homebattarylist + ", energyproducerlist=" + energyproducerlist + ", energyconsumerlist="
				+ energyconsumerlist + ", smartmeter=" + smartmeter + "]";
	}
}
