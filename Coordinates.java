class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(longitude : int, latitude : int, height : int) {
        self.longitude = Math.min(360, Math.max(0, longitude));
        self.latitude = Math.min(180, Math.max(0, latitude));
        self.height = Math.min(100, Math.max(0, height)); 
    }

    private int getLongitude() { return self.longitude; }
    private int getLatitude() { return self.latitude; }
    private int getHeight() { return self.height; }
}