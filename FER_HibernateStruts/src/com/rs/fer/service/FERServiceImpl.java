package com.rs.fer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.DBUtil.HibernateUtil;
import com.rs.fer.bean.Address;
//import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
//import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public class FERServiceImpl implements FERService {

	public boolean isValidUser(String username, String password) {
		Session session = null;
		boolean isValidUser = false;
		// Connection connection = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(User.class);
			Criterion crit = Restrictions.eq("userName", username);
			Criterion cn = Restrictions.eq("password", password);

			criteria.add(crit);
			criteria.add(cn);

			List l = criteria.list();
			if (l != null) {
				return l.get(0) != null;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

		return isValidUser;
	}

	public boolean registration(User user) {

		boolean isRegister = false;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			isRegister = true;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

		return isRegister;
	}

	@Override
	public boolean addExpense(Expense expense) {
		boolean isAddexpense = false;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(expense);
			tx.commit();
			isAddexpense = true;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

		return isAddexpense;
	}

	@Override
	public boolean resetPassword(String username, String currentPassword, String newPassword) {
		Session session = null;
		boolean resetPassword = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("update User u set u.password='" + newPassword + "' where u.userName='"
					+ username + "'and u.password='" + currentPassword + "'");
			q.executeUpdate();
			tx.commit();
			resetPassword = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resetPassword;

	}

	@Override
	public boolean deleteValue(int id) {
		Session session = null;
		boolean deleteExpense = false;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			Expense expense = (Expense) session.get(Expense.class, id);
			Transaction tx = session.beginTransaction();
			session.delete(expense);
			tx.commit();

			deleteExpense = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return deleteExpense;
	}

	@Override
	public List<Expense> getExpenses() {
		Session session = null;
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(" from Expense p");
			List<Expense> list = query.list();
			Iterator<Expense> iterator = list.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
				expenses.add(expense);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expenses;
	}

	@Override
	public Expense getExpense(int id) {
		Expense expense = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from Expense p where p.id='" + id + "'");

			List<Expense> list = query.list();
			Iterator<Expense> iterator = list.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expense;
	}


	@Override
	public List<Expense> getExpenseReport(String type, String fromDate, String toDate) {
		// TODO Auto-generated method stub

		Expense expense = null;
		Session session = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from Expense p where p.type='" + type.trim() + "' and  p.date between '"
					+ fromDate + "' and '" + toDate + "'");
			List<Expense> list = query.list();
			Iterator<Expense> iterator = list.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
				expenses.add(expense);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return expenses;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Session session = null;
		boolean editExpense = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(expense);
			tx.commit();
			editExpense = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return editExpense;

	}

	@Override
	public PersonalInfo getPersonalInfo(String username) {
		Session session = null;
		PersonalInfo personalinfo = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query qry = session.createQuery("select p from User p where p.userName='" + username + "'");
			List l = qry.list();
			Iterator i = l.iterator();
			while (i.hasNext()) {
				User user = (User) i.next();
				personalinfo = new PersonalInfo();
				personalinfo.setUser(user);
				// personalinfo.setAddress(user.getAddress());
				personalinfo.setAddress((user.getAddress() == null) ? new Address() : user.getAddress());
				break;
			}

		} finally {
			session.close();
		}
		return personalinfo;
	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		Session session = null;
		boolean isUpdatedFlag = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			user.setAddress(address);
			session.update(user);
			session.update(address);
			tr.commit();

			isUpdatedFlag = true;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return isUpdatedFlag;
	}

}