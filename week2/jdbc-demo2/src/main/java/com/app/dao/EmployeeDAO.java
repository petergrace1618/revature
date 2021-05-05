package com.app.dao;

import com.app.BusinessException;
import com.app.model.Employee;
import java.sql.SQLException;

public interface EmployeeDAO {
    public Employee createEmployee(Employee employee) throws SQLException, BusinessException;
}
