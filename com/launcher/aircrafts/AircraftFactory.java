package com.launcher.aircrafts;

import com.launcher.conditions.Coordinates;


public class AircraftFactory {
    public static Flyable newAircraft(String type, String name,
    int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.compareTo("Helicopter") == 0)
			return new Helicopter(name, coordinates);
		else if (type.compareTo("Baloon") == 0)
			return new Baloon(name, coordinates);
		else if (type.compareTo("JetPlane") == 0)
			return new JetPlane(name, coordinates);
		return null;
    }
}