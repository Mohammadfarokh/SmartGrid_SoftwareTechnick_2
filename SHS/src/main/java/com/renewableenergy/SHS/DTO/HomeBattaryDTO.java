package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.HomeBattary.Status;

public class HomeBattaryDTO {
	 long id;
	 String name;
	 double maxCapacity;
	 double consumedElectrictiy;
	 double realtimeCapacity;
	 int reachedMax;
	 boolean charging;
	 SmartHome smarthome;
	 Status mystatus;
	public HomeBattaryDTO() {
	}
	public HomeBattaryDTO(long id, String name, double maxCapacity, double consumedElectrictiy, double realtimeCapacity,
			int reachedMax, boolean charging, SmartHome smarthome, Status mystatus) {
		this.id = id;
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.consumedElectrictiy = consumedElectrictiy;
		this.realtimeCapacity = realtimeCapacity;
		this.reachedMax = reachedMax;
		this.charging = charging;
		this.smarthome = smarthome;
		this.mystatus = mystatus;
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
	public double getConsumedElectrictiy() {
		return consumedElectrictiy;
	}
	public void setConsumedElectrictiy(double consumedElectrictiy) {
		this.consumedElectrictiy = consumedElectrictiy;
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
	public SmartHome getSmarthome() {
		return smarthome;
	}
	public void setSmarthome(SmartHome smarthome) {
		this.smarthome = smarthome;
	}
	public Status getMystatus() {
		return mystatus;
	}
	public void setMystatus(Status mystatus) {
		this.mystatus = mystatus;
	}
	 
}
