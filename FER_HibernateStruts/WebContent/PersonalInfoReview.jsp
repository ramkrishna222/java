<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />
<jsp:useBean id="address" class="com.rs.fer.bean.Address"
	scope="session" />

<%
	PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
	personalInfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
	personalInfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
	personalInfo.getAddress().setCity(request.getParameter("city"));
	personalInfo.getAddress().setState(request.getParameter("state"));
	personalInfo.getAddress().setCountry(request.getParameter("country"));
	String zip = request.getParameter("zip");
	personalInfo.getAddress().setZip(Integer.parseInt(zip));
	if (0 == personalInfo.getAddress().getUserid()){
		personalInfo.getAddress().setUserid(personalInfo.getUser().getId());
	}
%>

<html:form action="displayPersonalInfo.do?method=personalInfoStatus">

	<table border='1' align='center'>
		<tr>
		<tr>
			<td colspan='2' align='center'>PersonalInfoReview</td>
		</tr>
		<td>First Name</td>
		<td><%=personalInfo.getUser().getFirstName()%></td>
		</tr>

		<tr>
			<td>Middle Name</td>
			<td><%=personalInfo.getUser().getMiddleName()%></td>
		</tr>

		<tr>
			<td>Last Name</td>
			<td><%=personalInfo.getUser().getLastName()%></td>
		</tr>

		<tr>
			<td>Email</td>
			<td><%=personalInfo.getUser().getEmail()%></td>
		</tr>

		<tr>
			<td>Mobile Number</td>
			<td><%=personalInfo.getUser().getMobilenumber()%></td>
		</tr>

		<tr>
			<td>AddressLine1</td>
			<td><%=personalInfo.getAddress().getAddressLine1()%></td>
		</tr>
		<tr>
			<td>AddressLine2</td>
			<td><%=personalInfo.getAddress().getAddressLine2()%></td>
		</tr>

		<tr>
			<td>City</td>
			<td><%=personalInfo.getAddress().getCity()%></td>
		</tr>

		<tr>
			<td>State</td>
			<td><%=personalInfo.getAddress().getState()%></td>
		</tr>

		<tr>
			<td>Zip</td>
			<td><%=personalInfo.getAddress().getZip()%></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><%=personalInfo.getAddress().getCountry()%></td>
		</tr>
		<tr>
			<td colspan='2'><input type='submit' value='previous'> <input
				type='submit' value='update'></td>
		</tr>
	</table>
</html:form>