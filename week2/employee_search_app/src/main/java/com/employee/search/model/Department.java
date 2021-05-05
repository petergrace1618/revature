package com.employee.search.model;

public class Department {
    private int deptid;
    private String name;
    private String base_location;

    public Department(int deptid) {
        this.deptid = deptid;
    }

    public Department() {
    }

    public Department(int deptid, String name, String base_location) {
        this.deptid = deptid;
        this.name = name;
        this.base_location = base_location;
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

    public String getBase_location() {
        return base_location;
    }

    public void setBase_location(String base_location) {
        this.base_location = base_location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptid=" + deptid +
                ", name='" + name + '\'' +
                ", base_location='" + base_location + '\'' +
                '}';
    }
}
