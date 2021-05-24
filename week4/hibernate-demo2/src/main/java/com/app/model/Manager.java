package com.app.model;

import javax.persistence.*;

@Entity
@Table
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String agencyName;

    public Manager(String name) {
        this.name = name;
    }

    public Manager(String name, String agencyName) {
        this.name = name;
        this.agencyName = agencyName;
    }

    public Manager(int id, String name, String agencyName) {
        this.id = id;
        this.name = name;
        this.agencyName = agencyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", agencyName='" + agencyName + '\'' +
                '}';
    }
}
