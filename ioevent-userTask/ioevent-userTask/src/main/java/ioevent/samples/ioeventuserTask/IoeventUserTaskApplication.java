package ioevent.samples.ioeventuserTask;

import com.ioevent.starter.annotations.EnableIOEvent;
import ioevent.samples.ioeventuserTask.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableIOEvent
public class IoeventUserTaskApplication {
	@Autowired
	private Service service;

	public static void main(String[] args) {
		SpringApplication.run(IoeventUserTaskApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() throws InterruptedException {
		service.captureOrder();
	}

}