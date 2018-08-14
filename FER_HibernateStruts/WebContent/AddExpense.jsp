<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>


<div style="color: red">
	<html:errors />
</div>

<html:form action="AddExpense">
	<table border='1' align='center'>
		<tr>
			<td colspan='2' align="center">AddExpense</font></td>
		</tr>

		<tr>
			<td>Type</td>
			<td><html:text name="AddExpenseForm" property="type" /></td>
		</tr>

		<tr>
			<td>Date</td>
			<td><html:text name="AddExpenseForm" property="date" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><html:text name="AddExpenseForm" property="price" /></td>
		</tr>
		<tr>
			<td>NoOfItems</td>
			<td><html:text name="AddExpenseForm" property="noOfItems" /></td>
		</tr>
		<tr>
			<td>Total</td>
			<td><html:text name="AddExpenseForm" property="total" /></td>
		</tr>
		<tr>
			<td>Bywhom</td>
			<td><html:text name="AddExpenseForm" property="bywhom" /></td>
		</tr>
		<td colspan='2' align='center'><html:submit value="Add" /></td>
		</tr>
	</table>
</html:form>
