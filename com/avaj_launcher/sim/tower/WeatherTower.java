package com.avaj_launcher.sim.tower;

import com.avaj_launcher.sim.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        String weather = "SNOW";
        return(weather);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
