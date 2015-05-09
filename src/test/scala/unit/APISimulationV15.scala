/**
 * Copyright (c) 2013 Carnegie Mellon University Silicon Valley. 
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available
 * under the terms of dual licensing(GPL V2 for Research/Education
 * purposes). GNU Public License v2.0 which accompanies this distribution
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 * Please contact http://www.cmu.edu/silicon-valley/ for more specific
 * information.
 */

package unit

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.http.Headers.Names._
import scala.concurrent.duration._
import bootstrap._
import assertions._

/**
 * Class that runs Load and Performance testing for GET operations
 * on the Sensor Data Service Platform V1.5
 *
 * Author: Surya Kiran
 */
class APISimulationV15 extends Simulation {
	// Perpare the HTTP config we would like to invoke the request on  
	val httpConf_v15 = http.baseURL("http://einstein.sv.cmu.edu:9000")
	//val httpConf_v15 = http.baseURL("http://127.0.0.1:8080")
		.acceptCharsetHeader("utf-8")
		.acceptHeader("text/html")
		.disableFollowRedirect

	// Difference headers for the requests.		
	val headers_1 = Map("Keep-Alive" -> "115")
	val headers_2 = Map("Accept" -> "application/json", "Keep-Alive" -> "115")

	// Build up the scenario on which we would like to perform 
	// Load testing and gauge it's performance.
	// 1. Get All Devices
	val scn = scenario("Sensor Data Service Platform v1.5")
		.group("GetAllDevices") {
			exec(
				http("GetAllDevices_R1")
					.get("/get_devices")
					.headers(headers_1)
					.check(status.is(200)))  //200 ok
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllDevices_R2")
						.get("/get_devices/csv")
						.headers(headers_1))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllDevices_R3")
						.get("/get_devices/json")
						.headers(headers_1))
		}
	// Pause between the requests for 1000 milliseconds.
	// And perform another round of testing on different
	// API methods	
	// 2. Get All Sensor Types
		.pause(100 milliseconds, 1000 milliseconds)
		.group("GetAllSensorTypes") {
			exec(
				http("GetAllSensorTypes_R1")
					.get("/get_all_sensor_types")
					.headers(headers_1)
					.check(status.is(200)))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllSensorTypes_R2")
						.get("/get_all_sensor_types/csv")
						.headers(headers_1))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllSensorTypes_R3")
						.get("/get_all_sensor_types/json")
						.headers(headers_1))
		}
	// // 3. Get All Sensor Categories
	// OLD version!!!
	// 	.pause(100 milliseconds, 1000 milliseconds)
	// 	.group("GetAllSensorCategories") {
	// 		exec(
	// 			http("GetAllSensorCategories_R1")
	// 				.get("/getAllSensorCategories")
	// 				.headers(headers_1)
	// 				.check(status.is(200)))
	// 			.pause(100 milliseconds, 1000 milliseconds)
	// 			.exec(
	// 				http("GetAllSensorCategories_R2")
	// 					.get("/getAllSensorCategories/csv")
	// 					.headers(headers_1))
	// 			.pause(100 milliseconds, 1000 milliseconds)
	// 			.exec(
	// 				http("GetAllSensorCategories_R3")
	// 					.get("/getAllSensorCategories/json")
	// 					.headers(headers_1))
	// 	}
	// 4. Get All Device Types
		.pause(100 milliseconds, 1000 milliseconds)
		.group("get_device_types") {
			exec(
				http("GetAllDeviceTypes_R1")
					.get("/get_device_types")
					.headers(headers_1)
					.check(status.is(200)))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllDeviceTypes_R2")
						.get("/get_device_types/csv")
						.headers(headers_1))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllDeviceTypes_R3")
						.get("/get_device_types/json")
						.headers(headers_1))
		}
	// 5. Get All Sensors
		.pause(100 milliseconds, 1000 milliseconds)
		.group("GetAllSensors") {
			exec(
				http("GetAllSensors_R1")
					.get("/get_sensors")
					.headers(headers_1)
					.check(status.is(200)))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllSensors_R2")
						.get("/get_sensors/csv")
						.headers(headers_1))
				.pause(100 milliseconds, 1000 milliseconds)
				.exec(
					http("GetAllSensors_R3")
						.get("/get_sensors/json")
						.headers(headers_1))
		}
		
	// Setup and execute the scenario that is prepared above.
	// Run it simulating 100 users accessing the API in 
	// a time range of 30 seconds. 
	setUp(scn.inject(ramp(100 users) over (30 seconds)))
		.protocols(httpConf_v15)
		.assertions(
			global.successfulRequests.percent.is(100),
			details("get_devices" / "GetAllDevices_R1").responseTime.max.lessThan(20000))
}
