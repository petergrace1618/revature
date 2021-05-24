package com.app.dao.mapper;

import com.app.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setAge(rs.getInt("age"));
        employee.setContact(rs.getLong("contact"));
        employee.setCity(rs.getString("city"));
        employee.setGender(rs.getString("gender"));
        employee.setDeptid(rs.getInt("deptid"));
        return employee;
    }
}
