class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
		System.out.print(
			String.format("Helicopter#%s(%d): ",
				this.getName(),
				this.getId()
			)
		);
		switch(weather) {
			case "SUN":
				System.out.println(
					"Let's enjoy the good weather and take some pics."
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 2
				);
				break;
			case "RAIN":
				System.out.println(
					"Damn you rain! You messed up my baloon."
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight()
				);
				break;
			case "FOG":
				System.out.println(
					"I can't see anything !"
				);
				this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight()
				);
				break;
			case "SNOW":
				System.out.println(
					"Too cold to keep altitude !!!"
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