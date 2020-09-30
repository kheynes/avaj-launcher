package com.avaj_launcher.sim;

import java.io.*;
import com.avaj_launcher.sim.aircraft.*;
import com.avaj_launcher.sim.tower.*;

public class Sim {
    public static void main(String[] args) {
        BufferedReader fileReader = null;
        try{
            if (0 < args.length) {
                String filename = args[0];
                File file = new File(filename);

                if (file.exists()) {
                    if (file.length() != 0){
                        String currentLine;
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

        

        // AircraftFactory aircraftFactory = new AircraftFactory();
        // Flyable flyable1 = aircraftFactory.newAircraft("Helicopter", "H1", 1, 1, 1);
        // Flyable flyable2 = aircraftFactory.newAircraft("Balloon", "B1", 2, 2, 2);
        // Flyable flyable3 = aircraftFactory.newAircraft("JetPlane", "J1", 3, 3, 3);

        // WeatherTower weatherTower = new WeatherTower();
        // flyable1.registerTower(weatherTower);
        // flyable2.registerTower(weatherTower);
        // flyable3.registerTower(weatherTower);

        // flyable1.updateConditions();
        // flyable2.updateConditions();
        // flyable3.updateConditions();

    }
}
