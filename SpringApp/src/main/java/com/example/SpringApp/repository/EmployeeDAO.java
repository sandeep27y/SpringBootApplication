package com.example.SpringApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.SpringApp.model.Employee;
import com.example.SpringApp.model.EmployeeDetails;

@Repository
public class EmployeeDAO {
	PreparedStatement pStatement = null;
	Connection con = DataBaseConnection.getConnection();
	public Employee getEmployeeInformation(int id){
		Employee e = null;
		ResultSet rs =	null;
		try {
			pStatement = con.prepareStatement("select * from employees where emp_no=?");
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while(rs.next()){
				e = new Employee(Integer.parseInt(rs.getString("emp_no")), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),rs.getDate("hire_date"));
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return e;
		
	}

	public boolean updateEmployeeInformation(int employeeId,EmployeeDetails employee) {
		boolean x=false;
			try {
				pStatement = con.prepareStatement("update employees set first_name = ?,last_name=?, gender=? where emp_no = ?");
				pStatement.setString(1, employee.getFirstNAme());
				pStatement.setString(2, employee.getLastName());
				pStatement.setString(3, employee.getGender());
				pStatement.setInt(4, employeeId);
				int rows=pStatement.executeUpdate();
				
				if(rows>0)
					x=true;
				else
					x=false;				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
	return x;
	}

	public boolean addEmployeeInformation(EmployeeDetails employee) {
		ResultSet rs = null;
		boolean addEmployee = false;
		try{
			pStatement = con.prepareStatement("INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?)");
			pStatement.setInt(1, employee.getEmployeeNo());
			pStatement.setDate(2, employee.getBirthDate());
			pStatement.setString(3, employee.getFirstNAme());
			pStatement.setString(4, employee.getLastName());
			pStatement.setString(5, employee.getGender());
			pStatement.setDate(6, employee.getHireDate());
			int x=pStatement.executeUpdate();
			if(x>0)
				addEmployee=true;
			else
				addEmployee=false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return addEmployee;
	}
	
	public boolean addEmployee(Employee employee){
		ResultSet rs = null;
		boolean addEmployee = false;
		try{
			pStatement = con.prepareStatement("INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?)");
			pStatement.setInt(1, employee.getEmployeeNumber());
			
			
			pStatement.setDate(2, new java.sql.Date(employee.getBirthDate().getTime()));
			pStatement.setString(3, employee.getFirstName());
			pStatement.setString(4, employee.getLastName());
			pStatement.setString(5, employee.getGender());
			pStatement.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
			int x=pStatement.executeUpdate();
			if(x>0)
				addEmployee=true;
			else
				addEmployee=false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return addEmployee;
	}
}
