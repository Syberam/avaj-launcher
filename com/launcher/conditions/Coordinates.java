package com.launcher.conditions;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = Math.max(0, longitude);
        this.latitude = Math.max(0, latitude);
        this.height = Math.min(100, Math.max(0, height)); 
    }

    public int getLongitude() { return this.longitude; }
    public int getLatitude() { return this.latitude; }
    public int getHeight() { return this.height; }
}