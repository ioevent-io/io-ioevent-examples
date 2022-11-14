package com.deals.DiscountsShowCase.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor
public class Voucher {
	private String id;
	private double amount;
	private List<Item> cart = new ArrayList<>();
	private double toPay = 0;
	
	public Voucher(String id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	public int addToCart(Item item) {
		try {
			cart.add(item);
			return 0;
		}catch(Exception e) {
			return 1;
		}

	}
}
