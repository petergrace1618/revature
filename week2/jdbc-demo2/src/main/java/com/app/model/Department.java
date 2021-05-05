package com.app.model;

public class Department {
    private int deptid;
    private String name;
    private String baseLocation;

    public Department(int deptid) {
        this.deptid = deptid;
    }

    public Department() { }

    public Department(int deptid, String name, String baseLocation) {
        this.deptid = deptid;
        this.name = name;
        this.baseLocation = baseLocation;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptid=" + deptid +
                ", name='" + name + '\'' +
                ", base_location='" + baseLocation + '\'' +
                '}';
    }
}
