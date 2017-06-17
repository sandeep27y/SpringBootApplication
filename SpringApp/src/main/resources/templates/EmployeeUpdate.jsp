<%@page import="com.example.SpringApp.model.EmployeeDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="EmployeeDetails" value="${requestScope.EmployeeDetails}"></c:set>
<div style="margin-top: 50px; margin-left: 10px;">
<form action="/EmployeeApplication/update" method="post">
<h3 style="margin-left: 56px">Update Employee Details</h3>
<table>
	<tr>
		<td>EmployeeId:</td><td><input type="text" value="${EmployeeDetails.getEmployeeNo()}" name="employeeId" disabled="disabled" /></td>
	</tr>
	<tr>
		<td>EmployeeFirstName: </td><td><input type="text" name="firstName" value="${EmployeeDetails.getFirstNAme()}"/></td>
	</tr>
	<tr>
		<td>EmployeeLastName: </td><td><input type="text" name="lastName" value="${EmployeeDetails.getLastName()}"></td>
	</tr>
	<tr>
		<td>EmployeeGender: </td><td><input type="text" name="gender" value="${EmployeeDetails.getGender()}"></td>
	</tr>
	<tr>
		<td>JoinDate: </td><td><input type="text" name="hireDate" value="${EmployeeDetails.getHireDate()}"></td>
	</tr>
	<tr>
		<td>DepartmentName: </td><td><input type="text" name="departmentName" value="${EmployeeDetails.getDeptname()}"></td>
	</tr>
	<tr>
		<td>Salary: </td><td><input type="text" name="salary" value="${EmployeeDetails.getSalary()}"></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="Update"></td>
	</tr>
	<tr>
		<td colspan="2"><c:out value="${requestScope.display}"></c:out></td>
	</tr>
</table>

</form>
</div>
</body>
</html>