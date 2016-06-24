package com.techtalk.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 1:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("CREDIT_CARD")
public class CreditCard extends Payment implements java.io.Serializable {

    @Column(name = "CRECIT_CARD_NUMBER", length = 20)
    private String creditCardNumber;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date expireyDate;
    @Column(name = "CREDIT_CARD_TYPE", length = 20)
    private CCType creditCardType;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExpireyDate() {
        return expireyDate;
    }

    public void setExpireyDate(Date expireyDate) {
        this.expireyDate = expireyDate;
    }

    public CCType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CCType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
