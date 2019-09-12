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
			rounds = Integer.parseInt(line);
			while((line = bufferedReader.readLine()) != null) {
				String[] aircraftData = line.trim()
											.replaceAll(" +", " ")
											.split(" ");
				if (aircraftData.length == 5) {
					try {
						String aircraftType = aircraftData[0];
						String aircraftName = aircraftData[1];
						int longitude = Integer.parseInt(aircraftData[2]);
						int latitude = Integer.parseInt(aircraftData[3]);
						int height = Integer.parseInt(aircraftData[4]);
						Flyable flyable = AircraftFactory.newAircraft(
							aircraftType,
							aircraftName,
							longitude,
							latitude,
							height);
							flyable.registerTower(wt);
					}
					catch(NumberFormatException ex) {
						System.out.println("Invalid coordinate: " +
						ex.getMessage() + " in " + "\"" + line + "\"");
					}
				}
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
		catch(NumberFormatException ex) {
				System.out.println("Invalid number of rounds: " + ex.getMessage());
			}

		for (int i = 0; i < rounds; i++){
			wt.changeWeather();
			if (wt.countObservers() == 0 ){
				break;
			}
		}
	}
}