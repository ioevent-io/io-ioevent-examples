package io.ioevent.samples.parallelexemple.domain;

public class Customer {

	private String customerId;
	private Long budget;

	public Customer() {
		super();
	}

	public Customer(String customerId, Long budget) {
		super();
		this.customerId = customerId;
		this.budget = budget;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", budget=" + budget + "]";
	}

}
