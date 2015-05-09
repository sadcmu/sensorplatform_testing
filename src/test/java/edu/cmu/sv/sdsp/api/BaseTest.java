package edu.cmu.sv.sdsp.api;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.cmu.sv.sdsp.utils.Constants;
import edu.cmu.sv.sdsp.utils.Logger;

/**
 * This is the base class which contains common code related to 
 * both Unit and Integration tests.
 * 
 * @author Surya Kiran
 *
 */
public class BaseTest {
	private static final Logger log = Logger.get();
	private Date testStart, testEnd;
	
	/**
	 *  Add a rule that all JUnit test cases run for a maximum of 2 minutes.
	 */
	@Rule
	public Timeout testCaseTimeOut = new Timeout(Constants.JUNIT_TIMEOUT);
	
	/**
	 * This method is called before every test case is run.
	 */
	@Before
	public void recordStartTimeForTest() {
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		testStart = new Date();
		log.debug("Test case started at :: " + testStart.getTime());
	}
	
	/**
	 * This method is called after every test case is run.
	 */
	@After
	public void recordEndTimeForTest() {
		testEnd = new Date();
		log.debug("Test case completed at :: " + testEnd.getTime());
		log.debug("Time taken to process this testcase: "
				+ (testEnd.getTime() - testStart.getTime()) + " ms");
		log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
	}
	
	/**
	 * Utility method to check if the  object is NOT NULL.
	 * 
	 * @param obj - Object to be asserted for NOT NULL
	 */
	protected void assertReponseNotNull(Object obj) {
		Assert.assertNotNull("Error :: Object passed for NOT NULL verification was found NULL.", obj);
	}
	
	protected void assertResponseSaved(String str){
		Assert.assertTrue("Error :: The request is not SAVED.", str.equals("saved"));
	}
	
	
	/**
	 * Utility method to convert a JsonArray represented in a string
	 * into a JsonArray object.
	 * 
	 * @param jsonStr - JsonArray represented in a string
	 * 
	 * @return - String content as a JsonArray
	 */
	protected JsonArray getArrayFromJsonString(String jsonStr) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(jsonStr);
		JsonArray jsonArray = element.getAsJsonArray();
		
		return jsonArray;
	}
	
	/**
	 * This utility method parses the response string and returns
	 * the string returned as message.
	 * 
	 * @param response - Json String
	 * @return - Response message
	 */
	protected String parseResponseMessage(String response) {
		JsonObject jsonObj = new JsonObject();
		JsonParser parser =  new JsonParser();
		
		try {
			jsonObj = (JsonObject) parser.parse(response);
			return jsonObj.get("message").getAsString();	
		} catch(Exception e) {
			// This means that the input passed is not likely
			// to be a JSON string. Just ignore the error message,
			// and return the input string.
		}
		
		return response;
	}
	
	protected void processException(IOException e) {
		log.error(e);
		Assert.fail();
	}
}
