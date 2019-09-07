class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = Math.min(360, Math.max(0, longitude));
        this.latitude = Math.min(180, Math.max(0, latitude));
        this.height = Math.min(100, Math.max(0, height)); 
    }

    public int getLongitude() { return this.longitude; }
    public int getLatitude() { return this.latitude; }
    public int getHeight() { return this.height; }
}