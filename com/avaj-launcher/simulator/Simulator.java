package com.avaj_launcher.simulator;

import com.avaj_launcher.aircrafs.AircraftFactory;
import com.avaj_launcher.aircrafts.*;
import com.avaj_launcher.airport.*;
import com.avaj_launcher.simulator.*;

public class Simulator {
	public static void main(String[] args){
		WeatherTower wt = new WeatherTower();
	
		Flyable planeCB = AircraftFactory.newAicraft("JetPlane", "CharlyBravo", 30, 30, 30);
		JetPlane planeZQ = AircraftFactory.newAicraft("JetPlane", "ZuluQuebec", 12, 15, 9);
		JetPlane baloonAT = AircraftFactory.newAicraft("Baloon", "AlphaTango", 12, 15, 9);
		JetPlane helicopterDF = AircraftFactory.newAicraft("Helicopter", "DeltaFoxtrot", 5, 10, 60);

		
		planeCB.registerTower(wt);
		planeZQ.registerTower(wt);
		baloonAT.registerTower(wt);
		helicopterDF.registerTower(wt);
		while (wt.countObservers() > 0){
			wt.conditionsChanged();
		}
	}
}