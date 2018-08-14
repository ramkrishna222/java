package com.rs.fer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalInfoAction extends DispatchAction {
	FERService ferService = new FERServiceImpl();
	public ActionForward nameInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		FERService ferService = new FERServiceImpl();
		String username = session.getAttribute("username").toString();
		PersonalInfo personalInfo = ferService.getPersonalInfo(username);
		session.setAttribute("personalInfo", personalInfo);
		return mapping.findForward("UpdatePersonalName");
	}

	public ActionForward contactInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		personalInfo.getUser().setFirstName(request.getParameter("firstName"));
		personalInfo.getUser().setMiddleName(request.getParameter("middleName"));
		personalInfo.getUser().setLastName(request.getParameter("lastName"));
		return mapping.findForward("ContactInfo");
	}

	public ActionForward addressInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		personalInfo.getUser().setEmail(request.getParameter("email"));
		personalInfo.getUser().setMobilenumber(request.getParameter("mobilenumber"));
		return mapping.findForward("AddressInfo");
	}

	public ActionForward review(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		personalInfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
		personalInfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
		personalInfo.getAddress().setCity(request.getParameter("city"));
		personalInfo.getAddress().setState(request.getParameter("state"));
		personalInfo.getAddress().setCountry(request.getParameter("country"));
		// personalInfo.getAddress().setZip(request.getParameter("zip").toString());
		String zip = request.getParameter("zip");
		personalInfo.getAddress().setZip(Integer.parseInt(zip));
		return mapping.findForward("ReviewPersonalInfo");
	}

	public ActionForward personalInfoStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		/*Connection connection = getDataSource(request,"Fer_Struts").getConnection();*/
		boolean updateFlag = ferService.updatePersonalInfo(personalInfo.getUser(), personalInfo.getAddress());
		session.setAttribute("status",updateFlag ? "Information Updated Successfully.": "Unable to Update Information");
		return mapping.findForward("UpdatePersonalInfoStatus");

	}
}
