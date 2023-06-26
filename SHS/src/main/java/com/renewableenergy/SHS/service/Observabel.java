package com.renewableenergy.SHS.service;

public abstract class Observabel {
	public abstract void attach(Observer o);
	public abstract void detach(Observer o);
	public abstract void notifyObserver();
}
