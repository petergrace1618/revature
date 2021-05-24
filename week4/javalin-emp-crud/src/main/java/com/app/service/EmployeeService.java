package com.app.service;

import com.app.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public Employee updateEmployee(Employee employee);
    public List<Employee> getEmployees();
//    public List<Employee> getEmployeesByAge(int age);
    public void deleteEmployee(int id);
}
