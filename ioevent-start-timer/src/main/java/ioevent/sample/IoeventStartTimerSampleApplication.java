package ioevent.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ioevent.starter.annotations.EnableIOEvent;

import ioevent.sample.service.PeriodicCleaningService;

@SpringBootApplication
@EnableIOEvent
public class IoeventStartTimerSampleApplication {

	@Autowired
	PeriodicCleaningService cleaningService;
	
	public static void main(String[] args) {
		SpringApplication.run(IoeventStartTimerSampleApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		cleaningService.scan();
	}
}
