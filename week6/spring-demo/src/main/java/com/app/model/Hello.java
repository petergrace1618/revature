package com.app.model;

public class Hello {
    private String message;

    public Hello() {
        System.out.println("No param constructor called");
    }
    public Hello(String message) {
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
