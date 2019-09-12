package com.launcher.airport;

import java.io.*;
import com.launcher.aircrafts.AircraftFactory;
import com.launcher.aircrafts.Flyable;

public class Simulator {
	public static void main(String[] args){
		WeatherTower wt = new WeatherTower();
		int rounds = 0;
	
		String fileName = "scenario.txt";
		if (args.length > 0) {
			fileName = args[0];
		}
		String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
				new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			// Should try catch ?
			rounds = Integer.parseInt(line);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }








		Flyable planeCB = AircraftFactory.newAircraft("JetPlane", "CharlyBravo", 30, 30, 30);
		Flyable planeZQ = AircraftFactory.newAircraft("JetPlane", "ZuluQuebec", 12, 15, 9);
		Flyable baloonAT = AircraftFactory.newAircraft("Baloon", "AlphaTango", 12, 15, 9);
		Flyable helicopterDF = AircraftFactory.newAircraft("Helicopter", "DeltaFoxtrot", 5, 10, 60);

		
		planeCB.registerTower(wt);
		planeZQ.registerTower(wt);
		baloonAT.registerTower(wt);
		helicopterDF.registerTower(wt);
		for (int i = 0; i < rounds; i++){
			wt.changeWeather();
			if (wt.countObservers() == 0 ){
				break;
			}
		}
	}


}