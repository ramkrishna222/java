<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>

<div style="color: red">
	<html:errors />
</div>
<html:form action="/ExpenseReport">
	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center"> Get Expense</td>
		</tr>
		<tr>
			<td>Type</td>
			<td><html:text name="ExpenseReportForm" property="type"  value=" "/></td>
		</tr>
		<tr>
			<td>From Date</td>
			<td><html:text name="ExpenseReportForm" property="fromDate"  value=" "/></td>
		</tr>
		<tr>
			<td>To Date</td>
			<td><html:text name="ExpenseReportForm" property="toDate" value=" "/></td>
		</tr>
<tr>
		<td colspan="2" align="center"><html:submit value="Get Report" />
		</tr>
	</table>
</html:form>
