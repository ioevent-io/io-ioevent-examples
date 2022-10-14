package io.ioevent.samples.exclusiveFlow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ioevent.starter.annotations.EnableIOEvent;

import io.ioevent.samples.exclusiveFlow.service.ExclusiveExempleService;

@EnableIOEvent
@SpringBootApplication
public class IoeventExclusiveExempleApplication {

	@Autowired
	private ExclusiveExempleService exclusiveExempleService;

	public static void main(String[] args) {
		SpringApplication.run(IoeventExclusiveExempleApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {

		exclusiveExempleService.planForTravel();
	}

}
