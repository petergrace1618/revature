package com.employee.search.dao.impl;

import com.employee.search.dao.EmployeeSearchDAO;
import com.employee.search.dao.dbutil.PostgreSqlConnection;
import com.employee.search.exception.BusinessException;
import com.employee.search.model.Department;
import com.employee.search.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {
    @Override
    public Employee getEmployeeById(int id) throws BusinessException {
        Employee employee = null;
        try(Connection connection = PostgreSqlConnection.getConnection()) {
            String sql = "select id, e.name as employee_name, e.age, e.contact, e.city, e.gender, e.deptid, "+
                    "d.name as department_name, d.base_location from employee_schema.employee as e "+
                    "left join employee_schema.department as d on e.deptid = d.deptid where e.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Department department = new Department();
                department.setDeptid(resultSet.getInt("deptid"));
                department.setName(resultSet.getString("department_name"));
                department.setBase_location(resultSet.getString("base_location"));
                employee = new Employee();
                employee.setDepartment(department);
                employee.setId(id);
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(resultSet.getString("city"));
                employee.setContact(resultSet.getLong("contact"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setGender(resultSet.getString("gender"));
            } else {
                throw new BusinessException("employee id "+id+" not found");
            }
        } catch(SQLException e) {
            throw new BusinessException("Internal error: "+e.getMessage());
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByName(String name) throws BusinessException {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = PostgreSqlConnection.getConnection()) {
            String sql = "select id, e.name as employee_name, e.age, e.contact, e.city, e.gender, e.deptid, "+
                    "d.name as department_name, d.base_location from employee_schema.employee as e "+
                    "left join employee_schema.department as d on e.deptid = d.deptid where e.name like concat('%',?,'%');";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDeptid(resultSet.getInt("deptid"));
                department.setName(resultSet.getString("department_name"));
                department.setBase_location(resultSet.getString("base_location"));
                Employee employee = new Employee();
                employee.setDepartment(department);
                employee.setId(resultSet.getInt("id"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(resultSet.getString("city"));
                employee.setContact(resultSet.getLong("contact"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setGender(resultSet.getString("gender"));
                employeeList.add(employee);
            }
            if (employeeList.size() == 0) {
                throw new BusinessException("No employees found");
            }
        } catch(SQLException e) {
            throw new BusinessException("Internal error: "+e.getMessage());
        }
        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployees() throws BusinessException {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = PostgreSqlConnection.getConnection()) {
            String sql = "select id, e.name as employee_name, e.age, e.contact, e.city, e.gender, e.deptid, "+
                    "d.name as department_name, d.base_location from employee_schema.employee as e "+
                    "left join employee_schema.department as d on e.deptid = d.deptid";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDeptid(resultSet.getInt("deptid"));
                department.setName(resultSet.getString("department_name"));
                department.setBase_location(resultSet.getString("base_location"));
                Employee employee = new Employee();
                employee.setDepartment(department);
                employee.setId(resultSet.getInt("id"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(resultSet.getString("city"));
                employee.setContact(resultSet.getLong("contact"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setGender(resultSet.getString("gender"));
                employeeList.add(employee);
            }
            if (employeeList.size() == 0) {
                throw new BusinessException("No employees found");
            }
        } catch(SQLException e) {
            throw new BusinessException("Internal error: "+e.getMessage());
        }
        return employeeList;
    }
}
