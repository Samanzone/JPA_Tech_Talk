package com.techtalk.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 12:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="ORDER_DEATIL")
public class OrderDetail  implements  java.io.Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY  )
    @Column(name = "ORDER_DEATIL_ID" )
    private Long orderDetailId;

    //Many OrderDetail refer to one Item
    @ManyToOne(/*optional=false,cascade = {CascadeType.ALL},*/    fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    private Item item;

    //Many OrderDetail are in one custOrder
    @ManyToOne(cascade = {CascadeType.ALL},    fetch=FetchType.LAZY)
    @JoinColumn(name="ORDER_ID")
    private CustOrder custOrder;

    @Column(name = "QUNTITY")
    private Integer quantity;

    @Column(name = "LINE_AMOUNT")
    private Double lineAmount;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public CustOrder getCustOrder() {
        return custOrder;
    }

    public void setCustOrder(CustOrder custOrder) {
        this.custOrder = custOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }
}
