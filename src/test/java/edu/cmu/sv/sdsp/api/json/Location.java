package edu.cmu.sv.sdsp.api.json;

import java.util.Random;

public class Location {
	private String representation;
	private double latitude;
	private double longitude;
	private double altitude;
	
	public Location(String representation, double latitude, double longitude,
			double altitude) {
		this.representation = representation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	public Location(String representation) {
		this.representation = representation;
		this.latitude = new Random().nextDouble();
		this.longitude = new Random().nextDouble();
		this.altitude = new Random().nextDouble();
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
}
