package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);

        System.out.println("Helicopter " + name + " " + this.id + " " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight());
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        switch(weather) {
            case "SUN":{
                this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
                System.out.println("Helicopter Sun");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(longitude + 5, latitude, height);
                System.out.println("Helicopter Rain");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(longitude + 1, latitude, height);
                System.out.println("Helicopter Fog");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(longitude, latitude, height - 12);
                System.out.println("Helicopter Snow");
                break;
            }
        }
        if (this.coordinates.getHeight() > 100) {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            System.out.println(name + " unregistered");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        System.out.println("Helicopter was registered to the Tower ??I think");
    }
}
