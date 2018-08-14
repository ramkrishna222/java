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
import com.rs.fer.form.AddExpenseForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseAction extends DispatchAction {
	FERService ferService = new FERServiceImpl();

	public ActionForward DisplayExpenses(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("id", request.getParameter("id"));
		List<Expense> expenses = ferService.getExpenses();

		session.setAttribute("expenses", expenses);
		return mapping.findForward("editdropdown");

	}

	public ActionForward displayEditExpense(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String idinfo = request.getParameter("id");
		int id = Integer.parseInt(idinfo);
		Expense expense = ferService.getExpense(id);
		session.setAttribute("expense", expense);
		session.setAttribute("id", id);

		return mapping.findForward("editExpenses");

	}

	public ActionForward editExpenseStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Expense expense = new Expense();
		HttpSession session = request.getSession();
		AddExpenseForm expenseform = (AddExpenseForm) form;
		expense.setId(expenseform.getId());
		expense.setType(expenseform.getType());
		expense.setDate(expenseform.getDate());
		expense.setPrice(expenseform.getPrice());
		expense.setNoOfItems(expenseform.getNoOfItems());
		expense.setTotal(expenseform.getTotal());
		expense.setBywhom(expenseform.getBywhom());
		// DataSource datasource = getDataSource(request, "Fer_Struts");
		// Connection connection = datasource.getConnection();

		/*
		 * Connection connection = getDataSource(request,
		 * "Fer_Struts").getConnection();
		 */
		boolean editExpense = ferService.editExpense(expense);
		/*
		 * session.setAttribute("editExpense", editExpense); return
		 * mapping.findForward("editExpensestatus");
		 */

		if (editExpense) {
			return mapping.findForward("editExpenseUpdate");
		} else {
			return mapping.findForward("editExpenseFailure");
		}
	}

}
