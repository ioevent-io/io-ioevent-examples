package io.ioevent.samples.exclusiveFlow.domain;

public class TravelDestination {
	private String destinationName;
	private int distance;

	public TravelDestination() {
		super();
	}

	public TravelDestination(String destinationName, int distance) {
		super();
		this.destinationName = destinationName;
		this.distance = distance;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "TravelDestination [destinationName=" + destinationName + ", distance=" + distance + "]";
	}

}
