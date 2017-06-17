package com.example.SpringApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.SpringApp.model.EmployeeDetails;
import com.example.SpringApp.model.Salary;

public class SalaryDAO {
	PreparedStatement pStatement = null;
	Connection con = DataBaseConnection.getConnection();
	public boolean addSalaryInformation(EmployeeDetails employee) {
		ResultSet rs = null;
		boolean addSalary = false;
		try{
			pStatement = con.prepareStatement("INSERT INTO salaries(emp_no, salary, from_date, to_date) VALUES (?, ?, ?, ?)");
			pStatement.setInt(1, employee.getEmployeeNo());
			pStatement.setDouble(2, employee.getSalary());
			pStatement.setDate(3, employee.getFromdate());
			pStatement.setDate(4, employee.getTodate());
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
	public Salary getSalaryInformation(int id) {
		Salary salary = null;
		ResultSet rs =	null;
		try {
			pStatement = con.prepareStatement("select MIN(salary) as MinSalary from salaries where emp_no=?");
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while(rs.next()){
				salary = new Salary(); 
				salary.setSalary(Double.parseDouble(rs.getString("MinSalary")));
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return salary;
		
	}
	public boolean updateSalaryInformation(int employeeId, EmployeeDetails employee) {
		boolean x=false;
		try {
			pStatement = con.prepareStatement("update salaries set salaries = ? where emp_no = ?");
			pStatement.setDouble(1, employee.getSalary());
			pStatement.setInt(2, employeeId);
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
}