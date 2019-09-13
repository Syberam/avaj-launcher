package com.launcher.aircrafts;

import com.launcher.airport.WeatherTower;
import com.launcher.conditions.Coordinates;
import com.launcher.airport.Simulator;
import java.io.IOException;


class JetPlane extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
	}
    
    public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String jetPlaneSays = new String();
		
		switch(weather) {
			case "SUN":
				jetPlaneSays = "Put your sun glasses";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 10,
					this.coordinates.getHeight() + 2
				);
				break;
			case "RAIN":
				jetPlaneSays = "It's raining. Better watch out for lightings.";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 5,
					this.coordinates.getHeight()
				);
				break;
			case "FOG":
				jetPlaneSays = "What an overcast afternoon.";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 1,
					this.coordinates.getHeight()
				);
				break;
			case "SNOW":
				jetPlaneSays = "OMG! Winter is coming!";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 7
				);
				break;
		}

		try {
			Simulator.printer(
				this
				.annonce()
				.concat(": ")
				.concat(jetPlaneSays)
			);
		}
		catch(IOException ex) { System.out.println(ex.getMessage());}

		if (this.coordinates.getHeight() == 0){
			try {
				Simulator.printer(
					this
					.annonce()
					.concat(": ")
					.concat("Landing")
				);
			}
			catch(IOException ex) { System.out.println(ex.getMessage());}
			this.weatherTower.unregister(this);
		}
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
    }
}