package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.tower.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);

        System.out.println("Balloon " + name + " " + coordinates.getLattitude() + " " + coordinates.getLongitude() + " " + coordinates.getHeight());
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int lattitude = this.coordinates.getLattitude();
        int height = this.coordinates.getHeight();

        switch(weather) {
            case "SUN":
                this.coordinates = new Coordinates(longitude + 2, lattitude, height + 4);
            case "RAIN":
                this.coordinates = new Coordinates(longitude, lattitude, height - 5);
            case "FOG":
                this.coordinates = new Coordinates(longitude, lattitude, height - 3);
            case "SNOW":
                this.coordinates = new Coordinates(longitude, lattitude, height - 15);
        }
        if (this.coordinates.getHeight() > 100) {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLattitude(), 100);
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
