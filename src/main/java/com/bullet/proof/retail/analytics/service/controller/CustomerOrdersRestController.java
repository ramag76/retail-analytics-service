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

import com.bullet.proof.retail.analytics.service.db.model.Order;
import com.bullet.proof.retail.analytics.service.db.model.OrderRepository;

/**
 * @author Ram
 *
 */



@RestController()
@RequestMapping("/customers/{customerId}/orders")
public class CustomerOrdersRestController {


@Autowired
private OrderRepository orderRepository;
	
	
	/**
	 * Returns the existing orders for a given customer
	 * 
	 * @param customerId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Order> getOrders(@PathVariable String customerId,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
		return orderRepository.findAll();
	}

	/**
	 * Creates a new order for a given customer
	 * 
	 * @param customerId
	 * @param order
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Order createOrder(@PathVariable String customerId, @RequestBody Order order) {
		
		return orderRepository.insert(order);
	}

	/**
	 * Delete a order for a given customer
	 * 
	 * @param customerId
	 * @param orderId
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "{orderId}")
	public void deleteOrder(@PathVariable String customerId, @PathVariable String orderId) {
		orderRepository.delete(orderId);
	}

	/**
	 * Updates a existing order for a given customer.
	 * 
	 * @param customerId
	 * @param order
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Order updateOrder(@PathVariable String customerId, @RequestBody Order order) {
		return orderRepository.save(order);
	}
}
