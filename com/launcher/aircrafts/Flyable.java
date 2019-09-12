package com.launcher.aircrafts;

import com.launcher.airport.WeatherTower;


public interface Flyable {
    public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
	public String getName();
	public String getType();
	public long getId();
}