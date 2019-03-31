package com.springmvccrud.demo.service;

import java.util.List;

import com.springmvccrud.demo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);

	public List<Customer> searchCustomer(String name);
}
