package com.avaj_launcher.sim;

import java.io.File;
import com.avaj_launcher.sim.aircraft.*;
import com.avaj_launcher.sim.tower.*;

public class Sim {
    public static void main(String[] args) {

        if (0 < args.length) {
            String filename = args[0];
            File file = new File(filename);

            try {
                file.exists();
                System.out.println("exists");
            }
            catch(Exception e) {
                System.out.println("file does not exist");
            }

            // if (file.exists()) {
            //     System.out.println(file.getName() + " does exist !");
            // } else {
            //     System.out.println("Please create the file first");
            // }
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
