class JetPlane extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
	}
    
    public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		System.out.print(annonce());
		switch(weather) {
			case "SUN":
				System.out.println(
					"Put your sun glasses"
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 10,
					this.coordinates.getHeight() + 2
				);
				break;
			case "RAIN":
				System.out.println(
					"It's raining. Better watch out for lightings."
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 5,
					this.coordinates.getHeight()
				);
				break;
			case "FOG":
				System.out.println(
					"What an overcast afternoon."
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 1,
					this.coordinates.getHeight()
				);
				break;
			case "SNOW":
				System.out.println(
					"OMG! Winter is coming!"
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 7
				);
				break;
		}

		if (this.coordinates.getHeight() == 0){
			System.out.print(annonce());
			System.out.println("Landing.");
			this.weatherTower.unregister(this);
		}
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
    }
}