package com.employee.search.service;

import com.employee.search.exception.BusinessException;
import com.employee.search.model.Employee;
import java.util.List;

public interface EmployeeSearchService {
    public Employee getEmployeeById(int id) throws BusinessException;
    public List<Employee> getEmployeesByName(String name) throws BusinessException;
    public List<Employee> getAllEmployees() throws BusinessException;
}
