class JetPlane extends Aircraft implements Flyable{
    JetPlane(String name, Coordonates coordonates) {
        super();
    }
    
    public void updateConditions() {
        System.out.println("update method : not implemented");
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("registerTower method : not implemented");
    }
}