package com.app.model;

public class Employee {
    private int id;
    private String name;
    private int age;
    private long contact;
    private String city;
    private String gender;
    private Department department;

    public Employee() { }

    public Employee(String name, int age, long contact, String city, String gender, Department department) {
//        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.city = city;
        this.gender = gender;
        this.department = department;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) { this.department = department; }

    // TODO: override equals(), hashCode()

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                '}';
    }
}
