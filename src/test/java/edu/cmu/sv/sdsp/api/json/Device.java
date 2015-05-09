package edu.cmu.sv.sdsp.api.json;

public class Device {
	private String deviceTypeName;
	private String uri;
	private Location location;
	private String deviceUserDefinedFields;
	
	public Device(String deviceTypeName, String uri, Location location) {
		this.deviceTypeName = deviceTypeName;
		this.uri = uri;
		this.location = location;
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getDeviceUserDefinedFields() {
		return deviceUserDefinedFields;
	}

	public void setDeviceUserDefinedFields(String deviceUserDefinedFields) {
		this.deviceUserDefinedFields = deviceUserDefinedFields;
	}

}
