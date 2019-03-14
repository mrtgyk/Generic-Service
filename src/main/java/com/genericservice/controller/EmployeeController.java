package com.genericservice.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.genericservice.entity.Employee;
import com.genericservice.service.EmployeeService;

@Controller
public class EmployeeController implements Serializable {

	@Autowired(required = true)
	public EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String login(@ModelAttribute("admin") Employee employee, Model model) {
		if (employee.getUsername() != null) {
			Employee registeredEmployee = employeeService.getEmployee(employee.getUsername());
			if (registeredEmployee != null) {
				model.addAttribute("message", "Welcome " + employee.getUsername());
				model.addAttribute("messageType", "information");
			} else {
				model.addAttribute("message", "User not found");
				model.addAttribute("messageType", "warning");
			}
		} else {
			model.addAttribute("message", "User not found");
			model.addAttribute("messageType", "warning");
		}
		return "/index";
	}

}
