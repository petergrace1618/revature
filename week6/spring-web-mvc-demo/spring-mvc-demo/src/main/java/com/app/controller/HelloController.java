package com.app.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@ComponentScan(basePackages = "com.app")
@Controller
public class HelloController {

	@RequestMapping("/")
	public String showWelcome() {
		return "welcome";
	}

	@RequestMapping("/hello")
	public String showHello(@RequestParam("name") String name, ModelMap map) {
		map.addAttribute("name", "Name: "+name);
		return "hello";
	}

	
}
