package com.deals.DiscountsShowCase.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.deals.DiscountsShowCase.domain.Item;
import com.deals.DiscountsShowCase.domain.Voucher;
import com.ioevent.starter.annotations.EndEvent;
import com.ioevent.starter.annotations.ExceptionEvent;
import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;

@Service
@IOFlow(name="Discount Flow", topic = "deals-topic")
public class DiscountOnItemFlow {
	private static final Logger log = LoggerFactory.getLogger(DiscountOnItemFlow.class);
	
	@IOEvent(key = "Choose item to buy",	
			output = @OutputEvent(key = "Items picked"))
	public Voucher pickItems(Voucher voucher, List<Item> items) {
		for(Item item : items) {
			voucher.addToCart(item);
		}
		return voucher;
	}
	
	@IOEvent(
			key = "Calculate the discount", 
			input = @InputEvent("Items picked"), 
			output = @OutputEvent("Discount set"),
			exception= @ExceptionEvent(exception = {ArithmeticException.class},
									output=@OutputEvent(key = "Discount calculation error")))
	public Voucher calculateDiscount( Voucher voucher) throws Exception {
		double itemsTotal=0;
		for(Item item : voucher.getCart()) {
			itemsTotal+=item.getPrice();
		}
		if(itemsTotal>voucher.getAmount()) {
	         throw new ArithmeticException("Unable to calculate the discount because the items picked cost is above the voucher amount"); 
		}else {
			voucher.setToPay(itemsTotal);
		}
		return voucher;
	}
	
	@IOEvent(key = "Handle discount arithmetic exception",	
			input = @InputEvent(key = "Discount calculation error"),
			output = @OutputEvent(key = "Discount set"))
	public Voucher handleDiscountError(Voucher voucher) {
		log.info("Paying with credit card or cash the deficit");
		voucher.setAmount(voucher.getToPay());
		return voucher;
	}
	
	@IOEvent(key = "Pay for the items",	
			input = @InputEvent(key = "Discount set"),
			output = @OutputEvent(key="Payment done")
	)
	public Voucher pay(Voucher voucher) {
		voucher.setAmount(voucher.getAmount() - voucher.getToPay());
		return voucher;
	}
	
	@IOEvent(key = "Deliver the items",	
			input = @InputEvent(key = "Payment done"),
			output = @OutputEvent(key = "Delivery complete")
			
			)
	public Voucher deliver(Voucher voucher) {
		return voucher;
	}
	
	@IOEvent(key = "Flow terminated",	
			input = @InputEvent(key = "Delivery complete"),
			endEvent = @EndEvent(key = "Discount Flow")
			)
	public Voucher close(Voucher voucher) {
		return voucher;
	}

}

