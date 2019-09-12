package com.avaj_launcher.aircrafs;

import com.avaj_launcher.airport.WeatherTower;


public interface Flyable {
    public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
	public String getName();
	public long getId();
}