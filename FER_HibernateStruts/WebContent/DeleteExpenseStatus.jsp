 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%boolean deleteValue =(boolean)session.getAttribute("deleteExpense"); --%>  
<%Object deleteValue = session.getAttribute("deleteExpense");


if(deleteValue!=null){%>
expense delete successfully
<%}else{%>
unable to delete expense
<%}%>  



