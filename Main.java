public class Main {
	public static void main(String[] args){
		WeatherTower wt = new WeatherTower();
	
		Coordinates coord = new Coordinates(30,30,30);
		JetPlane planeCB = new JetPlane("CharlyBravo", coord);
		coord = new Coordinates(12,15,9);
		JetPlane planeZQ = new JetPlane("ZuluQuebec", coord);
		coord = new Coordinates(12,15,9);
		Baloon baloon = new Baloon("AlphaTango", coord);
		coord = new Coordinates(5,10,60);
		Helicopter helicopter = new Helicopter("DeltaFoxtrot", coord);

		
		planeCB.registerTower(wt);
		planeZQ.registerTower(wt);
		baloon.registerTower(wt);
		helicopter.registerTower(wt);
		while (wt.countObservers() > 0){
			wt.conditionsChanged();
		}
	}
}