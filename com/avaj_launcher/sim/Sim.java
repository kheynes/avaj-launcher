package com.avaj_launcher.sim;

import java.io.*;
import com.avaj_launcher.sim.aircraft.*;
import com.avaj_launcher.sim.tower.*;
import com.avaj_launcher.sim.Output;

public class Sim {
    public static WeatherTower weatherTower = new WeatherTower();
    public static void main(String[] args) {
        Output.createFile();
        BufferedReader fileReader = null;
        try{
            if (0 < args.length) {
                String filename = args[0];
                File file = new File(filename);

                if (file.exists()) {
                    if (file.length() != 0){
                        String currentLine;
                        int storeNumber;

                        fileReader = new BufferedReader(new FileReader(file));
                        
                        currentLine = fileReader.readLine();

                        try { 
                             storeNumber = Integer.parseInt(currentLine);
                            if (storeNumber >= 0) {
                                while((currentLine = fileReader.readLine()) != null) {
                                    validateInput(currentLine);
                                }
                                while(storeNumber != 0){
                                    weatherTower.changeWeather();
                                    storeNumber--;
                                }
                            } else {
                                throw new Exception("The first line was not a positive integer");
                            }
                        } catch (Exception e) {
                            throw new Exception("The first line was not a positive integer");
                        }
                    } else {
                        throw new Exception("The file is empty");
                    }
                } else {
                    throw new Exception("File does not exist");
                }
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateInput(String line) {
        AircraftFactory aircraftFactory = new AircraftFactory();
        String[] inputArray = line.split(" ");
        int longitude;
        int latitude;
        int height;

        try {
            if(inputArray.length == 5){
                if(inputArray[0].equals("Helicopter") || inputArray[0].equals("Balloon") || inputArray[0].equals("JetPlane")) {
                    try {
                        longitude = Integer.parseInt(inputArray[2]);
                        latitude = Integer.parseInt(inputArray[3]);
                        height = Integer.parseInt(inputArray[4]);

                        if (longitude >= 0 && latitude >= 0 && height >= 0) {
                            Flyable flyable = aircraftFactory.newAircraft(inputArray[0], inputArray[1], longitude, latitude, height);
                            flyable.registerTower(weatherTower);
                        } else {
                            throw new Exception(" ");
                        }
                    }catch(Exception e) {
                        throw new Exception("One or more of the coordinates is not a positive integer");
                    }

                } else {
                    throw new Exception("First string needs to be aircraft type");
                }
            } else {
                throw new Exception("Incorrect input format");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
