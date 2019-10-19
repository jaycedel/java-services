package custservelet;

public class Country {

    private String countryCode;
    private String countryName;
    private String currencyCode;
    private String latitude;
    private String longtitude;

    Country(String code, String countryName, String currencyCode, String latitude, String longtitude) {
        this.countryCode = code;
        this.countryName = countryName;
        this.currencyCode = currencyCode;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    @Override
    public String toString() {
        return "Country{" + "countryCode=" + countryCode + ", countryName=" + countryName + ", currencyCode=" + currencyCode + ", latitude=" + latitude + ", longtitude=" + longtitude + '}';
    }

}
