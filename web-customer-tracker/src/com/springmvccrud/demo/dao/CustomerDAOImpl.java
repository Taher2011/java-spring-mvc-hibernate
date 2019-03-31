package com.springmvccrud.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvccrud.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> listOfCustomers = query.getResultList();
		return listOfCustomers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Customer.class);
		crit.add(Restrictions.like("firstName", name, MatchMode.ANYWHERE));
		List<Customer> listOfCustomers = crit.list();
		return listOfCustomers;
	}

}
