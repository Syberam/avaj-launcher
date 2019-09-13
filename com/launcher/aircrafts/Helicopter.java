package com.launcher.aircrafts;

import com.launcher.airport.WeatherTower;
import com.launcher.conditions.Coordinates;
import com.launcher.airport.Simulator;
import java.io.IOException;



class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String helicopterSays = new String();

		switch(weather) {
			case "SUN":
				helicopterSays = "This is hot.";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 2
				);
				break;
			case "RAIN":
				helicopterSays = "I'm singing in the rain !";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight()
				);
				break;
			case "FOG":
				helicopterSays = "Let's go out of this cloud !";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight()
				);
				break;
			case "SNOW":
				helicopterSays = "My rotor is going to freeze!";
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 12
				);
				break;
		}
		try {
			Simulator.printer(
				this
				.annonce()
				.concat(": ")
				.concat(helicopterSays)
			);
		}
		catch(IOException ex) { System.out.println(ex.getMessage());}

		if (this.coordinates.getHeight() == 0){
			try {
				Simulator.printer(
					this.annonce()
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