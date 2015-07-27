/**
 * 
 */
package com.bullet.proof.retail.analytics.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bullet.proof.retail.analytics.service.db.model.Customer;
import com.bullet.proof.retail.analytics.service.db.model.CustomerRepository;

/**
 * @author Ram
 *
 */
@RestController()
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.insert(customer);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getCustomers(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
		return customerRepository.findAll();
	}

	@RequestMapping(value = "{customerId}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable String customerId) {
		customerRepository.delete(customerId);
		return;
	}

}
