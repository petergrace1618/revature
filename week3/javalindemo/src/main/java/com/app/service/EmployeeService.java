package com.app.service;

import com.app.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeeList();
    List<Employee> getEmployees();
}
