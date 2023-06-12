package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

public class HomeBattary {
	@Id
	@SequenceGenerator(
	name= "homebattary_sequence", sequenceName= "homebattary_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "homebattary_sequence") 
	private long id;
	private String name;
	private double capacity;
	private double consumedElectrictiy;
	private double savedAmount;
	@ManyToMany(mappedBy = "battarys")
	Set<SmartHome> smarthomes;
	public HomeBattary() {
		super();
	}
	
	public HomeBattary(long id, String name, double capacity, double consumedElectrictiy, double savedAmount,
			Set<SmartHome> smarthomes) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.consumedElectrictiy = consumedElectrictiy;
		this.savedAmount = savedAmount;
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
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public double getConsumedElectrictiy() {
		return consumedElectrictiy;
	}
	public void setConsumedElectrictiy(double consumedElectrictiy) {
		this.consumedElectrictiy = consumedElectrictiy;
	}
	public double getSavedAmount() {
		return savedAmount;
	}
	public void setSavedAmount(double savedAmount) {
		this.savedAmount = savedAmount;
	}
	public Set<SmartHome> getSmarthomes() {
		return smarthomes;
	}
	public void setSmarthomes(Set<SmartHome> smarthomes) {
		this.smarthomes = smarthomes;
	}

	@Override
	public String toString() {
		return "HomeBattary [id=" + id + ", name=" + name + ", capacity=" + capacity + ", consumedElectrictiy="
				+ consumedElectrictiy + ", savedAmount=" + savedAmount + ", smarthomes=" + smarthomes + "]";
	}
	
	
}
