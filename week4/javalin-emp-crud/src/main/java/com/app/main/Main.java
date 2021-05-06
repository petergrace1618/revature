package com.app.main;

import com.app.model.Employee;
import com.app.service.EmployeeService;
import com.app.service.impl.EmployeeServiceImpl;
import io.javalin.Javalin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImpl();
        Javalin app = Javalin
                .create(config->config.enableCorsForAllOrigins())
                .start(8000);

        populateDB();

        app.post("/employee", ctx -> {
            Employee employee = ctx.bodyAsClass(Employee.class);
            employee = service.createEmployee(employee);
            ctx.json(employee);
        });

        app.put("/employee", ctx -> {
            Employee employee = ctx.bodyAsClass(Employee.class);
            employee = service.createEmployee(employee);
            ctx.json(employee);
        });

        app.get("/employee/:id", ctx -> {
            Employee employee = service.getEmployeeById(Integer.parseInt(ctx.pathParam("id")));
            ctx.json(employee);
        });

        app.get("/employees", ctx -> {
            List<Employee> employees = service.getEmployees();
            ctx.json(employees);
        });

        app.delete("/employee/:id", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            service.deleteEmployee(id);
            ctx.result("Removed employee id="+id);
        });
    }

    private static void populateDB() {

    }
}
