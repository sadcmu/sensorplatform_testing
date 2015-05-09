package edu.cmu.sv.sdsp.api.json;

public class SensorCategory {
	private String sensorCategoryName;
	private String purpose;
	
	public SensorCategory(String sensorCategoryName) {
		this.sensorCategoryName = sensorCategoryName;
	}
	
	public SensorCategory(String sensorCategoryName, String purpose) {
		this.sensorCategoryName = sensorCategoryName;
		this.purpose = purpose;
	}

	public String getSensorCategoryName() {
		return sensorCategoryName;
	}

	public void setSensorCategoryName(String sensorCategoryName) {
		this.sensorCategoryName = sensorCategoryName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
