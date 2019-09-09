class AircraftFactory {
    public static Flyable newAircraft(String type, String name,
    int longitude, int latitude, int height) {
		coordonates = new Coordonates(longitude, latitude, height);

		if (type.compareTo("Helicopter") == 0)
			return new Helicopter(name, coordonates);
		else if (type.compareTo("Baloon") == 0)
			return new Ballon(name, coordonates);
		else if (type.compareTo("JetPlane") == 0)
			return new JetPlane(name, coordonates);
		return null;
    }
}