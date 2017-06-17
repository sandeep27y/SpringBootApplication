package com.example.SpringApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.SpringApp.model.Department;
import com.example.SpringApp.model.EmployeeDetails;

public class DepartmentDAO {
	PreparedStatement pStatement = null;
	Connection con = DataBaseConnection.getConnection();
	public Department getDepartmentInformation(int id) {
		
		Department department = null;
		ResultSet rs =	null;
		try {
			pStatement = con.prepareStatement("select departments.dept_name As department_name, departments.dept_no As dept_number from departments inner join dept_emp on departments.dept_no=dept_emp.dept_no where dept_emp.emp_no = ?");
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while(rs.next()){
				department = new Department(); 
				department.setDepartmentName(rs.getString("department_name"));
				department.setDepartmentName(rs.getString("department_number"));
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return department;
		
	}
	public boolean updateDepartmentInformation(int employeeId, EmployeeDetails employee) {
		return false;
	}
	public boolean addDepartmentInformation(EmployeeDetails employee2) {
		ResultSet rs = null;
		boolean addSalary = false;
		try{
			pStatement = con.prepareStatement("INSERT INTO departments(dept_no, dept_name) VALUES (?, ?)");
			pStatement.setString(1, employee2.getDeptnumber());
			pStatement.setString(2, employee2.getDeptname());
			
			int x=pStatement.executeUpdate();
			if(x>0)
				addSalary=true;
			else
				addSalary=false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return addSalary;
	}
	public boolean addDepartmentInformationWithEmpNumber(EmployeeDetails employee2) {
		ResultSet rs = null;
		boolean addSalary = false;
		try{
			pStatement = con.prepareStatement("INSERT INTO dept_emp(emp_no, dept_no, from_date, to_date) VALUES (?, ?,?,?)");
			pStatement.setInt(1, employee2.getEmployeeNo());
			pStatement.setString(2, employee2.getDeptnumber());
			pStatement.setDate(3, employee2.getFromdate());
			pStatement.setDate(4, employee2.getTodate());
			int x=pStatement.executeUpdate();
			if(x>0)
				addSalary=true;
			else
				addSalary=false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return addSalary;
	}

}
