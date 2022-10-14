package com.deals.DiscountsShowCase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deals.DiscountsShowCase.domain.Item;
import com.deals.DiscountsShowCase.domain.Voucher;
import com.deals.DiscountsShowCase.service.DiscountOnItemFlow;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DiscountsController {
	
	@Autowired
	DiscountOnItemFlow workflow1;

	@GetMapping("/start")
	public String start() {
		Voucher v = new Voucher("V11MRMal-1M",700);
		Item item1 = new Item("Denim",250);
		Item item2 = new Item("Burger",25);
		Item item3 = new Item("Casual shoes",100);
		Item item4 = new Item("Smart Watch",200);
		Item item5 = new Item("Tablette",500);
		List<Item> items = new ArrayList<>();
		items.add(item1);items.add(item2);items.add(item3);items.add(item4);items.add(item5);
		workflow1.pickItems(v,items);
		return "done";
	}

}
