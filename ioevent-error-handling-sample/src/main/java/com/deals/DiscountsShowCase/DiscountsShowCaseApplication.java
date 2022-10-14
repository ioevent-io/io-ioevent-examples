package com.deals.DiscountsShowCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ioevent.starter.annotations.EnableIOEvent;

@EnableIOEvent
@SpringBootApplication
public class DiscountsShowCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountsShowCaseApplication.class, args);
	}

}
