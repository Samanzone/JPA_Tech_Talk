package com.techtalk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by saman on 9/11/14.
 */
@Entity
public class Dog  implements java.io.Serializable  {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    @OneToMany(mappedBy = "dog")
    private List<PersonDog> persons;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonDog> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDog> persons) {
        this.persons = persons;
    }
}
