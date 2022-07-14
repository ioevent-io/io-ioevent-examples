package io.ioevent.samples.helloworld;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ioevent.starter.annotations.EnableIOEvent;

import io.ioevent.samples.helloworld.service.HelloWorldService;

@SpringBootApplication
@EnableIOEvent
public class Application {

	@Autowired
	private HelloWorldService helloWorldService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		Executors.newSingleThreadScheduledExecutor()//
				.scheduleWithFixedDelay(() -> {
					helloWorldService.sayHelloWorld();
				}, 500,2000, TimeUnit.MILLISECONDS);

	}

}
