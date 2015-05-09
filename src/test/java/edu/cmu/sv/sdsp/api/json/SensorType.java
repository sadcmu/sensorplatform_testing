package edu.cmu.sv.sdsp.api.json;

public class SensorType {
	private String sensorTypeName;
	private String manufacturer;
	private String version;
	private String unit;
	private String interpreter;
	private String sensorTypeUserDefinedFields;
	private String sensorCategoryName;
	private double maximumValue;
	private double minimumValue;
	
	public SensorType(String sensorTypeName, String sensorCategoryName) {
		this.sensorTypeName = sensorTypeName;
		this.sensorCategoryName = sensorCategoryName;
		
		// Initialize other fields with random values
		this.manufacturer = "JUnit-Test-Mfr";
		this.version = "JUnit-Test-4.0";
		this.unit = "JUnit-Test-Unit";
		this.interpreter = "JUnit-Test-Interpreter";
		this.maximumValue = 100.00;
		this.minimumValue = 10.00;
	}

	public String getSensorTypeName() {
		return sensorTypeName;
	}

	public void setSensorTypeName(String sensorTypeName) {
		this.sensorTypeName = sensorTypeName;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}

	public String getSensorTypeUserDefinedFields() {
		return sensorTypeUserDefinedFields;
	}

	public void setSensorTypeUserDefinedFields(String sensorTypeUserDefinedFields) {
		this.sensorTypeUserDefinedFields = sensorTypeUserDefinedFields;
	}

	public String getSensorCategoryName() {
		return sensorCategoryName;
	}

	public void setSensorCategoryName(String sensorCategoryName) {
		this.sensorCategoryName = sensorCategoryName;
	}

	public double getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(double maximumValue) {
		this.maximumValue = maximumValue;
	}

	public double getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(double minimumValue) {
		this.minimumValue = minimumValue;
	}
	
	
}
