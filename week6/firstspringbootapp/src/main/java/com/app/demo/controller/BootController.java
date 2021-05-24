package com.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {
    @GetMapping("/")
    public String helloGet() {
        return "BootController.helloGet: working";
    }

}
