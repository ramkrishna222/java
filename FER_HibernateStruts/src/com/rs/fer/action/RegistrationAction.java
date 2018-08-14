package com.rs.fer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.User;
import com.rs.fer.form.RegistrationForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationAction extends Action {
	// private final static String REGISTRATIONFAIL = "registrationfail";
	// private final static String REGISTRATIONSUCCESS = "registrationsuccess";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FERService ferService = new FERServiceImpl();
		RegistrationForm registration = (RegistrationForm) form;
		User user = new User();
		user.setFirstName(registration.getFirstName());
		user.setLastName(registration.getLastName());
		user.setMiddleName(registration.getMiddleName());
		user.setUserName(registration.getUserName());
		user.setPassword(registration.getPassword());
		user.setMobilenumber(registration.getMobileNumber());
		user.setEmail(registration.getEmail());
		/*
		 * Connection connection =
		 * getDataSource(request,"Fer_Struts").getConnection();
		 */
		boolean registrationFlag = ferService.registration(user);
		if (registrationFlag) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");

		}
	}

}
