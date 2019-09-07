class AircraftFactory {
    public static Flyable newAircraft(String type, String name,
    int longitude, int latitude, int height) {
        coordonates = new Coordonates(longitude, latitude, height);
        if (type.compareTo("Helicopter") == 0) {
            Flyable helicopter = new Helicopter(name, coordonates);
            return helicopter;
        }
        else if (type.compareTo("Baloon") == 0) {
            Flyable baloon = new Ballon(name, coordonates);
            return baloon;
        }
        else if (type.compareTo("JetPlane") == 0) {
            Flyable jetPlane = new JetPlane(name, coordonates);
            return jetPlane;
        }
        //else Error
    }
}