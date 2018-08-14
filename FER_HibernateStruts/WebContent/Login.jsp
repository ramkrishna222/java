<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%> --%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="color: red">
		<html:errors />
	</div>
	<html:form action="/login">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">Login</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><html:text name="LoginForm" property="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:password name="LoginForm" property="password" /></td>
			</tr>
			<td colspan="2" align="center"><html:submit value="Login" /> <a
				href="Registration.jsp">Registration</a></td>
		</table>
	</html:form>
</body>
</html>

