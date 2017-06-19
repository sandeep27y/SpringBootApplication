package com.example.SpringApp.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringApp.model.Employee;
import com.example.SpringApp.model.EmployeeDetails;
import com.example.SpringApp.service.EmployeeService;
import com.example.SpringApp.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	
	String formName = "UserRegistration";
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	int employeeId;
	@RequestMapping(value="/")
	public String getEmployee() {
		
		System.out.println("first Mapping");
		return "UserRegistration";
	}
	@ModelAttribute
	public Employee addUser(Model model) {
		System.out.println("@ModelAttribute");
		model.addAttribute("employee", new Employee(10, "EmployeeName", "EmployeeLastName", "EmployeeGender"));
		//model.addAttribute("employee", new Employee());
	    return new Employee();
	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(employeeValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	@RequestMapping(value="/EmployeeInfromation.do")
	public String getEmployeeDetails(HttpServletRequest request,Model model){
		employeeId = Integer.parseInt(request.getParameter("employeeId"));
		EmployeeDetails employeeedit=employeeService.getEmployeeInformation(employeeId);
		model.addAttribute("Employee", employeeedit);
		return "EmployeeInformation";	
	}
	
	@RequestMapping(value="/add")
	public String addEmployee(){
		System.out.println("adding Employee");
		return null;
	}
	
	
	   @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public ModelAndView registerUser(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
	        //logger.debug("registerUser method called " + user);

	        ModelAndView modelAndView = new ModelAndView(formName);
	        //modelAndView.addObject("countryCodes", geographicalService.getCountryCodes())
	        if (result.hasErrors()) {
	        	modelAndView.addObject("message", "Not Successfully Registered");
	            return modelAndView;
	        } else {
	        	employeeService.addEmployee(employee);
	            modelAndView.addObject("employee", new Employee());
	            modelAndView.addObject("message", "Successfully Registered");
	            return modelAndView;
	        }
	    }
	
}	
