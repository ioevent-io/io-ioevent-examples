package io.ioevent.samples.exclusiveFlow.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.GatewayOutputEvent;
import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.IOResponse;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;

import io.ioevent.samples.exclusiveFlow.domain.TravelDestination;
import io.ioevent.samples.exclusiveFlow.domain.TravelPlan;
import io.ioevent.samples.exclusiveFlow.enums.WayOfTravel;

@IOFlow(name = "Exclusive Exemple Flow")
@Service
public class ExclusiveExempleService {

	private static final Logger log = LoggerFactory.getLogger(ExclusiveExempleService.class);

	protected static final List<TravelDestination> destinationsList = Arrays.asList(
			new TravelDestination("Dubai", 4500), new TravelDestination("Paris", 270),
			new TravelDestination("Berlin", 350), new TravelDestination("Rome", 600),
			new TravelDestination("Barcelona", 170));

	@IOEvent(key = "choose travel destination", topic = "travel-exemple-topic", output = @OutputEvent(key = "destination picked"))
	public TravelDestination planForTravel() {

		return destinationsList.get(new Random().nextInt(4));
	}

	@IOEvent(key = "check destination distance", topic = "travel-exemple-topic", input = @InputEvent(key = "destination picked"), gatewayOutput = @GatewayOutputEvent(exclusive = true, output = {
			@OutputEvent(key = "less than 300km"), @OutputEvent(key = "more than 300km") }))
	public IOResponse<TravelPlan> checkDistance(TravelDestination destination) {
		if (destination.getDistance() < 300) {
			log.info("destination distance is less than 300km");

			return new IOResponse<>("less than 300km", new TravelPlan(destination, null));
		}
		log.info("destination distance is more than 300km");

		return new IOResponse<>("more than 300km", new TravelPlan(destination, null));
	}

	@IOEvent(key = "travel by car", topic = "travel-exemple-topic", input = @InputEvent(key = "less than 300km"))
	public TravelPlan travelByCar(TravelPlan plan) {
		plan.setWayOfTravel(WayOfTravel.car);
		log.info("traveling by car");
		return plan;
	}

	@IOEvent(key = "travel by plane", topic = "travel-exemple-topic", input = @InputEvent(key = "more than 300km"))
	public TravelPlan travelByPlane(TravelPlan plan) {
		plan.setWayOfTravel(WayOfTravel.plane);
		log.info("traveling by plane");
		return plan;
	}

}
