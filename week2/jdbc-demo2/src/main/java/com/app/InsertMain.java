package com.app;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.model.Department;
import com.app.model.Employee;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter employee details to register");
        System.out.print("Name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Age: ");
        employee.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.print("Contact: ");
        employee.setContact(Long.parseLong(scanner.nextLine()));
        System.out.print("City: ");
        employee.setCity(scanner.nextLine());
        System.out.print("Gender: ");
        employee.setGender(scanner.nextLine());
        System.out.print("Department id: ");
        Department department = new Department();
        department.setDeptid(Integer.parseInt(scanner.nextLine()));
        employee.setDepartment(department);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        try {
            employee = employeeDAO.createEmployee(employee);
            if (employee.getId() != 0) {
                System.out.println("Employee register success");
                System.out.println(employee);
            }
        } catch (SQLException | BusinessException e) {
            System.out.println("Internal error");
        }
    }
}
