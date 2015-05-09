package edu.cmu.sv.sdsp.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.cmu.sv.sdsp.api.helper.APIHelper;
import edu.cmu.sv.sdsp.api.helper.APIHelper.ResultType;
import edu.cmu.sv.sdsp.api.json.Device;
import edu.cmu.sv.sdsp.api.json.DeviceType;
import edu.cmu.sv.sdsp.api.json.Location;
import edu.cmu.sv.sdsp.api.json.Sensor;
import edu.cmu.sv.sdsp.api.json.SensorCategory;
import edu.cmu.sv.sdsp.api.json.SensorType;

/**
 * Class to perform integration tests on the API to verify it.
 * 
 * @author Surya Kiran
 *
 */
@RunWith(JUnit4.class)
public class APIIntegrationTest extends BaseTest {
	@Test
	public void addAndRemoveSensorCategory() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC1",
				"For Integration Testing");
		try {
			addSensorCategory(sc);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void addAndRemoveSensorType() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC2",
				"For Integration Testing");
		SensorType st = new SensorType("JUnit-Test-ST1",
				sc.getSensorCategoryName());

		try {
			addSensorCategory(sc);
			addSensorType(st);
		} catch (IOException e) {
			processException(e);
		} finally {
			// Clean up
			try {
				deleteSensorType(st);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}

		}
	}

	@Test
	public void addAndRemoveDeviceType() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC3",
				"For Integration Testing");
		SensorType st1 = new SensorType("JUnit-Test-ST2",
				sc.getSensorCategoryName());
		SensorType st2 = new SensorType("JUnit-Test-ST3",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st1.getSensorTypeName());
		sensorTypeNames.add(st2.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT1", sensorTypeNames);

		try {
			addSensorCategory(sc);
			addSensorType(st1);
			addSensorType(st2);
			addDeviceType(dt);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDeviceType(dt);
				deleteSensorType(st2);
				deleteSensorType(st1);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void addAndRemoveDevice() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC4",
				"For Integration Testing");
		SensorType st4 = new SensorType("JUnit-Test-ST4",
				sc.getSensorCategoryName());
		SensorType st5 = new SensorType("JUnit-Test-ST5",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st4.getSensorTypeName());
		sensorTypeNames.add(st5.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT2", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location1");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device1", l);

		try {
			addSensorCategory(sc);
			addSensorType(st4);
			addSensorType(st5);
			addDeviceType(dt);
			addDevice(d);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st5);
				deleteSensorType(st4);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void addAndRemoveSensor() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC5",
				"For Integration Testing");
		SensorType st6 = new SensorType("JUnit-Test-ST6",
				sc.getSensorCategoryName());
		SensorType st7 = new SensorType("JUnit-Test-ST7",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st6.getSensorTypeName());
		sensorTypeNames.add(st7.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT3", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location2");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device2", l);
		Sensor s = new Sensor("JUnit-Test-Sensor1", st6.getSensorTypeName(),
				d.getUri());

		try {
			addSensorCategory(sc);
			addSensorType(st6);
			addSensorType(st7);
			addDeviceType(dt);
			addDevice(d);
			addSensor(s);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensor(s);
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st7);
				deleteSensorType(st6);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void updateSensorType() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC6",
				"For Integration Testing");
		SensorType st = new SensorType("JUnit-Test-ST8",
				sc.getSensorCategoryName());
		try {
			addSensorCategory(sc);
			addSensorType(st);

			// Update
			st.setSensorTypeUserDefinedFields("Updated value: good");
			updateSensorType(st);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensorType(st);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void updateSensorCategory() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC7",
				"For Integration Testing");

		try {
			addSensorCategory(sc);

			// Update
			sc.setPurpose("Purpose changed to Production testing");
			updateSensorCategory(sc);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void updateSensor() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC8",
				"For Integration Testing");
		SensorType stA = new SensorType("JUnit-Test-ST9",
				sc.getSensorCategoryName());
		SensorType stB = new SensorType("JUnit-Test-ST10",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(stA.getSensorTypeName());
		sensorTypeNames.add(stB.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT4", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location3");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device3", l);
		Sensor s = new Sensor("JUnit-Test-Sensor2", stA.getSensorTypeName(),
				d.getUri());

		try {
			addSensorCategory(sc);
			addSensorType(stA);
			addSensorType(stB);
			addDeviceType(dt);
			addDevice(d);
			addSensor(s);

			// Update
			s.setSensorUserDefinedFields("Updated value: good");
			updateSensor(s);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensor(s);
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(stB);
				deleteSensorType(stA);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void updateDeviceType() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC9",
				"For Integration Testing");
		SensorType stA = new SensorType("JUnit-Test-ST11",
				sc.getSensorCategoryName());
		SensorType stB = new SensorType("JUnit-Test-ST12",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(stA.getSensorTypeName());
		sensorTypeNames.add(stB.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT5", sensorTypeNames);

		try {
			addSensorCategory(sc);
			addSensorType(stA);
			addSensorType(stB);
			addDeviceType(dt);

			// Update
			dt.setDeviceTypeUserDefinedFields("Updated value: good");
			updateDeviceType(dt);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDeviceType(dt);
				deleteSensorType(stB);
				deleteSensorType(stA);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	// @Test
	// public void updateDevice() {
	// 	SensorCategory sc = new SensorCategory("JUnit-Test-SC10",
	// 			"For Integration Testing");
	// 	SensorType st4 = new SensorType("JUnit-Test-ST13",
	// 			sc.getSensorCategoryName());
	// 	SensorType st5 = new SensorType("JUnit-Test-ST14",
	// 			sc.getSensorCategoryName());
	// 	List<String> sensorTypeNames = new ArrayList<String>();
	// 	sensorTypeNames.add(st4.getSensorTypeName());
	// 	sensorTypeNames.add(st5.getSensorTypeName());
	// 	DeviceType dt = new DeviceType("JUnit-Test-DT6", sensorTypeNames);
	// 	Location l = new Location("JUnit-Test-Location4");
	// 	Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device4", l);

	// 	try {
	// 		addSensorCategory(sc);
	// 		addSensorType(st4);
	// 		addSensorType(st5);
	// 		addDeviceType(dt);
	// 		addDevice(d);

	// 		// Update
	// 		Location lMoved = new Location("JUnit-Test-Location5");
	// 		d.setLocation(lMoved);
	// 		updateDevice(d);
	// 	} catch (IOException e) {
	// 		processException(e);
	// 	} finally {
	// 		try {
	// 			// Clean up
	// 			deleteDevice(d);
	// 			deleteDeviceType(dt);
	// 			deleteSensorType(st5);
	// 			deleteSensorType(st4);
	// 			deleteSensorCategory(sc);
	// 		} catch (IOException e) {
	// 			processException(e);
	// 		}
	// 	}
	// }

	@Test
	public void getSensorCategory() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC11",
				"For Integration Testing");
		try {
			addSensorCategory(sc);

			getSensorCategory(sc, null);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorCategoryCSV() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC12",
				"For Integration Testing");
		try {
			addSensorCategory(sc);

			getSensorCategory(sc, ResultType.CSV);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorCategoryJSON() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC13",
				"For Integration Testing");
		try {
			addSensorCategory(sc);

			getSensorCategory(sc, ResultType.JSON);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorType() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC14",
				"For Integration Testing");
		SensorType st = new SensorType("JUnit-Test-ST15",
				sc.getSensorCategoryName());
		try {
			addSensorCategory(sc);
			addSensorType(st);

			getSensorType(st, null);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensorType(st);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorTypeCSV() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC15",
				"For Integration Testing");
		SensorType st = new SensorType("JUnit-Test-ST16",
				sc.getSensorCategoryName());
		try {
			addSensorCategory(sc);
			addSensorType(st);

			getSensorType(st, ResultType.CSV);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensorType(st);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorTypeJSON() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC16",
				"For Integration Testing");
		SensorType st = new SensorType("JUnit-Test-ST17",
				sc.getSensorCategoryName());
		try {
			addSensorCategory(sc);
			addSensorType(st);

			getSensorType(st, ResultType.JSON);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensorType(st);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getDeviceType() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC18",
				"For Integration Testing");
		SensorType st1 = new SensorType("JUnit-Test-ST19",
				sc.getSensorCategoryName());
		SensorType st2 = new SensorType("JUnit-Test-ST20",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st1.getSensorTypeName());
		sensorTypeNames.add(st2.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT7", sensorTypeNames);

		try {
			addSensorCategory(sc);
			addSensorType(st1);
			addSensorType(st2);
			addDeviceType(dt);

			getDeviceType(dt, null);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDeviceType(dt);
				deleteSensorType(st2);
				deleteSensorType(st1);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getDeviceTypeCSV() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC19",
				"For Integration Testing");
		SensorType st1 = new SensorType("JUnit-Test-ST21",
				sc.getSensorCategoryName());
		SensorType st2 = new SensorType("JUnit-Test-ST22",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st1.getSensorTypeName());
		sensorTypeNames.add(st2.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT8", sensorTypeNames);
		try {
			addSensorCategory(sc);
			addSensorType(st1);
			addSensorType(st2);
			addDeviceType(dt);

			getDeviceType(dt, ResultType.CSV);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDeviceType(dt);
				deleteSensorType(st2);
				deleteSensorType(st1);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getDeviceTypeJSON() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC20",
				"For Integration Testing");
		SensorType st1 = new SensorType("JUnit-Test-ST23",
				sc.getSensorCategoryName());
		SensorType st2 = new SensorType("JUnit-Test-ST24",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st1.getSensorTypeName());
		sensorTypeNames.add(st2.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT9", sensorTypeNames);

		try {
			addSensorCategory(sc);
			addSensorType(st1);
			addSensorType(st2);
			addDeviceType(dt);

			getDeviceType(dt, ResultType.CSV);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDeviceType(dt);
				deleteSensorType(st2);
				deleteSensorType(st1);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getDevice() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC21",
				"For Integration Testing");
		SensorType st4 = new SensorType("JUnit-Test-ST25",
				sc.getSensorCategoryName());
		SensorType st5 = new SensorType("JUnit-Test-ST26",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st4.getSensorTypeName());
		sensorTypeNames.add(st5.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT10", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location6");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device5", l);
		try {
			addSensorCategory(sc);
			addSensorType(st4);
			addSensorType(st5);
			addDeviceType(dt);
			addDevice(d);

			getDevice(d, null);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st5);
				deleteSensorType(st4);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	// @Test
	// public void getDeviceCSV() {
	// 	SensorCategory sc = new SensorCategory("JUnit-Test-SC22",
	// 			"For Integration Testing");
	// 	SensorType st4 = new SensorType("JUnit-Test-ST27",
	// 			sc.getSensorCategoryName());
	// 	SensorType st5 = new SensorType("JUnit-Test-ST28",
	// 			sc.getSensorCategoryName());
	// 	List<String> sensorTypeNames = new ArrayList<String>();
	// 	sensorTypeNames.add(st4.getSensorTypeName());
	// 	sensorTypeNames.add(st5.getSensorTypeName());
	// 	DeviceType dt = new DeviceType("JUnit-Test-DT11", sensorTypeNames);
	// 	Location l = new Location("JUnit-Test-Location7");
	// 	Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device6", l);
	// 	try {
	// 		addSensorCategory(sc);
	// 		addSensorType(st4);
	// 		addSensorType(st5);
	// 		addDeviceType(dt);
	// 		addDevice(d);

	// 		getDevice(d, ResultType.CSV);
	// 	} catch (IOException e) {
	// 		processException(e);
	// 	} finally {
	// 		try {
	// 			// Clean up
	// 			deleteDevice(d);
	// 			deleteDeviceType(dt);
	// 			deleteSensorType(st5);
	// 			deleteSensorType(st4);
	// 			deleteSensorCategory(sc);
	// 		} catch (IOException e) {
	// 			processException(e);
	// 		}
	// 	}
	// }

	@Test
	public void getDeviceJSON() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC23",
				"For Integration Testing");
		SensorType st4 = new SensorType("JUnit-Test-ST29",
				sc.getSensorCategoryName());
		SensorType st5 = new SensorType("JUnit-Test-ST30",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st4.getSensorTypeName());
		sensorTypeNames.add(st5.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT12", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location8");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device7", l);

		try {
			addSensorCategory(sc);
			addSensorType(st4);
			addSensorType(st5);
			addDeviceType(dt);
			addDevice(d);

			getDevice(d, ResultType.JSON);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st5);
				deleteSensorType(st4);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensor() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC24",
				"For Integration Testing");
		SensorType st6 = new SensorType("JUnit-Test-ST31",
				sc.getSensorCategoryName());
		SensorType st7 = new SensorType("JUnit-Test-ST32",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st6.getSensorTypeName());
		sensorTypeNames.add(st7.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT13", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location9");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device8", l);
		Sensor s = new Sensor("JUnit-Test-Sensor3", st6.getSensorTypeName(),
				d.getUri());

		try {
			addSensorCategory(sc);
			addSensorType(st6);
			addSensorType(st7);
			addDeviceType(dt);
			addDevice(d);
			addSensor(s);

			getSensor(s, null);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensor(s);
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st7);
				deleteSensorType(st6);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorCSV() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC25",
				"For Integration Testing");
		SensorType st6 = new SensorType("JUnit-Test-ST33",
				sc.getSensorCategoryName());
		SensorType st7 = new SensorType("JUnit-Test-ST34",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st6.getSensorTypeName());
		sensorTypeNames.add(st7.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT14", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location10");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device9", l);
		Sensor s = new Sensor("JUnit-Test-Sensor4", st6.getSensorTypeName(),
				d.getUri());

		try {
			addSensorCategory(sc);
			addSensorType(st6);
			addSensorType(st7);
			addDeviceType(dt);
			addDevice(d);
			addSensor(s);

			getSensor(s, ResultType.CSV);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensor(s);
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st7);
				deleteSensorType(st6);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	@Test
	public void getSensorJSON() {
		SensorCategory sc = new SensorCategory("JUnit-Test-SC26",
				"For Integration Testing");
		SensorType st6 = new SensorType("JUnit-Test-ST35",
				sc.getSensorCategoryName());
		SensorType st7 = new SensorType("JUnit-Test-ST36",
				sc.getSensorCategoryName());
		List<String> sensorTypeNames = new ArrayList<String>();
		sensorTypeNames.add(st6.getSensorTypeName());
		sensorTypeNames.add(st7.getSensorTypeName());
		DeviceType dt = new DeviceType("JUnit-Test-DT15", sensorTypeNames);
		Location l = new Location("JUnit-Test-Location11");
		Device d = new Device(dt.getDeviceTypeName(), "JUnit-Test-Device10", l);
		Sensor s = new Sensor("JUnit-Test-Sensor5", st6.getSensorTypeName(),
				d.getUri());

		try {
			addSensorCategory(sc);
			addSensorType(st6);
			addSensorType(st7);
			addDeviceType(dt);
			addDevice(d);
			addSensor(s);

			getSensor(s, ResultType.JSON);
		} catch (IOException e) {
			processException(e);
		} finally {
			try {
				// Clean up
				deleteSensor(s);
				deleteDevice(d);
				deleteDeviceType(dt);
				deleteSensorType(st7);
				deleteSensorType(st6);
				deleteSensorCategory(sc);
			} catch (IOException e) {
				processException(e);
			}
		}
	}

	private String getSensor(Sensor s, ResultType type) throws HttpException,
			IOException {
		String resp = APIHelper.getSensor(s, type);
		assertReponseNotNull(resp);

		return resp;
	}

	private String getDevice(Device d, ResultType type) throws HttpException,
			IOException {
		String resp = APIHelper.getDevice(d, type);
		assertReponseNotNull(resp);

		return resp;
	}

	private String getDeviceType(DeviceType dt, ResultType type)
			throws HttpException, IOException {
		String resp = APIHelper.getDeviceType(dt, type);
		assertReponseNotNull(resp);

		return resp;
	}

	private String getSensorType(SensorType st, ResultType type)
			throws HttpException, IOException {
		String resp = APIHelper.getSensorType(st, type);
		assertReponseNotNull(resp);

		return resp;
	}

	private String getSensorCategory(SensorCategory sc, ResultType type)
			throws HttpException, IOException {
		String resp = APIHelper.getSensorCategory(sc, type);
		assertReponseNotNull(resp);

		return resp;
	}

	private String updateDevice(Device d) throws HttpException, IOException {
		String resp = APIHelper.updateDevice(d);
		Assert.assertTrue("Response should contain the content: " + d.getUri(),
				resp.contains(d.getUri()));

		return resp;
	}

	private String updateDeviceType(DeviceType dt) throws HttpException,
			IOException {
		String resp = APIHelper.updateDeviceType(dt);
		Assert.assertTrue(
				"Response should contain the content: "
						+ dt.getDeviceTypeUserDefinedFields(),
				resp.contains(dt.getDeviceTypeUserDefinedFields()));

		return resp;
	}

	private String updateSensor(Sensor s) throws HttpException, IOException {
		String resp = APIHelper.updateSensor(s);
		Assert.assertTrue("Response should contain the word 'Sensor updated'",
				resp.contains("Sensor updated"));

		return resp;
	}

	private String updateSensorCategory(SensorCategory sc)
			throws HttpException, IOException {
		String resp = APIHelper.updateSensorCategory(sc);
		Assert.assertTrue(
				"Response should contain the word 'Sensor category updated'",
				resp.contains("Sensor category updated"));

		return resp;
	}

	private String updateSensorType(SensorType st) throws HttpException,
			IOException {
		String resp = APIHelper.updateSensorType(st);
		Assert.assertTrue(
				"Response should contain the word 'Sensor type updated'",
				resp.contains("Sensor type updated"));

		return resp;
	}

	private String addSensor(Sensor s) throws HttpException, IOException {
		String resp = APIHelper.addSensor(s);
		Assert.assertTrue("Response should contain the word 'Sensor saved'",
				resp.contains("Sensor saved"));

		return resp;
	}

	private String deleteSensor(Sensor s) throws HttpException, IOException {
		String resp = APIHelper.deleteSensor(s);
		Assert.assertTrue("Response should contain the word 'Sensor deleted'",
				resp.contains("Sensor deleted"));

		return resp;
	}

	private String addDevice(Device d) throws HttpException, IOException {
		String resp = APIHelper.addDevice(d);
		Assert.assertTrue("Response should contain the word 'device saved'",
				resp.contains("device saved"));

		return resp;
	}

	private String deleteDevice(Device d) throws HttpException, IOException {
		String resp = APIHelper.deleteDevice(d);
		Assert.assertTrue("Response should contain the word 'Device deleted'",
				resp.contains("Device deleted"));

		return resp;
	}

	private String addDeviceType(DeviceType dt) throws HttpException,
			IOException {
		String resp = APIHelper.addDeviceType(dt);
		Assert.assertTrue(
				"Response should contain the word 'device type saved'",
				resp.contains("device type saved"));

		return resp;
	}

	private String deleteDeviceType(DeviceType dt) throws HttpException,
			IOException {
		String resp = APIHelper.deleteDeviceType(dt);
		Assert.assertTrue(
				"Response should contain the word 'Device type deleted'",
				resp.contains("Device type deleted"));

		return resp;
	}

	private String addSensorType(SensorType st) throws HttpException,
			IOException {
		String resp = APIHelper.addSensorType(st);
		Assert.assertTrue(
				"Response should contain the word 'Sensor type saved'",
				resp.contains("Sensor type saved"));

		return resp;
	}

	private String deleteSensorType(SensorType st) throws HttpException,
			IOException {
		String resp = APIHelper.deleteSensorType(st);
		Assert.assertTrue(
				"Response should contain the word 'Sensor type deleted'",
				resp.contains("Sensor type deleted"));

		return resp;
	}

	private String addSensorCategory(SensorCategory sc) throws HttpException,
			IOException {
		String resp = APIHelper.addSensorCategory(sc);
		Assert.assertTrue(
				"Response should contain the word 'Sensor category saved'",
				resp.contains("Sensor category saved"));

		return resp;
	}

	private String deleteSensorCategory(SensorCategory sc)
			throws HttpException, IOException {
		String resp = APIHelper.deleteSensorCategory(sc);
		Assert.assertTrue(
				"Response should contain the word 'Sensor category is deleted'",
				resp.contains("Sensor category is deleted"));

		return resp;
	}

}
