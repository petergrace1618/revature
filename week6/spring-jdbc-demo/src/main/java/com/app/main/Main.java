package com.app.main;

import com.app.model.Employee;
import com.app.dao.EmployeeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcbeans.xml");
        EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");

        Employee employee = new Employee("fred", 23, 123456789, "Fork", "m", 1);
        dao.addEmployee(employee);
        System.out.println(employee);


        System.out.println(dao.getEmployeeById(1));

        //System.out.println(employeeDAO.getAllEmployees());
    }
}
