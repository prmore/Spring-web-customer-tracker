package com.prashant.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prashant.springdemo.entity.Customer;
import com.prashant.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customerCNT")
public class CustomerController {

	@Autowired
	//Need to inject customer service
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		//Get the customers from customerService
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add customers to model
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//Save the customer using customer service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customerCNT/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("custID") int theID, Model theModel) {
		
		Customer theCustomer = customerService.getCustomer(theID);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("custID") int theID, Model theModel) {
		
		//Delete the customer using service
		customerService.deleteCustomer(theID);
		
		return "redirect:/customerCNT/list";
	}
}
