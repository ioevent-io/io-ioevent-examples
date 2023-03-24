package ioevent.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ioevent.starter.annotations.EnableIOEvent;

import ioevent.sample.service.BillPayingService;

@SpringBootApplication
@EnableIOEvent
public class IoeventPayingBillSampleApplication {

	@Autowired
	public BillPayingService billPayingService;
	
	public static void main(String[] args) {
		SpringApplication.run(IoeventPayingBillSampleApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		billPayingService.payWithCreditCard(3);
	}

}
