package com.avaj_launcher.sim.weather;

import com.avaj_launcher.sim.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather ={"RAIN", "SUN", "SNOW", "FOG"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        int weatherType = 0;

        longitude = longitude % 301;
        latitude = latitude % 301;

        if (longitude <= 150 && latitude <= 150) { 
            weatherType = 0;
        } else if (longitude <= 150 && latitude > 150) {
            weatherType = 1;
        } else if (longitude > 150 && latitude <= 150) {
            weatherType = 2;
        } else if (longitude > 150 && latitude > 150) {
            weatherType = 3;
        }
        return (weather[weatherType]);
    }
}
