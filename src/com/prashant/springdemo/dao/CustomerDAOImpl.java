package com.prashant.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prashant.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		//Get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//Get customers
		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Save the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theID) {
		
		//Get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Get customer
		Customer theCustomer = currentSession.get(Customer.class, theID);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theID) {
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Get customer
		Customer tempCustomer = currentSession.get(Customer.class, theID);
		
		//Delete the customer
		currentSession.delete(tempCustomer);
		
	}

	
}
