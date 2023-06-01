package ioevent.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ioevent.starter.annotations.EnableIOEvent;

import ioevent.sample.service.CoffeBreakService;

@SpringBootApplication
@EnableIOEvent
public class IoeventIntermediateTimerSampleApplication {

	@Autowired
	public CoffeBreakService breakService;
	
	public static void main(String[] args) {
		SpringApplication.run(IoeventIntermediateTimerSampleApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		breakService.job1();
	}
}
