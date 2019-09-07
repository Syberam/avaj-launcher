class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	WeatherProvider() {}

	public WeatherProvider getProvider() {
		return WeatherProvider.weatherProvider;
	}

	public getCurrentWeather(Coordinate coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		int factor = Math.sqrt(longitude * latitude) + height;

		return weather[factor % 4];
	}
}