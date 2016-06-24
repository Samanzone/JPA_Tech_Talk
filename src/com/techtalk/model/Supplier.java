package com.techtalk.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="SUPPLIER")
public class Supplier extends Person implements  java.io.Serializable {

    @Column(name = "SUPPLIER_CODE")
	private String supplierCode;
    @Column(name = "BACK_LISTED")
    private Boolean backListed;
    @ManyToMany(  cascade = {CascadeType.ALL},    fetch=FetchType.LAZY)
    @JoinTable(name="ITEM_SUPPLIER",
                      joinColumns={@JoinColumn(name="SUPPLIER_ID", referencedColumnName = "ID")},
                      inverseJoinColumns={@JoinColumn(name="ITEM_ID" ,   referencedColumnName = "ITEM_ID")})
    private Collection<Item> items = new ArrayList<Item>();




    @Transient
    private Integer[] itemIdList;


    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Boolean getBackListed() {
        return backListed;
    }

    public void setBackListed(Boolean backListed) {
        this.backListed = backListed;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }


    public Integer[] getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(Integer[] itemIdList) {
        this.itemIdList = itemIdList;
    }
}
