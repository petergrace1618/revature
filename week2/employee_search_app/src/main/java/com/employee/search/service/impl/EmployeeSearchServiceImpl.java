package com.employee.search.service.impl;

import com.employee.search.dao.EmployeeSearchDAO;
import com.employee.search.dao.impl.EmployeeSearchDAOImpl;
import com.employee.search.exception.BusinessException;
import com.employee.search.model.Employee;
import com.employee.search.service.EmployeeSearchService;

import java.util.List;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {
    private EmployeeSearchDAO employeeSearchDAO = new EmployeeSearchDAOImpl();
    @Override
    public Employee getEmployeeById(int id) throws BusinessException {
        Employee employee = null;
        if (id < 0 || id > 1000) {
            throw new BusinessException("id out of range: "+id);
        } else {
            employee = employeeSearchDAO.getEmployeeById(id);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByName(String name) throws BusinessException {
        return employeeSearchDAO.getEmployeesByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() throws BusinessException {
        return employeeSearchDAO.getAllEmployees();
    }
}
