package com.techtalk.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/27/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class  Person implements java.io.Serializable {



    @Column(name = "ID")
    @Id
    @TableGenerator( name = "PERSON_GENERATOR" ,
        table = "PERSON_GENERATOR" ,
        pkColumnName = "ID_NAME" ,
        valueColumnName = "ID_VALUE" ,
        pkColumnValue = "PERSON_ID" ,
        initialValue = 1 ,
        allocationSize = 10 )
        @GeneratedValue ( strategy= GenerationType.TABLE, generator= "PERSON_GENERATOR" )

    private Integer id;
    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;
    @Column(name = "LAST_NAME", length = 20)
    private String lastName;
    @Column(name = "REGISTRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CONTACT_INFO_ID" )
    private ContactInfo contactInfo;

    @Embedded
    private Email email;

    @ElementCollection(targetClass = CarBrands.class)
    @Enumerated(EnumType.STRING)
    private List<CarBrands> brands;


    @OneToMany(mappedBy = "person")
    private List<PersonDog> dogs;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<CarBrands> getBrands() {
        return brands;
    }

    public void setBrands(List<CarBrands> brands) {
        this.brands = brands;
    }

    public List<PersonDog> getDogs() {
        return dogs;
    }

    public void setDogs(List<PersonDog> dogs) {
        this.dogs = dogs;
    }
}