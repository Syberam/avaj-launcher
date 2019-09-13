package com.launcher.airport;

import java.io.*;
import com.launcher.aircrafts.AircraftFactory;
import com.launcher.aircrafts.Flyable;
import com.launcher.aircrafts.InvalidAircraftException;

public class Simulator {
	static boolean firstRead = true;
	public static void main(String[] args){
		WeatherTower wt = new WeatherTower();
		int rounds = 0;
	
		String fileName = "ressources/scenario.txt";
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
					catch(InvalidAircraftException ex) {
						System.out.println(ex.getMessage());
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
			System.out.println(usage());
			
		}
		catch(IOException ex) {
			System.out.println(
				"Error reading file '" 
				+ fileName + "'");
			System.out.println(usage());
		}
		catch(NumberFormatException ex) {
				System.out.println(
					"Invalid number of rounds: "
					+ ex.getMessage());
				System.out.println(usage());
			}

		for (int i = 0; i < rounds; i++){
			wt.changeWeather();
			// if (wt.countObservers() == 0 ){
			// 	break;
			// }
		}
	}

	public static void printer(String line) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.txt", !Simulator.firstRead));
		if (Simulator.firstRead) {
			Simulator.firstRead = false;
		}

		writer.append(line);
		writer.append(System.getProperty("line.separator"));
		writer.close();
	}

	static String usage() {
		return String.join(
			System.getProperty("line.separator")
			, "Input file must to be format as folllow:"
			, System.getProperty("line.separator")
			, "R"
			, "TYPE_1 NAME_1 LONGITUDE_1 LATITUDE_1 HEIGHT_1"
			, "TYPE_2 NAME_2 LONGITUDE_2 LATITUDE_2 HEIGHT_2"
			, "..."
			, "TYPE_n-1 NAME_n-1 LONGITUDE_n-1 LATITUDE_n-1 HEIGHT_n-1"
			, "TYPE_n NAME_n LONGITUDE_n LATITUDE_n HEIGHT_n"
			, System.getProperty("line.separator")
			, "Where :"
			, "R\t\t\t: for rounds, the number of time the conditions will change"
			, "TYPE_n (String)\t\t: the aircraft nºn type"
			, "NAME_n (String)\t\t: the aircraft nºn name"
			, "LONGITUDE_n (int)\t: aircraft nºn longitude position"
			, "LATITUDE_n (int)\t: aircraft nºn latitude position"
			, "HEIGHT_n (int)\t\t: aircraft nºn height position"
			, "n\t\t\t: the number of aircrafts"
		);
	}
}