package com.tmj.bookshop.model;

public class OrderAddress {
    private Integer addressId;

    private String receiver;

    private String phone;

    private String postcode;

    private String addressName;

    private String fhfs;

    private Integer userId;

    private Integer mraddress;

    private Integer isvoid;

    public OrderAddress(Integer addressId, String receiver, String phone, String postcode, String addressName, String fhfs, Integer userId, Integer mraddress, Integer isvoid) {
        this.addressId = addressId;
        this.receiver = receiver;
        this.phone = phone;
        this.postcode = postcode;
        this.addressName = addressName;
        this.fhfs = fhfs;
        this.userId = userId;
        this.mraddress = mraddress;
        this.isvoid = isvoid;
    }

    public OrderAddress() {
        super();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getFhfs() {
        return fhfs;
    }

    public void setFhfs(String fhfs) {
        this.fhfs = fhfs;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMraddress() {
        return mraddress;
    }

    public void setMraddress(Integer mraddress) {
        this.mraddress = mraddress;
    }

    public Integer getIsvoid() {
        return isvoid;
    }

    public void setIsvoid(Integer isvoid) {
        this.isvoid = isvoid;
    }
}