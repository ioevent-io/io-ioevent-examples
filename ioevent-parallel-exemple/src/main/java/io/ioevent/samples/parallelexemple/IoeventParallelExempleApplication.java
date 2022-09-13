package io.ioevent.samples.parallelexemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ioevent.starter.annotations.EnableIOEvent;

import io.ioevent.samples.parallelexemple.service.ParallelExempleService;

@EnableIOEvent
@SpringBootApplication
public class IoeventParallelExempleApplication {

	@Autowired
	private ParallelExempleService parallelExempleService;

	public static void main(String[] args) {
		SpringApplication.run(IoeventParallelExempleApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {

		parallelExempleService.createOrder();
	}
}
