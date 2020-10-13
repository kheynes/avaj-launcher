package com.avaj_launcher.sim.tower;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return(weather);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
