package com.bullet.proof.retail.analytics.service.db.model;

import org.springframework.data.annotation.Id;

public class LineItem {

	@Id()
	private String id;

	private String itemDescription;

	private Integer quantity;

	private double totalValue;

	public LineItem() {
		super();
	}

	public LineItem(String itemDescription, Integer quantity, double totalValue) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.totalValue = totalValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}
