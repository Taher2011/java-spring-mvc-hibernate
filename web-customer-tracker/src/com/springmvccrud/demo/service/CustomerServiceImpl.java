package com.springmvccrud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvccrud.demo.dao.CustomerDAO;
import com.springmvccrud.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> listOfCustomer = customerDAO.getCustomers();
		return listOfCustomer;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String name) {
		return customerDAO.searchCustomer(name);
	}

}
