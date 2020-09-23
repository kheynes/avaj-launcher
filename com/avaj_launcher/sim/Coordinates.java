package com.avaj_launcher.sim;

public class Coordinates {
    private int longitude;
    private int lattitude;
    private int height;

    private Coordinates(int longitude, int lattitude, int height) {
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLattitude() {
        return this.lattitude;
    }

    public int getHeight() {
        return this.height;
    }
}
