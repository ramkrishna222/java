package com.rs.fer.service;

import java.sql.Connection;
import java.util.List;

import com.rs.fer.bean.Address;
//import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
//import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {

	boolean isValidUser(String username, String password);

	boolean registration(User user);

	boolean addExpense(Expense expense);

	boolean resetPassword(String username, String currentPassword, String newPassword);

	List<Expense> getExpenses();

	Expense getExpense(int id);

	boolean deleteValue(int id);

	List<Expense> getExpenseReport(String type, String fromDate, String toDate);

	boolean editExpense(Expense expense);
	
	PersonalInfo getPersonalInfo(String username);
    
    boolean updatePersonalInfo(User user, Address address);

	// boolean Login(String username, String password);

}
