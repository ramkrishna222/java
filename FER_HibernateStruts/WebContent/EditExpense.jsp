<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="com.rs.fer.service.FERService"%>
	<%@page import="com.rs.fer.service.FERServiceImpl" %>
	<%@page import="java.lang.*" %>
	<%@page import="java.util.*" %>
	<%@page import="com.rs.fer.bean.Expense" %>
<html:form action="displayEditExpense.do?method=editExpenseStatus">

	<%
		Expense expense = (Expense) session.getAttribute("expense");
			if (expense != null) {
	%>
	<table border='1' align='center'>
		<tr height='50px'>
			<td align='center' colspan='2'>Edit Expense</td>
		</tr>

		<tr>
			<td>Type</td>
			<td><html:text name="AddExpenseForm" property='type'
					value="<%=expense.getType()%>" /></td>


		</tr>
		<tr>
			<td>Date</td>
			<td><html:text name="AddExpenseForm" property='date'
					value="<%=expense.getDate()%>" /></td>


		</tr>
		<tr>
			<td>Price</td>
			<td><html:text name="AddExpenseForm" property='price'
					value="<%=expense.getPrice()%>" /></td>
		</tr>

		<tr>
			<td>NoOfItems</td>
			<td><html:text name="AddExpenseForm" property='noOfItems'
					value="<%=expense.getNoOfItems()%>" /></td>
		</tr>

		<tr>
			<td>Total </td>
			<td><html:text name="AddExpenseForm" property='total'
					value="<%=expense.getTotal()%>" /></td>
		</tr>
		<tr>
			<td>By whom</td>
			<td><html:text name="AddExpenseForm" property='bywhom'
					value="<%=expense.getBywhom()%>" /></td>


		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value='Update' /></td>
		</tr>

	</table>
	<%
		}
	%>

</html:form>

