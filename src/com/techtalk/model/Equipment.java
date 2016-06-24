package com.techtalk.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by saman on 9/10/14.
 */
@Entity
public class Equipment  implements Serializable {

    @EmbeddedId
    private EquipId equipId;

    private String name;

    public EquipId getEquipId() {
        return equipId;
    }

    public void setEquipId(EquipId equipId) {
        this.equipId = equipId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
