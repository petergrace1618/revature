package com.app.model;

public class Address {
    private int aid;
    private String city;
    private int zip;

    public Address() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
}
