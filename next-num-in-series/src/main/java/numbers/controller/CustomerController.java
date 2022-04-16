package numbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import numbers.entity.Customer;
import numbers.service.CustomerService;

@Controller
@RequestMapping(value="/customer",method=RequestMethod.GET)
public class CustomerController {
	
	//need to inject DAO into this controller
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get customer from DAO
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add customers to Model
		theModel.addAttribute("customersList", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForadd")
	public String showFormForadd(Model theModel) {
		
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer", theCustomer);
			
		return "customer-form";
	}
	
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customerDetails") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
		
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from the service
		Customer theCustomer= customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	
	@GetMapping("/deleteCustomers")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//get the customer from the service
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
