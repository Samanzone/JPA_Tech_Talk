package com.techtalk.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saman
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person implements java.io.Serializable {

    @Column(name = "CUSTOMER_CODE")
    private String customerCode;
    @Column(name = "CREDIT_LIMIT", precision = 10, scale = 2)
    private Double creditLimit;
    @OneToMany(mappedBy = "customer" , cascade = {CascadeType.ALL},    fetch=FetchType.LAZY)
    private List<CustOrder> custOrders = new ArrayList<CustOrder>();



    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public List<CustOrder> getCustOrders() {
        return custOrders;
    }

    public void setCustOrders(List<CustOrder> custOrders) {
        this.custOrders = custOrders;
    }


    public Customer() {
    }
}

