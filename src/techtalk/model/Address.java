package techtalk.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="ADDRESS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Address implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID" )
    private Integer addressId;
    @Column(name = "STREET", length = 50)
    private String street;
    @Column(name = "ZIPCODE", length = 5)
    private String zipcode;
    @Enumerated(EnumType.STRING)
    @Column(name = "ADDRESS_TYPE", length = 10)
    private AddressType addressType;
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATE")
    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }



    public Address() {
    }

    public Address(Integer addressId, String street, String zipcode, AddressType addressType, Date lastUpdate) {
        this.addressId = addressId;
        this.street = street;
        this.zipcode = zipcode;
        this.addressType = addressType;
        this.lastUpdate = lastUpdate;
    }
}
