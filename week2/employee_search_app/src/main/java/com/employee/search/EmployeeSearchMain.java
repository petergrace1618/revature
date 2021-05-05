package com.employee.search;

import com.employee.search.exception.BusinessException;
import com.employee.search.model.Employee;
import com.employee.search.service.EmployeeSearchService;
import com.employee.search.service.impl.EmployeeSearchServiceImpl;

import java.util.List;
import java.util.Scanner;

public class EmployeeSearchMain {
    public static void main(String[] args) {
        System.out.println("Employee Search App");
        Scanner stdin = new Scanner(System.in);
        EmployeeSearchService employeeSearchService = new EmployeeSearchServiceImpl();
        int ch = 0;
        do {
            System.out.println("Search Menu");
            System.out.println("===========");
            System.out.println("Search by: ");
            System.out.println("1..Id");
            System.out.println("2..Name");
            System.out.println("3..Get all employees");
            System.out.println("4..Quit");
            System.out.print(": ");
            try {
                ch = Integer.parseInt(stdin.nextLine());
            } catch(NumberFormatException e) { }

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    try {
                        int id = Integer.parseInt(stdin.nextLine());
                        Employee employee = employeeSearchService.getEmployeeById(id);
                        if (employee != null) {
                            System.out.println("Found employee id="+id);
                            System.out.println(employee);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid id");
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = stdin.nextLine();
                    try {
                        List<Employee> employeeList = employeeSearchService.getEmployeesByName(name);
                        if (employeeList != null && !employeeList.isEmpty()) {
                            System.out.println(employeeList.size()+" employee record(s) found with name like '"+name+"'");
                            for(Employee e: employeeList) {
                                System.out.println(e);
                            }
                        }
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<Employee> employeeList = employeeSearchService.getAllEmployees();
                        if (employeeList != null && employeeList.size() != 0) {
                            System.out.println(employeeList.size()+" employee records found.");
                            for(Employee e: employeeList) {
                                System.out.println(e);
                            }
                        }
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        } while (ch != 4);
    }
}
