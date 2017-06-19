package com.example.SpringApp.validator;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.SpringApp.model.Employee;
import org.springframework.util.StringUtils;
@Component
public class EmployeeValidator implements Validator {
	final static Logger logger = Logger.getLogger(EmployeeValidator.class);
	
	public boolean supports(Class<?> clazz) {
		logger.debug("supports called");
		if (clazz.equals(Employee.class)) {
			return true;
		}
		
		return false;
	}

	public void validate(Object object, Errors errors) {
		logger.debug("validate called");
		
		Employee employee = (Employee) object;
		
		ValidationUtils.rejectIfEmpty(errors, "employeeNumber", "user.employeenumber.empty.err");
		ValidationUtils.rejectIfEmpty(errors, "birthDate", "user.employeedob.empty.err");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "user.employeefirstname.empty.err");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "user.employeelastname.empty.err");
		ValidationUtils.rejectIfEmpty(errors, "gender", "user.employeegender.empty.err");
		ValidationUtils.rejectIfEmpty(errors, "hireDate", "user.employeehiredate.empty.err");

		/*if (! isValidUserName(employee.getFirstName())) {
			errors.reject("firstName", "user.username.empty.err");
		}	*/	
		if (! isValidEmployeeNumber(employee.getEmployeeNumber())) {
			errors.rejectValue("employeeNumber","", "Employee Number shouldn't be zero");
		}	
		
	}

	

	private boolean isValidUserName(String firstName) {
		
		if (StringUtils.isEmpty(firstName)) {
			return false;
		}
		
		if(firstName.trim().length() < 5) {
			return false;
		}
		
		return firstName.matches("^[a-zA-Z0-9_]*$");
	}
	
	private boolean isValidEmployeeNumber(int number){
		if(number == 0){
			return false;
		}
		return true;
	}

	
}