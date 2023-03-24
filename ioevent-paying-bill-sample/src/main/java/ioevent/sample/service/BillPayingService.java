package ioevent.sample.service;

import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.EndEvent;
import com.ioevent.starter.annotations.ExceptionEvent;
import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;

import ioevent.sample.exception.CreditCardTransactionFailure;

@Service
@IOFlow(name="Bill Payment", topic="bill-paying-topic")
public class BillPayingService {
	
	@IOEvent(key="Pay with credit card",
			output=@OutputEvent(key="transaction completed"),
			exception = @ExceptionEvent(
					exception= {CreditCardTransactionFailure.class},
					output= @OutputEvent(key="transaction failed")
					)

			)
	public double payWithCreditCard(double amount) {
		// Bill payment with credit card
		if(amount<10) {
			throw new CreditCardTransactionFailure("Unable to complete the transaction for this amount");
		}
		return amount;
	}
	
	@IOEvent(key="Print receipt", 
			input=@InputEvent(key ="transaction completed"), 
			output = @OutputEvent(key = "receipt printed"))
	public void printReciept(double amount) {
		//Print the reciept
	}
	
	@IOEvent(key="Pay with cash", input = @InputEvent(key="transaction failed"), output = @OutputEvent(key="transaction completed"))
	public double payWithCash(double amount) {
		//Pay with cash
		return amount;
	}

	@IOEvent(key="END", 
			input=@InputEvent(key = "receipt printed"), 
			endEvent= @EndEvent("Bill Payment"))
	public void close() {
		//Closing the bill payment workflow
	}
}
