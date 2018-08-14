package com.rs.fer.form;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddExpenseForm extends ActionForm {
	private int Id;
	private String type;
	private String date;
	private String price;
	private String noOfItems;
	private String total;
	private String bywhom;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(String noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getBywhom() {
		return bywhom;
	}

	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, ServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors Errors = new ActionErrors();

		if (noOfItems.matches("^[234]")) {
			Errors.add("noOfItems", new ActionMessage("md"));
		}
		return Errors;
	}

}
