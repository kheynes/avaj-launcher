package com.avaj_launcher.sim.aircraft;

import com.avaj_launcher.sim.Coordinates;
import com.avaj_launcher.sim.tower.WeatherTower;
import com.avaj_launcher.sim.Output;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        switch(weather) {
            case "SUN":{
                this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
                Output.writeOuput("Helicopter#" + this.name + "(" + this.id + "):" +  " Turn on the fan! it's so hot in here.");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(longitude + 5, latitude, height);
                Output.writeOuput("Helicopter#" + this.name + "(" + this.id + "):" +  " If we get anymore wet they'll have to call me the marine 2.");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(longitude + 1, latitude, height);
                Output.writeOuput("Helicopter#" + this.name + "(" + this.id + "):" +  " I tried to grab fog, but I MIST.");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(longitude, latitude, height - 12);
                Output.writeOuput("Helicopter#" + this.name + "(" + this.id + "):" +  " Is that a white walker ?");
                break;
            }
        }
        if (this.coordinates.getHeight() > 100) {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            Output.writeOuput("Helicopter#" + this.name + "(" + this.id + ")" + " landing");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        Output.writeOuput("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
