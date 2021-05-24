package com.app.model;

public class HelloLazy {
    private String message;

    public HelloLazy() {
        System.out.println("No param constructor called");
    }
    public HelloLazy(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Setter method was called with message = "+message);
        this.message = message;
    }
}
