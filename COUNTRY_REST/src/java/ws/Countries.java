/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johanna
 */
@Entity
@Table(name = "countries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCountryCode", query = "SELECT c FROM Countries c WHERE c.countryCode = :countryCode")
    , @NamedQuery(name = "Countries.findByLatitude", query = "SELECT c FROM Countries c WHERE c.latitude = :latitude")
    , @NamedQuery(name = "Countries.findByLongtitude", query = "SELECT c FROM Countries c WHERE c.longtitude = :longtitude")
    , @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "country_code")
    private String countryCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longtitude")
    private Double longtitude;
    @Size(max = 100)
    @Column(name = "country_name")
    private String countryName;
    @Size(max = 100)
    @Column(name = "currency_code")
    private String currencyCode;

    public Countries() {
    }

    public Countries(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
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
    public int hashCode() {
        int hash = 0;
        hash += (countryCode != null ? countryCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryCode == null && other.countryCode != null) || (this.countryCode != null && !this.countryCode.equals(other.countryCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Countries[ countryCode=" + countryCode + " ]";
    }

}
