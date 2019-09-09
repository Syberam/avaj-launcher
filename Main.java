public class Main {
	public static void main(String[] args){
		Coordinates coord = new Coordinates(1,1,1);
		WeatherTower wt = new WeatherTower();

		JetPlane plane = new JetPlane("zeta", coord);
		Baloon baloon = new Baloon("alpha", coord);
		plane.registerTower(wt);
		baloon.registerTower(wt);
		System.out.println("Hello, World!");
	}
}