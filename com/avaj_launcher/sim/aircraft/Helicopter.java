package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.aircraft.Aircraft;
import com.avaj_launcher.sim.tower.WeatherTower;
import com.avaj_launcher.sim.aircraft.Flyable;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int lattitude = this.coordinates.getLattitude();
        int height = this.coordinates.getHeight();

        switch(weather) {
            case "SUN":
                this.coordinates = new Coordinates(longitude + 10, lattitude, height + 2);
            case "RAIN":
                this.coordinates = new Coordinates(longitude + 5, lattitude, height);
            case "FOG":
                this.coordinates = new Coordinates(longitude + 1, lattitude, height);
            case "SNOW":
                this.coordinates = new Coordinates(longitude, lattitude, height - 12);
        }
        if (this.coordinates.getHeight() > 100) {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLattitude(), 100);
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
        }
    }
}
