package ioevent.sample.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.IOTimer;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@IOFlow(name = "Coffee Break Demo", topic = "coffe-break-demo-topic")
@Slf4j
public class CoffeBreakService {
	
	@IOEvent(key="Do Task 1", output = @OutputEvent(key = "take a break"))
	public void job1() {
		log.info("[JOB1]: PROCESSING at {}", new Date());
	}
	
	@IOEvent(key="Coffe Break", 
			input=@InputEvent(key="take a break"), 
			output=@OutputEvent(key="back to work"), 
			timer=@IOTimer(delay=5, timeUnit = TimeUnit.MINUTES))
	public void takeBreak() {
		log.info("[Coffee Break]: PROCESSING at {}", new Date());
	}
	
	@IOEvent(key="Do Task 2", input=@InputEvent("back to work"))
	public void job2() {
		log.info("[JOB2]: PROCESSING at {}", new Date());
	}
}
	
