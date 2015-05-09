package edu.cmu.sv.sdsp.api.helper;

public class APIUrls {
	/**
	 * This is the host this project tests on.
	 */
	//public static final String HOST_NAME = "http://einstein.sv.cmu.edu:9000";
	public static final String HOST_NAME = "http://127.0.0.1:8080";
	/**
	 * URL used for GET operation on API to get all "Devices"
	 */
	public static final String GET_ALL_DEVICES = HOST_NAME + "/getAllDevices";

	/**
	 * URL used for GET operation on API to get all "Device Types"
	 */
	public static final String GET_ALL_DEVICE_TYPES = HOST_NAME
			+ "/getAllDeviceTypes";

	/**
	 * URL used for GET operation on API to get all "Sensor Types"
	 */
	public static final String GET_ALL_SENSOR_TYPES = HOST_NAME
			+ "/getAllSensorTypes";

	/**
	 * URL used for GET operation on API to get all "Sensors"
	 */
	public static final String GET_ALL_SENSORS = HOST_NAME + "/getAllSensors";

	/**
	 * URL used for GET operation on API to get all "Sensor Categories"
	 */
	public static final String GET_ALL_SENSOR_CATEGORIES = HOST_NAME
			+ "/getAllSensorCategories";

	/**
	 * URL to add a "Sensor Category" using POST
	 */
	public static final String ADD_SENSOR_CATEGORY = HOST_NAME
			+ "/addSensorCategory";

	/**
	 * URI to delete a "Sensor Category" using DELETE
	 */
	public static final String DELETE_SENSOR_CATEGORY = HOST_NAME
			+ "/deleteSensorCategory";
	
	/**
	 * URI to add a "Sensor Type" using POST
	 */
	public static final String ADD_SENSOR_TYPE = HOST_NAME + "/addSensorType";
	
	/**
	 * URI to delete a "Sensor Type" using DELETE
	 */
	public static final String DELETE_SENSOR_TYPE = HOST_NAME + "/deleteSensorType";
	
	/**
	 * URI to add a "Sensor" using POST
	 */
	public static final String ADD_SENSOR = HOST_NAME + "/addSensor";
	
	/**
	 * URI to delete a "Sensor" using DELETE
	 */
	public static final String DELETE_SENSOR = HOST_NAME + "/deleteSensor";
	
	/**
	 * URI to add a "Device Type" using POST
	 */
	public static final String ADD_DEVICE_TYPE = HOST_NAME + "/addDeviceType";
	
	/**
	 * URI to delete a "Device Type" using DELETE
	 */
	public static final String DELETE_DEVICE_TYPE = HOST_NAME + "/deleteDeviceType";
	
	/**
	 * URI to add a "Device" using POST
	 */
	public static final String ADD_DEVICE = HOST_NAME + "/addDevice";
	
	/**
	 * URI to delete a "Device" using DELETE
	 */
	public static final String DELETE_DEVICE = HOST_NAME + "/deleteDevice";
	
	/**
	 * URI to update a "Sensor Type" using POST
	 */
	public static final String UPDATE_SENSOR_TYPE = HOST_NAME + "/updateSensorType";
	
	/**
	 * URI to update a "Sensor Category" using POST
	 */
	public static final String UPDATE_SENSOR_CATEGORY = HOST_NAME + "/updateSensorCategory";
	
	/**
	 * URI to update a "Sensor" using POST
	 */
	public static final String UPDATE_SENSOR = HOST_NAME + "/updateSensor";
	
	/**
	 * URI to update a "Device Type" using POST
	 */
	public static final String UPDATE_DEVICE_TYPE = HOST_NAME + "/updateDeviceType";
	
	/**
	 * URI to update a "Device" using POST
	 */
	public static final String UPDATE_DEVICE = HOST_NAME + "/updateDevice";
	
	/**
	 * URI to get "Sensor Category" by name
	 */
	public static final String GET_SENSOR_CATEGORY = HOST_NAME + "/getSensorCategory";
	
	/**
	 * URI to get "Sensor Type" by name
	 */
	public static final String GET_SENSOR_TYPE = HOST_NAME + "/getSensorType";
	
	/**
	 * URI to get "Device Type" by name
	 */
	public static final String GET_DEVICE_TYPE = HOST_NAME + "/getDeviceType";
	
	/**
	 * URI to get "Device" by name
	 */
	public static final String GET_DEVICE = HOST_NAME + "/getDevice";
	
	/**
	 * URI to get "Sensor" by name
	 */
	public static final String GET_SENSOR = HOST_NAME + "/getSensor";
}
