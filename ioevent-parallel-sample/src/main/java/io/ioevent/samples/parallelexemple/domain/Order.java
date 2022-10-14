package io.ioevent.samples.parallelexemple.domain;

import io.ioevent.samples.parallelexemple.enums.OrderState;

public class Order {
	private String id;
	private String productId;
	private int productquatity;
	private String customerID;
	private OrderState state;
	public Order() {
		super();
	}

	public Order(String id, String productId, int productquatity, String customerID,OrderState state) {
		super();
		this.id = id;
		this.productId = productId;
		this.productquatity = productquatity;
		this.customerID = customerID;
		this.state=state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getProductquatity() {
		return productquatity;
	}

	public void setProductquatity(int productquatity) {
		this.productquatity = productquatity;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId + ", productquatity=" + productquatity + ", customerID="
				+ customerID + ", state=" + state + "]";
	}

}
