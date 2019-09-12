package com.avaj_launcher.airport;

import com.avaj_launcher.conditions.Coordinates;
import com.avaj_launcher.conditions.WeatherProvider;


public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	private void changeWeather(){
		this.conditionsChanged();
	}
}