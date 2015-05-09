package edu.cmu.sv.sdsp.api.helper;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.google.gson.Gson;

import edu.cmu.sv.sdsp.api.json.Device;
import edu.cmu.sv.sdsp.api.json.DeviceType;
import edu.cmu.sv.sdsp.api.json.Sensor;
import edu.cmu.sv.sdsp.api.json.SensorCategory;
import edu.cmu.sv.sdsp.api.json.SensorType;
import edu.cmu.sv.sdsp.utils.HttpHelper;
import edu.cmu.sv.sdsp.utils.Logger;

/**
 * Helper class which has utility methods to perform GET and POST operations on
 * all operations supported by the Sensor Data Platform Service API.
 * 
 * @author Surya Kiran
 *
 */
public class APIHelper extends APIUrls {
	private static final Logger log = Logger.get();

	/**
	 * Supported result types
	 */
	public static enum ResultType {
		JSON, CSV
	}

	private static enum RequestType {
		GET, POST, DELETE, PUT
	}

	/**
	 * Utility function to invoke a HTTP operation.
	 * 
	 * @param type
	 *            - Is it a GET request or POST request
	 * @param url
	 *            - URL to invoke
	 * @param content
	 *            - Content to send for a POST request. Note that this is not
	 *            used for GET or DELETE requests.
	 * 
	 * @return - Response from server
	 * 
	 * @throws HttpException
	 * @throws IOException
	 */
	private static final String invokeHttpOperation(RequestType type,
			String url, String content) throws HttpException, IOException {
		log.trace("Invoking a " + type + " request for URL: " + url);

		String response = null;
		try {
			switch (type) {
			case GET:
				response = HttpHelper.performHttpGet(url);
				break;
			case POST:
				response = HttpHelper.performHttpPost(url, content);
				break;
			case DELETE:
				response = HttpHelper.performHttpDelete(url);
				break;
			case PUT:
				response = HttpHelper.performHttpPut(url, content);
				break;
			}
		} finally {
			logResponse(response);
		}

		return response;
	}

	private static void logResponse(String response) {
		if (response != null && response.length() > 200) {
			response = response.substring(0, 200)
					+ " <<< String truncated to 200 chars";
		}
		log.trace("Response String: " + response);
	}
	
	private static String processRequest(String urlPrefix, ResultType type)
			throws HttpException, IOException {
		String url = (type == null) ? urlPrefix : urlPrefix + "/"
				+ type.toString().toLowerCase();

		return invokeHttpOperation(RequestType.GET, url, null);
	}

	public static String getAllDevices(ResultType type) throws HttpException,
			IOException {
		
		return processRequest(GET_ALL_DEVICES, type);
	}

	public static String getAllDeviceTypes(ResultType type)
			throws HttpException, IOException {
		return processRequest(GET_ALL_DEVICE_TYPES, type);
	}

	public static String getAllSensorTypes(ResultType type)
			throws HttpException, IOException {
		return processRequest(GET_ALL_SENSOR_TYPES, type);
	}

	public static String getAllSensors(ResultType type) throws HttpException,
			IOException {
		return processRequest(GET_ALL_SENSORS, type);
	}

	public static String getAllSensorCategories(ResultType type)
			throws HttpException, IOException {
		return processRequest(GET_ALL_SENSOR_CATEGORIES, type);
	}

	public static String addSensorCategory(SensorCategory sc)
			throws HttpException, IOException {
		Gson gson = new Gson();
		String json = gson.toJson(sc);

		return invokeHttpOperation(RequestType.POST, ADD_SENSOR_CATEGORY, json);
	}

	public static String deleteSensorCategory(SensorCategory sc)
			throws HttpException, IOException {
		String url = DELETE_SENSOR_CATEGORY + "/" + sc.getSensorCategoryName();

		return invokeHttpOperation(RequestType.DELETE, url, null);
	}

	public static String addSensorType(SensorType st) throws HttpException,
			IOException {
		Gson gson = new Gson();
		String json = gson.toJson(st);

		return invokeHttpOperation(RequestType.POST, ADD_SENSOR_TYPE, json);
	}

