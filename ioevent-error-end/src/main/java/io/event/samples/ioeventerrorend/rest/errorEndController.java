package io.event.samples.ioeventerrorend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.event.samples.ioeventerrorend.service.ErrorEndCase;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class errorEndController {
	
	@Autowired
	ErrorEndCase errorEndCase;
	

	@GetMapping("/start")
	public String start() throws InterruptedException {
		errorEndCase.withdraw(3);
		return "done";
	}

}
