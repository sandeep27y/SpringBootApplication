<%@page import="com.example.SpringApp.model.EmployeeDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel = "stylesheet" type = "text/css" href = "Employee.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<h2 align="center">Employee Details</h2>
<table border="1" align="center" class="table">
	<tr align="center">
		<th>EmployeeId</th><th>EmployeeFirstName</th><th>EmployeeLastName</th><th>EmployeeGender</th>
		<th>JoinDate</th><th>DepartmentName</th><th>MinSalary</th><th>Operations</th>		
	</tr>
<c:set var="employee" value="${requestScope.Employee}"></c:set>
	<tr class="info">
		<td align="center"><c:out value="${employee.getEmployeeNo()}"/></td>
		<td align="center"><c:out value="${employee.getFirstNAme()}"/></td>
		<td align="center"><c:out value="${employee.getLastName()}"/></td>
		<td align="center"><c:out value="${employee.getGender()}"/></td>
		<td align="center"><c:out value="${employee.getHireDate()}"/></td>
		<td align="center"><c:out value="${employee.getDeptname()}"/></td>
		<td align="center"><c:out value="${employee.getSalary()}"/></td>
		<td><a href="edit?id=<c:out value='${employee.getEmployeeNo()}'/>">Update</a></td>
		
	</tr>
</table>
</body>
</html>