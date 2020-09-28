package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Flyable flyable;
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch(type) {
            case "Helicopter": {
                flyable = new Helicopter(name, coordinates);
                return(flyable);
            }
            case "JetPlane": {
                flyable = new JetPlane(name, coordinates);
                return(flyable);
            }
            case "Balloon": {
                flyable = new Balloon(name, coordinates);
                return(flyable);
            }
            default:
                return null;
        }
    }
}
