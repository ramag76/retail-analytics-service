/**
 * 
 */
package com.bullet.proof.retail.analytics.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bullet.proof.retail.analytics.service.db.model.Customer;
import com.bullet.proof.retail.analytics.service.db.model.CustomerRepository;
import com.bullet.proof.retail.analytics.service.db.model.LineItem;
import com.bullet.proof.retail.analytics.service.db.model.LineItemRespository;
import com.bullet.proof.retail.analytics.service.db.model.Order;
import com.bullet.proof.retail.analytics.service.db.model.OrderRepository;

/**
 * @author Ram
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private LineItemRespository lineItemRespository;

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {

		repository.deleteAll();
		CSVFileReader csvReader = new CSVFileReader();
		File file = new File(getClass().getClassLoader().getResource("CustomerDataCSV.csv").getFile());
		List<Customer> customerLists= csvReader.readCsvFile(file.toString());
		//ArrayList<List> custlists = (ArrayList<List>) 
		//csvReader.getCustomerList("file");
		//System.out.println(custlists.toString());
		//System.out.println("Number of customers from the CSV file" + custlists.size());
		// save a couple of customers
		
		for (Customer cust : customerLists) {
			
			//System.out.println(cust.toString());
			
			List<LineItem> lineItems = new ArrayList<LineItem>();
			LineItem custLineItem1 = new LineItem("Line-Item-1", (new Random().nextInt(100)+1), (new Random().nextDouble()));
			lineItemRespository.save(custLineItem1);
			lineItems.add(custLineItem1);

			Order aliceOrder1 = new Order(100.00, lineItems);
			orderRepository.save(aliceOrder1);
			
			cust.addOrder(aliceOrder1);
			
			repository.save(cust);
			
		}

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Ram'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Ram"));

		System.out.println("Customers found with findByLastName('Chandran'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Chandran")) {
			System.out.println(customer);
		}

	}

}
