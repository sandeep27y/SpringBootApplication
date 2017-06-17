package com.example.SpringApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringApp.model.EmployeeDetails;
import com.example.SpringApp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	int employeeId;
	@RequestMapping(value="/")
	public String getEmployee() {
		return "address";
	}
	
	@RequestMapping(value="/EmployeeInfromation.do")
	public String getEmployeeDetails(HttpServletRequest request,Model model){
		employeeId = Integer.parseInt(request.getParameter("employeeId"));
		EmployeeDetails employeeedit=employeeService.getEmployeeInformation(employeeId);
		System.out.println("testing: "+employeeId);
		return null;
		
	}
}	
