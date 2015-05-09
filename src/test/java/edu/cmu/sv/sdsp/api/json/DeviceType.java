package edu.cmu.sv.sdsp.api.json;

import java.util.List;

public class DeviceType {
	private String deviceTypeName;
	private String manufacturer;
	private String version;
	private String deviceTypeUserDefinedFields;
	private List<String> sensorTypeNames;
	
	public DeviceType(String deviceTypeName, List<String> sensorTypeNames) {
		this.deviceTypeName = deviceTypeName;
		this.sensorTypeNames = sensorTypeNames;
		
		// Initialize other fields with random values
		this.manufacturer = "JUnit-Test-Mfr";
		this.version = "JUnit-Test-4.0";
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDeviceTypeUserDefinedFields() {
		return deviceTypeUserDefinedFields;
	}

	public void setDeviceTypeUserDefinedFields(String deviceTypeUserDefinedFields) {
		this.deviceTypeUserDefinedFields = deviceTypeUserDefinedFields;
	}

	public List<String> getSensorTypeNames() {
		return sensorTypeNames;
	}

	public void setSensorTypeNames(List<String> sensorTypeNames) {
		this.sensorTypeNames = sensorTypeNames;
	}
	
}
