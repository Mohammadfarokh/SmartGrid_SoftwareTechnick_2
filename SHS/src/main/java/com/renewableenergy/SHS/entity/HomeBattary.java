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
	private double maxCapacity;
	private double consumedElectrictiy;
	private double realtimeCapacity;
	private int reachedMax;
	private boolean charging;
	@ManyToMany(mappedBy = "battarys")
	Set<SmartHome> smarthomes;
	enum status{
		GOOD,
		MIDDEL, 
		BAD
	}
	public HomeBattary() {
		super();
	}
	public HomeBattary(long id, String name, double maxCapacity, double consumedElectrictiy, double realtimeCapacity,
			int reachedMax, boolean charging, Set<SmartHome> smarthomes) {
		super();
		this.id = id;
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.consumedElectrictiy = consumedElectrictiy;
		this.realtimeCapacity = realtimeCapacity;
		this.reachedMax = reachedMax;
		this.charging = charging;
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
	public double getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public double getRealtimeCapacity() {
		return realtimeCapacity;
	}
	public void setRealtimeCapacity(double realtimeCapacity) {
		this.realtimeCapacity = realtimeCapacity;
	}
	public int getReachedMax() {
		return reachedMax;
	}
	public void setReachedMax(int reachedMax) {
		this.reachedMax = reachedMax;
	}
	public boolean isCharging() {
		return charging;
	}
	public void setCharging(boolean charging) {
		this.charging = charging;
	}
	public double getConsumedElectrictiy() {
		return consumedElectrictiy;
	}
	public void setConsumedElectrictiy(double consumedElectrictiy) {
		this.consumedElectrictiy = consumedElectrictiy;
	}
	public Set<SmartHome> getSmarthomes() {
		return smarthomes;
	}
	public void setSmarthomes(Set<SmartHome> smarthomes) {
		this.smarthomes = smarthomes;
	}
	@Override
	public String toString() {
		return "HomeBattary [id=" + id + ", name=" + name + ", maxCapacity=" + maxCapacity + ", consumedElectrictiy="
				+ consumedElectrictiy + ", realtimeCapacity=" + realtimeCapacity + ", reachedMax=" + reachedMax
				+ ", charging=" + charging + ", smarthomes=" + smarthomes + "]";
	}


	
	
}
