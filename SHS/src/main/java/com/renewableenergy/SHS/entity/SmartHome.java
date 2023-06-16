package com.renewableenergy.SHS.entity;

import java.util.Set;
//tariff and SmartGrid from SGS muss be imported
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import com.renewableenergy.SGS.entity.SmartGrid;
import com.renewableenergy.SGS.entity.Tariff;

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
	private double neededElectricity;
	private double electricityConsumed;
	private double electricityProduced;
	private double realtimeCapasity;
	private Tariff tariff;
	private SmartGrid smartGrid;

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
	public SmartHome(long id, String name, double neededElectricity, double electricityConsumed,
			double electricityProduced, double realtimeCapasity, Tariff tariff, SmartGrid smartGrid,
			Set<HomeBattary> battarys, Set<EnergyProducerinHome> energyproducer, Set<EnergyConsumer> energyconsumer) {
		super();
		this.id = id;
		this.name = name;
		this.neededElectricity = neededElectricity;
		this.electricityConsumed = electricityConsumed;
		this.electricityProduced = electricityProduced;
		this.realtimeCapasity = realtimeCapasity;
		this.tariff = tariff;
		this.smartGrid = smartGrid;
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
	public Tariff getTariff() {
		return tariff;
	}
	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}
	public SmartGrid getSmartGrid() {
		return smartGrid;
	}
	public void setSmartGrid(SmartGrid smartGrid) {
		this.smartGrid = smartGrid;
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
		return "SmartHome [id=" + id + ", name=" + name + ", neededElectricity=" + neededElectricity
				+ ", electricityConsumed=" + electricityConsumed + ", electricityProduced=" + electricityProduced
				+ ", realtimeCapasity=" + realtimeCapasity + ", battarys=" + battarys + ", energyproducer="
				+ energyproducer + ", energyconsumer=" + energyconsumer + "]";
	}
	

	
}
