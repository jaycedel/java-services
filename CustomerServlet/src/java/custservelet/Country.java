package custservelet;

public class Country {

    private String countryCode;
    private String latitude;
    private String longtitude;

    Country(String code, String latitude, String longtitude) {
        this.countryCode = code;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

}
