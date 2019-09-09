class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    public void updateConditions() {
        System.out.println("update method : not implemented");
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
    }
}