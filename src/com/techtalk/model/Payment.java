package com.techtalk.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 1:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PAYMENT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PAYMENT_TYPE", discriminatorType=DiscriminatorType.STRING,length=20)
@DiscriminatorValue("CASH")
public class    Payment implements  java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PAYMENT_ID")
    private Integer paymentId;
    @Column(name = "AMOUNT", precision = 10, scale = 2)
    private Double amount;
    @Column(name = "PAY_DATE")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "PAYMENT_TYPE", length = 20 ,insertable = false , updatable = false)
    private String paymentType;


    //One order has at most one payment and One Payment is exactly for One order
    @OneToOne(/*optional=true,  cascade = {CascadeType.ALL}, */   fetch=FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID" )
    private CustOrder custOrder;


    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }


    public CustOrder getCustOrder() {
        return custOrder;
    }

    public void setCustOrder(CustOrder custOrder) {
        this.custOrder = custOrder;
    }

    public Payment() {
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }
}
