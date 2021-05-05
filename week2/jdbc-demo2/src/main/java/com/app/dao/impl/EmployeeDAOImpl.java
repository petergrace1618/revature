package com.app.dao.impl;

import com.app.BusinessException;
import com.app.dao.EmployeeDAO;
import com.app.dbutil.PostgresConnection;
import com.app.model.Employee;

import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee createEmployee(Employee employee) throws SQLException, BusinessException {
        Connection connection = PostgresConnection.getConnection();
        String sql = "INSERT INTO employee_schema.employee "+
                "(\"name\", age, contact, city, gender, deptid)"+
                "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setInt(2, employee.getAge());
        preparedStatement.setLong(3, employee.getContact());
        preparedStatement.setString(4, employee.getCity());
        preparedStatement.setString(5, employee.getGender());
        preparedStatement.setInt(6, employee.getDepartment().getDeptid());

        int  c = preparedStatement.executeUpdate();
        if (c == 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
        } else {
            throw new BusinessException("Failed to register");
        }
        return employee;
    }
}
