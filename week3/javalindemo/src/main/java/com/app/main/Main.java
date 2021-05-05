package com.app.main;

import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceImpl;
import io.javalin.Javalin;
import com.app.model.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImpl();
        Javalin app = Javalin.create().start(8000);

        app.post("/employee", ctx -> {
            Employee employee = ctx.bodyAsClass(Employee.class);
            employee = service.createEmployee(employee);
            ctx.result(employee.toString());
        });
    }
}
