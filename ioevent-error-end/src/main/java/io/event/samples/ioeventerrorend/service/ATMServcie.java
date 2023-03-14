package io.event.samples.ioeventerrorend.service;

import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.EndEvent;
import com.ioevent.starter.annotations.ExceptionEvent;
import com.ioevent.starter.annotations.GatewayOutputEvent;
import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;

import io.event.samples.ioeventerrorend.exception.InsuffisiantPapers;

@Service
@IOFlow(name = "ATM Withdraw", topic = "bank-withdraw" )
public class ATMServcie {
	
	@IOEvent(key = "Withdraw money",	
			output = @OutputEvent(key="Process operation"))
	public int withdraw(int s) {
		return s;
	}
	
	@IOEvent(key = "Process operation",input = @InputEvent(key = "Process operation"), 
			gatewayOutput = @GatewayOutputEvent(parallel = true, output = { 
					@OutputEvent(key = "order to ticket"), 
					@OutputEvent(key = "order to money")
			}))
	public int process(int order) {
		return order; 
	}
	@IOEvent(key = "Get the money",	
			input = @InputEvent(key="order to money"),
			output=@OutputEvent(key="operation ended"))
	public int money(int s) {
		return s;
	}
	@IOEvent(key = "Get the ticket",	
			input=@InputEvent(key="order to ticket"),
			output=@OutputEvent(key="operation ended"),
			exception= @ExceptionEvent(
	                exception = {InsuffisiantPapers.class},
	                endEvent=@EndEvent("No paper for ticket")))
	public int ticket(int s) {
		if(s>10) {
			throw new InsuffisiantPapers("Inusuffisiant papers to print new ticket");
		}
		return s;
	}
	
	@IOEvent(key = "Flow terminated",	
			input = @InputEvent(key = "operation ended"),
			endEvent = @EndEvent(key = "ATM Withdraw"))
	public String close(String voucher) {
		return voucher;
	}
}
