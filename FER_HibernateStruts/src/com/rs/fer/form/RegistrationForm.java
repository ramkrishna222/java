package com.rs.fer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrationForm extends ActionForm {

	private static final long seriolVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String middleName;
	private String userName;
	private String password;
	private String email;
	private String mobileNumber;
	private int id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSeriolversionuid() {
		return seriolVersionUID;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (firstName == null || firstName.length() < 1) {
			errors.add("firstName", new ActionMessage("error.firstName.required"));
		}
		if (middleName == null || middleName.length() < 1) {
			errors.add("middleName", new ActionMessage("error.middleName.required"));
		}
		if (lastName == null || lastName.length() < 1) {
			errors.add("lastName", new ActionMessage("error.lastName.required"));
		}
		if (userName == null || userName.length() < 1) {
			errors.add("userName", new ActionMessage("error.userName.required"));
		}
		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));
		}
		if (email == null || email.length() < 1) {
			errors.add("email", new ActionMessage("error.email.required"));
		}
		if (mobileNumber == null || mobileNumber.length() < 1) {
			errors.add("mobileNumber", new ActionMessage("error.mobileNumber.required"));
		}
		return errors;
	}
}
