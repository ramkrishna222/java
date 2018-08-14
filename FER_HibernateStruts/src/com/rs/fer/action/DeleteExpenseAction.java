package com.rs.fer.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseAction extends DispatchAction {

	public ActionForward deleteExpense(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses();
		session.setAttribute("expenses", expenses);
		return mapping.findForward("DeleteDropDown");

	}

	public ActionForward deleteExpenseStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String idobj = request.getParameter("id");
		FERService ferService = new FERServiceImpl();
		int id = Integer.parseInt(idobj);
		/*
		 * DataSource datasource = getDataSource(request, "Fer_Struts");
		 * Connection connection = datasource.getConnection();
		 */

		boolean deleteExpense = ferService.deleteValue(id);
		// session.setAttribute("id", id);
		session.setAttribute("deleteExpense", deleteExpense);
		return mapping.findForward("deleteExpenseStatus");

	}
}
