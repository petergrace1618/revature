package com.app.service.impl;

import com.app.model.Employee;
import com.app.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private static Map<Integer, Employee> map = new HashMap<>();
    private static int counter = 1000;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(counter++);
        map.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return map.get(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        map.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(map.values());
    }

//    @Override
//    public List<Employee> getEmployeesByAge(int age) {
//
//        return map.values().stream().filter(emp->emp.getAge()==age).collect(Collectors.toList());
//    }

    @Override
    public void deleteEmployee(int id) {
        map.remove(id);
    }
}
