<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="com.rs.fer.bean.PersonalInfo,com.rs.fer.bean.User,com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
	FERService ferservice = new FERServiceImpl();
	String username = session.getAttribute("username").toString();
	PersonalInfo personalInfo = ferservice.getPersonalInfo(username);
	session.setAttribute("personalInfo", personalInfo);
%>

<html:form action="displayPersonalInfo.do?method=contactInfo">
	<table border='1' align='center'>
		<tr>
			<td colspan='2' align='center'>PersonalNameInfo</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name='firstName'
				value="<%=personalInfo.getUser().getFirstName()%>"></td>
		</tr>
		<tr>
			<td>Middle Name</td>
			<td><input type="text" name='middleName'
				value="<%=personalInfo.getUser().getMiddleName()%>"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name='lastName'
				value="<%=personalInfo.getUser().getLastName()%>"></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type='submit' value='Next'></td>

		</tr>

	</table>
</html:form>


