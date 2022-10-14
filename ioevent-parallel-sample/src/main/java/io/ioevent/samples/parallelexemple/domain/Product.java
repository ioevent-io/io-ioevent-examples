package io.ioevent.samples.parallelexemple.domain;

public class Product {
	private String id;

	private int stock;
	private long price;

	public Product() {
		super();
	}

	public Product(String id, int stock, long price) {
		super();
		this.id = id;
		this.stock = stock;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", stock=" + stock + ", price=" + price + "]";
	}

}
