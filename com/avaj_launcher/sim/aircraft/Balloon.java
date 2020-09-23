package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.aircraft.Aircraft;
import com.avaj_launcher.sim.tower.WeatherTower;
import com.avaj_launcher.sim.aircraft.Flyable;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
}
