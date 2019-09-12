package com.launcher.conditions;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		return weather[Math.min(
			(longitude % 3 + latitude % 3 + height % 5) % 5,
			3)];
	}
}