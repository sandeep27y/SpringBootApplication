<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/EmployeeInfromation.do" method="post">
    	<h3>Employee Details</h3>
		EmployeeID: &nbsp;<input type="text" name="employeeId" value="10001"/>
    	<input type="submit" />
    </form>
	
	

 	<div align="right" style="margin-top: -85px; margin-right: 230px">
 		<form action="/add" method="post" onsubmit="return validateForm()">
 			<h3 style="margin-right: 108px">Add Employee</h3>
 				<table>
					<tr>
						<td>EmployeeId: </td>
						<td><input type="text" name="employeeId" value="10"/></td>
					</tr>
					<tr>
						<td>EmployeeBirthDate: </td>
						<td><input type="text" name="birthdate" value="04/03/2017"/></td>
					</tr>
	<tr>
		<td>EmployeeFirstName: </td>
		<td><input type="text" name="firstName" value="sandeep" id="validname"/></td>
	</tr>
	<tr>
		<td>EmployeeLastName: </td>
		<td><input type="text" name="lastName" value="kumar"/></td>
	</tr>
	<tr>
		<td>EmployeeGender: </td>
		<td><input type="text" name="gender" value="M"/></td>
	</tr>
	<tr>
		<td>EmployeeHireDate: </td>
		<td><input type="text" name="hiredate" value="09/10/2013"/></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="Add" align="right"/></td>
	</tr>
				</table>
 		</form>
 	</div>
</body>
</html>