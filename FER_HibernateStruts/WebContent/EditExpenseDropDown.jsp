<%@page import="com.rs.fer.bean.Expense,java.util.*"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>


	<%
		List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");
			if (expenses != null && !expenses.isEmpty()) {
	%>

<html:form action="displayEditExpense.do?method=displayEditExpense">
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

	</select> <html:submit value='Edit' />
	</html:form>

	<%
		} else {
	%>
No expenses found..
</center>
<%
		}
	%>