	public static String deleteSensorType(SensorType st) throws HttpException,
			IOException {
		String url = DELETE_SENSOR_TYPE + "/" + st.getSensorTypeName();

		return invokeHttpOperation(RequestType.DELETE, url, null);
	}

	public static String addSensor(Sensor s) throws HttpException, IOException {
		Gson gson = new Gson();
		String json = gson.toJson(s);

		return invokeHttpOperation(RequestType.POST, ADD_SENSOR, json);
	}

	public static String deleteSensor(Sensor s) throws HttpException,
			IOException {
		String url = DELETE_SENSOR + "/" + s.getSensorName();

		return invokeHttpOperation(RequestType.DELETE, url, null);
	}

	public static String addDeviceType(DeviceType dt) throws HttpException,
			IOException {
		Gson gson = new Gson();
		String json = gson.toJson(dt);

		return invokeHttpOperation(RequestType.POST, ADD_DEVICE_TYPE, json);
	}

	public static String deleteDeviceType(DeviceType dt) throws HttpException,
			IOException {
		String url = DELETE_DEVICE_TYPE + "/" + dt.getDeviceTypeName();

		return invokeHttpOperation(RequestType.DELETE, url, null);
	}

	public static String addDevice(Device d) throws HttpException, IOException {
		Gson gson = new Gson();
		String json = gson.toJson(d);

		return invokeHttpOperation(RequestType.POST, ADD_DEVICE, json);
	}

	public static String deleteDevice(Device d) throws HttpException,
			IOException {
		String url = DELETE_DEVICE + "/" + d.getUri();

		return invokeHttpOperation(RequestType.DELETE, url, null);
	}

	public static String updateSensorType(SensorType st) throws HttpException,
			IOException {
		Gson gson = new Gson();
		String json = gson.toJson(st);

		return invokeHttpOperation(RequestType.POST, UPDATE_SENSOR_TYPE, json);
	}

	public static String updateSensorCategory(SensorCategory sc)
			throws HttpException, IOException {
		Gson gson = new Gson();
		String json = gson.toJson(sc);

		return invokeHttpOperation(RequestType.POST, UPDATE_SENSOR_CATEGORY,
				json);
	}

	public static String updateSensor(Sensor s) throws HttpException,
			IOException {
		Gson gson = new Gson();
		String json = gson.toJson(s);

		return invokeHttpOperation(RequestType.POST, UPDATE_SENSOR, json);
	}

	public static String updateDeviceType(DeviceType dt) throws HttpException,
			IOException {
		Gson gson = new Gson();
		String json = gson.toJson(dt);
		String url = UPDATE_DEVICE_TYPE + "/" + dt.getDeviceTypeName();

		return invokeHttpOperation(RequestType.PUT, url, json);
	}

	public static String updateDevice(Device d) throws HttpException,
			IOException {
		Gson gson = new Gson();
		String json = gson.toJson(d);
		String url = UPDATE_DEVICE + "/" + d.getUri();

		return invokeHttpOperation(RequestType.PUT, url, json);
	}

	public static String getSensorCategory(SensorCategory sc, ResultType type)
			throws HttpException, IOException {
		String urlPrefix = GET_SENSOR_CATEGORY + "/"
				+ sc.getSensorCategoryName();
		return processRequest(urlPrefix, type);
	}

	public static String getSensorType(SensorType st, ResultType type)
			throws HttpException, IOException {
		String urlPrefix = GET_SENSOR_TYPE + "/" + st.getSensorTypeName();
		return processRequest(urlPrefix, type);
	}

	public static String getDeviceType(DeviceType dt, ResultType type)
			throws HttpException, IOException {
		String urlPrefix = GET_DEVICE_TYPE + "/" + dt.getDeviceTypeName();
		return processRequest(urlPrefix, type);
	}
	
	public static String getDevice(Device d, ResultType type)
			throws HttpException, IOException {
		String urlPrefix = GET_DEVICE + "/" + d.getUri();
		return processRequest(urlPrefix, type);
	}
	
	public static String getSensor(Sensor s, ResultType type)
			throws HttpException, IOException {
		String urlPrefix = GET_SENSOR + "/" + s.getSensorName();
		return processRequest(urlPrefix, type);
	}
}
