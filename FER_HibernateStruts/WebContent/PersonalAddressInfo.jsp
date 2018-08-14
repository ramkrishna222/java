<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:useBean id="address" class="com.rs.fer.bean.Address"
	scope="session" />
<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
	PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
%>
<html:form action="displayPersonalInfo.do?method=review">
<table border='1' align='center'>
	<tr>
			<td colspan='2' align='center'>PersonalAddressInfo</td>
		</tr>

		<tr>
			<td>AddressLine1</td>
			<td><input type='text' name='addressLine1'
				value="<%=personalInfo.getAddress().getAddressLine1()%>"></td>
		</tr>
		<tr>
			<td>AddressLine2</td>
			<td><input type='text' name='addressLine2'
				value="<%=personalInfo.getAddress().getAddressLine2()%>"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type='text' name='city'
				value="<%=personalInfo.getAddress().getCity()%>"></td>
		</tr>
		
		<tr>
			<td>State</td>
			<td><input type='text' name='state'
				value="<%=personalInfo.getAddress().getState()%>"></td>
		</tr>
		<tr>
			<td>Zip</td>
			<td><input type='text' name='zip'
				value="<%=personalInfo.getAddress().getZip()%>"></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><input type='text' name='country'
				value="<%=personalInfo.getAddress().getCountry()%>"></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type='submit' value='Next'></td>
		</tr>
	</table>
</html:form>
