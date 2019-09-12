package com.launcher.aircrafts;

import com.launcher.airport.WeatherTower;
import com.launcher.conditions.Coordinates;


class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
		System.out.print(this.annonce());
		switch(weather) {
			case "SUN":
				System.out.println(
					"This is hot."
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 2
				);
				break;
			case "RAIN":
				System.out.println(
					"I'm singing in the rain !"
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight()
				);
				break;
			case "FOG":
				System.out.println(
					"Let's go out of this cloud !"
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight()
				);
				break;
			case "SNOW":
				System.out.println(
					"My rotor is going to freeze!"
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 12
				);
				break;
		}

		if (this.coordinates.getHeight() == 0){
			System.out.println(
				String.format("Helicopter#%s(%d): Landing.",
					this.getName(),
					this.getId()
				)
			);
			this.weatherTower.unregister(this);
		}
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
    }
}