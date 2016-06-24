package com.techtalk.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/31/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="SALESMAN")
//@Cacheable
public class Salesman extends  Person {


    @Column(name = "SALESMAN_CODE")
    private String salesmanCode;
    @Column(name = "COMMISSION_RATE", precision = 10, scale = 2)
    private Double commissionRete;
    @Column(name = "COMMISSION_AMOUNT", precision = 10, scale = 2)
    private Double commissionAmount;
    @OneToMany(mappedBy="salesman" ,cascade = {CascadeType.ALL},    fetch=FetchType.LAZY)
    private List<CustOrder> custOrders;

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode;
    }

    public Double getCommissionRete() {
        return commissionRete;
    }

    public void setCommissionRete(Double commissionRete) {
        this.commissionRete = commissionRete;
    }

    public Double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public List<CustOrder> getCustOrders() {
        return custOrders;
    }

    public void setCustOrders(List<CustOrder> custOrders) {
        this.custOrders = custOrders;
    }


}
