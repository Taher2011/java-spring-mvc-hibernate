package com.springmvccrud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvccrud.demo.entity.Customer;
import com.springmvccrud.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> listOfCustomers = customerService.getCustomers();
		model.addAttribute("customers", listOfCustomers);
		return "list-customers";
	}

	@GetMapping("/search")
	public String searchCustomer(@RequestParam("searchName") String name, Model model) {
		List<Customer> listOfCustomerByName = customerService.searchCustomer(name);
		model.addAttribute("customers", listOfCustomerByName);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customerAdd", customer);
		return "customer-add-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customerAdd") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerUpdate", customer);
		return "customer-update-form";
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customerUpdate") Customer customer) {
		customerService.updateCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(customer);
		return "redirect:/customer/list";
	}
}
