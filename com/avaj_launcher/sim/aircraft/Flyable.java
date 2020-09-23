package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.tower.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weathertower);
}
