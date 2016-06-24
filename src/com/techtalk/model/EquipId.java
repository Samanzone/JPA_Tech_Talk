package com.techtalk.model;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Created by saman on 9/10/14.
 */
@Entity
@IdClass(EquipId.class)
public class EquipId implements Serializable {


    private int serial;

    private String brand;
    // must have a default constructor
    public EquipId() {
    }

    public EquipId(int serial, String brand) {
        this.serial = serial;
        this.brand = brand;
    }
    public int getSerial() {
        return serial;
    }
    public String getBrand() {
        return brand;
    }
    // Must have a hashCode method
    @Override
    public int hashCode() {
        return serial + brand.hashCode();
    }
    // Must have an equals method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EquipId) {
            EquipId carId = (EquipId) obj;
            return carId.serial == this.serial && carId.brand.equals(this.brand);
        }
        return false;
    }
}

