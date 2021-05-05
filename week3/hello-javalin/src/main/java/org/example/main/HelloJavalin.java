package org.example.main;

import io.javalin.Javalin;

public class HelloJavalin {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8000);
        app.get("/", ctx -> ctx.result("hello GET"));

        System.out.println("check out http://localhost:8000");

        app.post("/", ctx -> ctx.result("hello POST"));

        app.put("/",ctx -> ctx.result("hello PUT"));

        app.delete("/", ctx -> ctx.result("hello DELETE"));

        app.patch("/", ctx -> ctx.result("hello PATCH"));
    }
}
