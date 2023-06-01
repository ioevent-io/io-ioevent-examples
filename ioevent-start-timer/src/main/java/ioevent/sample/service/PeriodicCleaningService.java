package ioevent.sample.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.IOTimer;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;
import com.ioevent.starter.annotations.StartEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@IOFlow(name="Periodic cleaning", topic="scheduled-cleaning-topic")
@Slf4j
public class PeriodicCleaningService {

	@IOEvent(
			key="Start cleaning every 5 min",
			startEvent = @StartEvent(
					key="Periodic cleaning",
					timer=@IOTimer(cron="* */5 * * * *")
					),
			output = @OutputEvent(key = "order to clean"))
	public String scan() {
		log.info("[Scanning & Cleaning] ... {}", new Date());
		return "[Scanning & Cleaning]";
	}
	
	
	@IOEvent(key="Perform Cleaning", input=@InputEvent(key="order to clean"))
	public String clean() {
		return "[Scanning & Cleaning]";
	}
	
}
