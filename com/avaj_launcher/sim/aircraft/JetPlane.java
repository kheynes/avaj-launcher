package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);

        System.out.println("JetPlane " + name +  " " + this.id +  " " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight());
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        switch(weather) {
            case "SUN":{
                this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                System.out.println("JetPlane Sun");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(longitude, latitude + 5, height);
                System.out.println("JetPlane Rain");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(longitude, latitude + 1, height);
                System.out.println("JetPlane Fog");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(longitude, latitude, height - 7);
                System.out.println("JetPlane Snow");
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
        System.out.println("JetPlane " + name + " " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight());
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        System.out.println("JetPlane was registered to the Tower ??I think");
    }
}
