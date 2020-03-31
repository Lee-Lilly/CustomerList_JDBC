package com.example.CustomerList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CustomerList.domain.Customer;
import com.example.CustomerList.domain.CustomerRepository;

@Controller
public class CustomerContoller {

	@Autowired
	private CustomerRepository customerRepos; 
		
	// Show all customers
		@GetMapping(value= {"/", "/customerList"})
	    public String customerList(Model model) {	
	        model.addAttribute("customers", customerRepos.findAll());
	        return "customerList";
	    }
		
	// Add new customer
		@GetMapping(value = "/add")
	    public String addCustomer(Model model){
	    	model.addAttribute("customer", new Customer());
	        return "addCustomer";
	    }     
	
	//Save new customer 
	    @PostMapping(value = "/save")
	    public String saveCustomer(Customer customer) {	
	        customerRepos.save(customer);
	        return  "redirect:customerList";
	    }
	    
	//Search a customer by name
	    @RequestMapping(value ="/search")
	    public String findCustomer(@RequestParam(value="inputName") String name,  Model model) {
	    	model.addAttribute("customers", customerRepos.findByName(name));
	    	return "customerList";
	    }

}
