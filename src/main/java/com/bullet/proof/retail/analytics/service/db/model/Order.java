/**
 * 
 */
package com.bullet.proof.retail.analytics.service.db.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * @author Ram
 *
 */
public class Order {

	@Id
	private String orderId;

	private double orderValue;

	@DBRef
	private List<LineItem> lineItems;

	public Order() {
		super();
	}

	public Order(double orderValue, List<LineItem> lineItems) {
		super();
		this.orderValue = orderValue;
		this.lineItems = lineItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public List<LineItem> getLineItems() {
		if (lineItems == null) {
			lineItems = new ArrayList<LineItem>();
		}
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public void addLineItem(LineItem aLineItem) {
		getLineItems().add(aLineItem);
	}

}
