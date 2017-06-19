package com.example.SpringApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.SpringApp.model.Department;
import com.example.SpringApp.model.Employee;
import com.example.SpringApp.model.EmployeeDetails;
import com.example.SpringApp.model.Salary;
import com.example.SpringApp.repository.DepartmentDAO;
import com.example.SpringApp.repository.EmployeeDAO;
import com.example.SpringApp.repository.SalaryDAO;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;
	@Autowired
	SalaryDAO salaryDAO;
	@Autowired
	DepartmentDAO departmentDAO;
		public EmployeeDetails getEmployeeInformation(int id){
			Employee employee=employeeDAO.getEmployeeInformation(id);
			Salary salary=salaryDAO.getSalaryInformation(id);
			Department department=departmentDAO.getDepartmentInformation(id);
			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setEmployeeNo(employee.getEmployeeNumber());
			employeeDetails.setFirstNAme(employee.getFirstName());
			employeeDetails.setLastName(employee.getLastName());
			employeeDetails.setGender(employee.getGender());
			//employeeDetails.setHireDate(employee.getHireDate());
			employeeDetails.setSalary(salary.getSalary());
			employeeDetails.setDeptname(department.getDepartmentName());
			return employeeDetails;
			
		}

		public boolean updateEmployeeInformation(int employeeId,EmployeeDetails employee) {			
			 boolean EmployeeValidation = employeeDAO.updateEmployeeInformation(employeeId,employee);
			 boolean SalaryValidation=salaryDAO.updateSalaryInformation(employeeId,employee);
			 //boolean DepartmentValidation=departmentDAO.updateDepartmentInformation(employeeId,employee);
			 if(EmployeeValidation && SalaryValidation)
					return true;
				else
					return false;
		}

	/*	public boolean addEmployeeInformation(EmployeeDetails employee2) {
			// TODO Auto-generated method stub
			boolean EmployeeValidation = employeeDAO.addEmployeeInformation(employee2);
			boolean SalaryValidation = salaryDAO.addSalaryInformation(employee2);
			//boolean DepartmentValidation = departmentDAO.addDepartmentInformation(employee2);
			//boolean DepartmentValidationWithEmpNumber = departmentDAO.addDepartmentInformationWithEmpNumber(employee2);
			if(EmployeeValidation && SalaryValidation)
				return true;
			else
				return false;
		}*/
		
		public void addEmployee(Employee employee){
			employeeDAO.addEmployee(employee);
		}
	}
