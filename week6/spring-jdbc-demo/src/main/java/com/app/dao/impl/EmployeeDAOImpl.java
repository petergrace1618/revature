package com.app.dao.impl;

import com.app.dao.mapper.EmployeeRowMapper;
import com.app.model.Employee;
import com.app.dao.EmployeeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAOImpl implements EmployeeDAO {
    private JdbcTemplate template;
    private DataSource dataSource;
    private SimpleJdbcInsert sji;

    private EmployeeDAOImpl() {}

//    public EmployeeDAOImpl(DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.template = new JdbcTemplate(this.dataSource);
//        sji = new SimpleJdbcInsert(dataSource)
//                .withTableName("employee_schema.employee")
//                .usingGeneratedKeyColumns("id");
//    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(this.dataSource);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", employee.getName());
        params.put("age", employee.getAge());
        params.put("contact", employee.getContact());
        params.put("city", employee.getCity());
        params.put("gender", employee.getGender());
        params.put("deptid", employee.getDeptid());
        employee.setId((int) sji.executeAndReturnKey(params));
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select id, name, age, contact, city, gender, deptid "+
                "from employee_schema.employee;";
        List<Employee> employees = template.query(sql, new EmployeeRowMapper());
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        String sql = "update employee_schema.employee "+
                "set name = ?, age = ?, contact = ?, city = ?, gender = ?, deptid = ? where id = ?;";
        template.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getContact(),
                employee.getCity(),
                employee.getGender(),
                employee.getDeptid(),
                employee.getId());
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        String sql = "delete from employee_schema.employee where id = ?;";

    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "select id, name, age, contact, city, gender, deptid "+
                "from employee_schema.employee where id = ?;";
        Employee employee = template.queryForObject(sql, new Object[] {id}, new EmployeeRowMapper());
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByAge(int age) {
        String sql = "select id, name, age, contact, city, gender, deptid "+
                "from employee_schema.employee where age = ?;";
        List<Employee> employees = template.query(sql, new EmployeeRowMapper());
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        return null;
    }
}
