package com.renewableenergy.SHS.service;

public interface Observer {

	public void update(long id, long producedEnergy, long consumedEnergyWithTariff, long consumedEnergyWithoutTarif);
}
