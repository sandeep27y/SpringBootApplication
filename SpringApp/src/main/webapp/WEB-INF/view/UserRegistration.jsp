<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="user.registration.title"/></title>

<script type="text/javascript">
	function registerWithPost() {
		alert('registerWithPost called');
		this.form.action = "<%= request.getContextPath() %>/user/registerUser";
		this.form.method = 'post';
		alert('Before called');
		this.form.submit();
		alert('after called');
	}
	
	function registerWithGet() {
		alert('registerWithGet called');
		this.form.action = "<%= request.getContextPath() %>/user/registerUserInfo";
		this.form.method = 'get';
		alert('Before called');
		this.form.submit();
		alert('after called');
	}
</script>

<style>
.error {
	color: #ff0000;
}

.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>
<body>
	<form:form action="/register" commandName="employee">
		<form:errors path="*" cssClass="errorblock" element="div"/>
	
		${message}
	
	    <table>
	    	<tr>
	    		<td><spring:message code="user.employeenumber.lbl"/>: </td> 
	    		<td><form:input path="employeeNumber"/></td>
	    		<td><form:errors path="employeeNumber" cssClass="error"/></td>
	    	</tr>
	    	<tr>
	    		<td><spring:message code="user.employeedob.lbl"/>: </td> 
	    		<td><form:input path="birthDate" /> (MM-dd-yyyy)</td>
	    		<td><form:errors path="birthDate" cssClass="error" /></td>
	    	</tr>
	    	<tr>
	    		<td><spring:message code="user.employeefirstname.lbl"/>: </td> 
	    		<td><form:input path="firstName" /></td>
	    		<td><form:errors path="firstName" cssClass="error" /></td>
	    	</tr>	    	
	    	
	    	<tr>
	    		<td><spring:message code="user.employeelastname.lbl"/>: </td> 
	    		<td><form:input path="lastName" /></td>
	    		<td><form:errors path="lastName"  cssClass="error" /></td>
	    	</tr>
	    	<tr>
	    		<td><spring:message code="user.employeegender.lbl"/>: </td> 
	    		<td><form:input path="gender" /></td>
	    		<td><form:errors path="gender"  cssClass="error" /></td>
	    	</tr>
	    	<tr>
	    		<td><spring:message code="user.employeehiredate.lbl"/>: </td> 
	    		<td><form:input path="hireDate" /> (MM-dd-yyyy)</td>
	    		<td><form:errors path="hireDate" cssClass="error" /></td>
	    	</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Register"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>