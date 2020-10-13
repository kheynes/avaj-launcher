package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.tower.WeatherTower;
import com.avaj_launcher.sim.Output;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        String output;

        switch(weather) {
            case "SUN":{
                this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "):" +  " nnneeaoowww!");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(longitude, latitude + 5, height);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "):" +  " next time, FLY SOUTH!");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(longitude, latitude + 1, height);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "):" +  " Not sure if I'm on the correct route, or if I'm even in the sky at all!");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(longitude, latitude, height - 7);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "):" +  " What do you call a snowman with a six pack ? the abdominal snowman!");
                break;
            }
        }
        if (this.coordinates.getHeight() > 100) {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            output = ("JetPlane#" + this.name + "(" + this.id + ")" + " landing");
            Output.writeOuput(output);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
