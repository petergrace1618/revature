package com.employee.search.dao;

import com.employee.search.exception.BusinessException;
import com.employee.search.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeSearchDAO {
    public Employee getEmployeeById(int id) throws BusinessException;
    public List<Employee> getEmployeesByName(String name) throws BusinessException;
    public List<Employee> getAllEmployees() throws BusinessException;
}
