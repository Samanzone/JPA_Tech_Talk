package com.techtalk.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="CUST_ORDER")
public class CustOrder implements  java.io.Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
	private Date orderDate;
    @Column(name = "REQUIRED_DATE")
    @Temporal(TemporalType.DATE)
	private Date requiredDate;
    @Column(name = "SHIPPED_DATE")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    @Column(name = "COMMENTS" ,length=50)
	private String comments;

    //Many orders are by same customer
    @ManyToOne( /*optional=false,  cascade = {CascadeType.ALL}, */   fetch=FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    //Only one Salesman is handing a particuler order
    @ManyToOne(/*optional=false , cascade = {CascadeType.ALL}, */   fetch=FetchType.LAZY)
    @JoinColumn(name="SALESMAN_ID"/*, nullable=false, updatable=false*/)
    private Salesman salesman;

     //One order has many orderDetail which included items
    @OneToMany(mappedBy="custOrder"  , cascade = {CascadeType.ALL} ,    fetch=FetchType.LAZY)

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//        @JoinTable(name = "ORDER_DEATIL", joinColumns = {
//            @JoinColumn(name = "ORDER_ID")}, inverseJoinColumns = {
//            @JoinColumn(name = "ORDER_DEATIL_ID")})
    private List<OrderDetail> orderDetails;

    //One order has at most one payment and One Payment is exactly for One order
    @OneToOne(/*optional=true,  cascade = {CascadeType.ALL}, */   fetch=FetchType.LAZY)
    @JoinColumn(name = "PAYMENT_ID" )
    private Payment payment;

    //Multiple orders may use same address
    @ManyToOne(/*cascade = {CascadeType.ALL} , */fetch=FetchType.LAZY)
    @JoinColumn(name = "SHIPPING_ADDRESS_ID" )
    private Address shippingAddress;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }



    public CustOrder() {
    }

    public CustOrder(Integer orderId) {
        this.orderId = orderId;
    }
}
