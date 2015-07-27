/**
 * 
 */
package com.bullet.proof.retail.analytics.service.db.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * @author Ram
 *
 */
public class Customer {
	@Id
	private String id;

	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	@DBRef()
	private List<Order> orders;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, Date dob, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		return String.format("Customer[id=%s, firstName='%s', lastName='%s', dob='%s', gender='%s']", id, firstName,
				lastName, (dob != null) ? dateFormatter.format(dob) : null, gender);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Order> getOrders() {
		if(orders == null)
		{
			orders = new ArrayList<Order>();
		}
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order aOrder) {
		getOrders().add(aOrder);
	}
}
