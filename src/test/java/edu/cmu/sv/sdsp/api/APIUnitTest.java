package edu.cmu.sv.sdsp.api;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.cmu.sv.sdsp.api.helper.APIHelper;
import edu.cmu.sv.sdsp.api.helper.APIHelper.ResultType;

/**
 * Class to perform individual unit testing on API to check if the API
 * operations work independently.
 * 
 * @author Surya Kiran
 */
@RunWith(JUnit4.class)
public class APIUnitTest extends BaseTest {
	@Test
	public void testGetAllDevices() {
		try {
			String resp = APIHelper.getAllDevices(null);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllDevicesCSV() {
		try {
			String resp = APIHelper.getAllDevices(ResultType.CSV);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllDevicesJSON() {
		try {
			String resp = APIHelper.getAllDevices(ResultType.JSON);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllDeviceTypes() {
		try {
			String resp = APIHelper.getAllDeviceTypes(null);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllDeviceTypesCSV() {
		try {
			String resp = APIHelper.getAllDeviceTypes(ResultType.CSV);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllDeviceTypesJSON() {
		try {
			String resp = APIHelper.getAllDeviceTypes(ResultType.JSON);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorTypes() {
		try {
			String resp = APIHelper.getAllSensorTypes(null);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorTypesCSV() {
		try {
			String resp = APIHelper.getAllSensorTypes(ResultType.CSV);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorTypesJSON() {
		try {
			String resp = APIHelper.getAllSensorTypes(ResultType.JSON);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensors() {
		try {
			String resp = APIHelper.getAllSensors(null);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorsCSV() {
		try {
			String resp = APIHelper.getAllSensors(ResultType.CSV);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorsJSON() {
		try {
			String resp = APIHelper.getAllSensors(ResultType.JSON);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorCategories() {
		try {
			String resp = APIHelper.getAllSensorCategories(null);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorCategoriesCSV() {
		try {
			String resp = APIHelper.getAllSensorCategories(ResultType.CSV);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}

	@Test
	public void testGetAllSensorCategoriesJSON() {
		try {
			String resp = APIHelper.getAllSensorCategories(ResultType.JSON);
			assertReponseNotNull(resp);
		} catch (IOException e) {
			processException(e);
		}
	}
}
