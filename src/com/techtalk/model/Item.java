package com.techtalk.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="ITEM")

public class Item implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID" )
    private Integer itemId;
    @Column(name = "ITEM_NAME" , length = 30)
    private String itemName;
    @Column(name = "ITEM_DESCRIPTION" , length = 60)
    private String itemDescription;
    @Column(name = "QUNTITY_IN_STOCK" )
    private Integer quantityInStock;
    @Column(name = "PRICE", precision = 10, scale = 2)
    private Double price;
    @ManyToMany(mappedBy="items" ,cascade = {CascadeType.ALL},    fetch=FetchType.LAZY)
    private Collection<Supplier> suppliers = new ArrayList<Supplier>();

    @Transient
    private Integer[] supplierIdList;



    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Collection<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Collection<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer[] getSupplierIdList() {
        return supplierIdList;
    }

    public void setSupplierIdList(Integer[] supplierIdList) {
        this.supplierIdList = supplierIdList;
    }


}
