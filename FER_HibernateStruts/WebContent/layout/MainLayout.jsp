<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	function submitForm(urlaction) {
		var form = document.forms[0];
		form.action = urlaction;
		form.submit();
	}
</script>
</head>
<body>
	<table width='600px' height='600px' border='1' align="center">
		<tr height='100px'>
			<td colspan="2"><tiles:insert attribute="header" /></td>
		</tr>
		<tr height='400px'>
			<td width='100px'><tiles:insert attribute="leftFrame" /></td>
			<td width='500px'><tiles:insert attribute="body" /></td>
		</tr>
		<tr height='100px'>
			<td colspan="2"><tiles:insert attribute="footer" /></td>
		</tr>
	</table>

</body>
</html>