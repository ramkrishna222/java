<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.rs.fer.bean.Expense,java.util.*"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
<html:form action="displayDeleteExpense.do?method=deleteExpenseStatus">

	<%
    List<Expense> expenses=(List<Expense>)session.getAttribute("expenses");
	if (expenses != null && !expenses.isEmpty()) {
	%>

	<center>
	<select name='id'>
			<%
				for (Expense expense : expenses) {
			%>
			<option value='<%=expense.getId()%>'>
				<%=expense.getType()%>,
				<%=expense.getDate()%>,
				<%=expense.getPrice()%>,
				<%=expense.getNoOfItems()%>,
				<%=expense.getTotal()%>,
				<%=expense.getBywhom()%></option>
			<%
				}
			%>

	</select> <html:submit value='Delete' />

	<%
		} else {
	%>
No expenses found..
</center>
<%
		}
	%>
</html:form>
