package techtalk.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by saman on 9/11/14.
 */
@Entity
@IdClass(PersonDogId.class)
public class PersonDog  implements   java.io.Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID")
    private Person person;
    @Id
    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;
    @Temporal(TemporalType.DATE)
    private Date adoptionDate;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public PersonDog() {
    }
}