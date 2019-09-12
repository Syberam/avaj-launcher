package com.launcher.airport;

import com.launcher.aircrafts.AircraftFactory;
import com.launcher.aircrafts.Flyable;

public class Simulator {
	public static void main(String[] args){
		WeatherTower wt = new WeatherTower();
	
		Flyable planeCB = AircraftFactory.newAircraft("JetPlane", "CharlyBravo", 30, 30, 30);
		Flyable planeZQ = AircraftFactory.newAircraft("JetPlane", "ZuluQuebec", 12, 15, 9);
		Flyable baloonAT = AircraftFactory.newAircraft("Baloon", "AlphaTango", 12, 15, 9);
		Flyable helicopterDF = AircraftFactory.newAircraft("Helicopter", "DeltaFoxtrot", 5, 10, 60);

		
		planeCB.registerTower(wt);
		planeZQ.registerTower(wt);
		baloonAT.registerTower(wt);
		helicopterDF.registerTower(wt);
		while (wt.countObservers() > 0){
			wt.changeWeather();
		}
	}
}