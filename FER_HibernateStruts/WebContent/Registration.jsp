 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="color: red">
 <html:errors/>
</div>
	<html:form action="register">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">Registration</td>
			</tr>
			<tr>
				<td>FirstName</td>
				<td><html:text name="RegistrationForm" property="firstName"/></td>
			</tr>
			<tr>
				<td>MiddleName</td>
				<td><html:text name="RegistrationForm" property="middleName"/></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><html:text name="RegistrationForm" property="lastName"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><html:text name="RegistrationForm" property="email"/></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><html:text name="RegistrationForm" property="userName"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:text name="RegistrationForm" property="password"/></td>
			</tr>
			<tr>
				<td>MobileNumber</td>
				<td><html:text name="RegistrationForm" property="mobileNumber"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="register"></td>
			</tr>
		</table>
</html:form>
 
 
 