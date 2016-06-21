package techtalk.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="INTERNATIONAL_ADDRESS")
@PrimaryKeyJoinColumn(name="ADDRESS_ID")
public class InternationalAddress extends  Address {


    @Column(name = "COUNTRY", length = 25)
    private String country;
    @Column(name = "CONTINENT", length = 15)
    private String continent;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }


    public InternationalAddress(Address address) {
           super(address.getAddressId(),address.getStreet(),address.getZipcode(),address.getAddressType(),address.getLastUpdate());
    }

    public InternationalAddress() {
    }
}
