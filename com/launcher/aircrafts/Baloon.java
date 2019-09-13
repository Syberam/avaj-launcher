package com.launcher.aircrafts;

import com.launcher.airport.WeatherTower;
import com.launcher.conditions.Coordinates;
import com.launcher.airport.Simulator;
import java.io.IOException;


class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String baloonSays = new String();

		switch(weather) {
			case "SUN":
				baloonSays = "Let's enjoy the good weather and take some pics.";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 2,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 4
				);
				break;
			case "RAIN":
				baloonSays = "Damn you rain! You messed up my baloon.";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 5
				);
				break;
			case "FOG":
				baloonSays = "I can't see anything !";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 3
				);
				break;
			case "SNOW":
				baloonSays = "It's snowing. We're gonna crash.";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15
				);
				break;
		}
		try {
			Simulator.printer(
				this
				.annonce()
				.concat(": ")
				.concat(baloonSays)
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