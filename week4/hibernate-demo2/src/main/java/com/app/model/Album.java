package com.app.model;

import javax.persistence.*;

@Entity
@Table
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int yearReleased;
    @ManyToOne
    private Artist artist;

    public Album(String name, int yearReleased) {
        this.name = name;
        this.yearReleased = yearReleased;
    }

    public Album(String name) {
        this.name = name;
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

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearReleased=" + yearReleased +
                '}';
    }
}
