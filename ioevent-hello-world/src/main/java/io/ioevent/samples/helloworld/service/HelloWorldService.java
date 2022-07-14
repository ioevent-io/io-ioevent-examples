package io.ioevent.samples.helloworld.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;

@Service
@IOFlow(name = "Hello World Flow")
public class HelloWorldService {

	@IOEvent(key = "Hello World !", topic = "hello-world-topic")
	public String sayHelloWorld() {
		return String.format("%s - Hello World !", new Random().nextInt());
	}

}
