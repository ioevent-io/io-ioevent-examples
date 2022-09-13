package io.ioevent.samples.exclusiveFlow.domain;

import io.ioevent.samples.exclusiveFlow.enums.WayOfTravel;

public class TravelPlan {

	private TravelDestination destination;
	private WayOfTravel wayOfTravel;

	public TravelPlan() {
		super();
	}

	public TravelPlan(TravelDestination destination, WayOfTravel wayOfTravel) {
		super();
		this.destination = destination;
		this.wayOfTravel = wayOfTravel;
	}

	public TravelDestination getDestination() {
		return destination;
	}

	public void setDestination(TravelDestination destination) {
		this.destination = destination;
	}

	public WayOfTravel getWayOfTravel() {
		return wayOfTravel;
	}

	public void setWayOfTravel(WayOfTravel wayOfTravel) {
		this.wayOfTravel = wayOfTravel;
	}

	@Override
	public String toString() {
		return "TravelPlan [destination=" + destination + ", wayOfTravel=" + wayOfTravel + "]";
	}

}
