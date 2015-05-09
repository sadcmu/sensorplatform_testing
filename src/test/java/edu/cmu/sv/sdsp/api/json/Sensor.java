package edu.cmu.sv.sdsp.api.json;

public class Sensor {
	private String sensorName;
	private String sensorTypeName;
	private String deviceUri;
	private String sensorUserDefinedFields;
	
	public Sensor(String sensorName, String sensorTypeName, String deviceUri) {
		this.sensorName = sensorName;
		this.sensorTypeName = sensorTypeName;
		this.deviceUri = deviceUri;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getSensorTypeName() {
		return sensorTypeName;
	}

	public void setSensorTypeName(String sensorTypeName) {
		this.sensorTypeName = sensorTypeName;
	}

	public String getDeviceUri() {
		return deviceUri;
	}

	public void setDeviceUri(String deviceUri) {
		this.deviceUri = deviceUri;
	}

	public String getSensorUserDefinedFields() {
		return sensorUserDefinedFields;
	}

	public void setSensorUserDefinedFields(String sensorUserDefinedFields) {
		this.sensorUserDefinedFields = sensorUserDefinedFields;
	}
	
	
}
