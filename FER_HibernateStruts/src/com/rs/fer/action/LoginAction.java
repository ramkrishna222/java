package com.rs.fer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.form.LoginForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		LoginForm loginForm = (LoginForm) form;
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		/*
		 * DataSource datasource = getDataSource(request, "Fer_Struts");
		 * Connection connection = datasource.getConnection();
		 */

		boolean loginFlag = ferService.isValidUser(username, password);
		if (loginFlag) {
			return mapping.findForward("success");

		} else {
			return mapping.findForward("failure");
		}

	}
}
