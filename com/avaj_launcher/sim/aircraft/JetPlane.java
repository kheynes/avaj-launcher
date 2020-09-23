package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.aircraft.Aircraft;
import com.avaj_launcher.sim.tower.WeatherTower;
import com.avaj_launcher.sim.aircraft.Flyable;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
}
