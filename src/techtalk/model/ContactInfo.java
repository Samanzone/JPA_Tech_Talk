package techtalk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/30/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="CONTRACT_INFO")
public class ContactInfo  implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO )
    @Column(name = "CONTRACT_INFO_ID")
    private Integer contactInfoId;


    //Notice that this is a unidirectional one to many, so a join table
    //will be created by default. The JoinColumn forces the use of
    //foreign key column in Address table.
    //CONTACTINFO_ID column will be created in Address table.
    //if name is not specified, the column will be named CONTACTINFO_ID

    @ManyToMany(cascade={CascadeType.ALL} ,    fetch=FetchType.LAZY )
    @JoinTable(name="CONTRACT_ADDRESS",
            joinColumns=@JoinColumn(name="CONTRACT_ID"),
            inverseJoinColumns=@JoinColumn(name="ADDRESS_ID"))
    private List<Address> addresses = new ArrayList<Address>();

    @Transient
    private Integer[] addressIdList;

    @Column(name = "EMAIL_ID" , length = 50)
    private String emailId;

    @Column(name = "PHONE_NO" , length = 20)
    private String phoneNo;



    public Integer getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(Integer contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer[] getAddressIdList() {
        return addressIdList;
    }

    public void setAddressIdList(Integer[] addressIdList) {
        this.addressIdList = addressIdList;
    }

    public ContactInfo() {
    }

    public ContactInfo(Integer contactInfoId) {
        this.contactInfoId = contactInfoId;
    }


}
