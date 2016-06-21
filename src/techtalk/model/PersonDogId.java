package techtalk.model;

import java.io.Serializable;

/**
 * Created by saman on 9/11/14.
 */
public class PersonDogId implements Serializable {

    private int person;
    private int dog;
    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
    public int getDog() {
        return dog;
    }
    public void setDog(int dog) {
        this.dog = dog;
    }
    @Override
    public int hashCode() {
        return person + dog;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PersonDogId){
            PersonDogId personDogId = (PersonDogId) obj;
            return personDogId.dog == dog && personDogId.person == person;
        }
        return false;
    }
}
