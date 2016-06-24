package com.techtalk.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by saman on 9/10/14.
 */
@Embeddable
public class Email {

    @Column(name = "Offic_Email")
    private String officEmail;
    @Column(name = "Personal_Email")
    private String personalEmail;

    public Email() {
    }

    public String getOfficEmail() {
        return officEmail;
    }

    public void setOfficEmail(String officEmail) {
        this.officEmail = officEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }
}
