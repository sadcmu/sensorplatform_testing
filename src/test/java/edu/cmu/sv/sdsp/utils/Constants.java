package edu.cmu.sv.sdsp.utils;

/**
 * All the constants used in this project are listed here.
 * It will be easy to externalize these values when we 
 * do internationalization, or want to load paramter values 
 * from external properties file.
 * 
 * @author Surya Kiran
 *
 */
public class Constants {
	/**
	 *  Time out for any HTTP connections
	 */
	public static final int CONNECTION_TIMEOUT = 30000;
	
	/**
	 * Time out for JUnit test cases
	 */
	public static final int JUNIT_TIMEOUT = 120 * 1000; // 2 minutes
	
	/**
	 *  CSV format
	 */
	public static final String CSV = "csv";
	
	/**
	 *  JSON format
	 */
	public static final String JSON = "json";
	
	/**
	 * UTF-8
	 */
	public static final String CHARSET_UTF8 = "UTF-8";
	
	/**
	 * Use plain text for character encoding
	 */
	public static final String CONTENT_TYPE_JSON = "application/json";
}
