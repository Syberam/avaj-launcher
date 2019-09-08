class JetPlane extends Aircraft implements Flyable{
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    public void updateConditions() {
        System.out.println("update method : not implemented");
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("registerTower method : not implemented");
    }
}