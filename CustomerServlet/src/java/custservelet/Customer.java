package custservelet;

public class Customer {

    private int id;
    private String name;
    private String country;
    private double balance;
    private String latitude;
    private String longtitude;
    private String countryName;
    private String currencyCode;

    public Customer(int id, String name, String country, double balance) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.country = country;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
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

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", country=" + country + ", balance=" + balance + ", latitude=" + latitude + ", longtitude=" + longtitude + ", countryName=" + countryName + ", currencyCode=" + currencyCode + '}';
    }

}
