package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.tower.WeatherTower;
import com.avaj_launcher.sim.Output;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
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
                this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
                System.out.println("Balloon#" + this.name + "(" + this.id + "):" +  " Sure wish this was cold air balloon.");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(longitude, latitude, height - 5);
                System.out.println("Balloon#" + this.name + "(" + this.id + "):" +  " It's raining! Insert pun about water balloons here.");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(longitude, latitude, height - 3);
                System.out.println("Balloon#" + this.name + "(" + this.id + "):" +  " What if fog, is just God vaping.");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(longitude, latitude, height - 15);
                System.out.println("Balloon#" + this.name + "(" + this.id + "):" +  " Never catch snow flakes with your tongue until all the birds have gone south.");
                break;
            }
        }
        if (this.coordinates.getHeight() > 100) {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            output = ("Balloon#" + this.name + "(" + this.id + ")" + " landing");
            Output.writeOuput(output);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
