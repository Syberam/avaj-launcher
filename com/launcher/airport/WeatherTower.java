package com.launcher.airport;

import com.launcher.conditions.Coordinates;
import com.launcher.conditions.WeatherProvider;


public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather(){
		this.conditionsChanged();
	}
}