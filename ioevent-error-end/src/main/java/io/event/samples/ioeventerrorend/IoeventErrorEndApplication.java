package io.event.samples.ioeventerrorend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ioevent.starter.annotations.EnableIOEvent;

@EnableIOEvent
@SpringBootApplication
public class IoeventErrorEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoeventErrorEndApplication.class, args);
	}

}
