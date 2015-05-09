package edu.cmu.sv.sdsp.utils;

import org.apache.log4j.Priority;

/**
 * This is a helper Logging class that helps with logging
 * content using Log4J.
 * 
 * @author Surya Kiran
 *
 */
public final class Logger {
	private static final org.apache.log4j.Logger LOG;
	private static final Logger logger;
	
	static {
		LOG = org.apache.log4j.Logger.getLogger("edu.cmu.sv");
		logger = new Logger();
	}

	/**
	 * Get the singleton reference to Logger class instance.
	 * 
	 * @return - Instance of Logger class.
	 */
	public static final Logger get() {
		return logger;
	}

	/**
	 * Log a message with DEBUG priority
	 * 
	 * @param obj - Object to be logged
	 */
	public void debug(Object obj) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(getLogPrefix() + " > " + obj);
		}
	}

	/**
	 * Log a message with INFO priority
	 * 
	 * @param obj - Object to be logged
	 */
	public void info(Object obj) {
		if (LOG.isInfoEnabled()) {
			LOG.info(getLogPrefix() + " > " + obj);
		}
	}

	/**
	 * Log a message with ERROR priority
	 * 
	 * @param obj - Object to be logged
	 */
	@SuppressWarnings("deprecation")
	public void error(Object obj) {
		if (LOG.isEnabledFor(Priority.ERROR)) {
			LOG.error(getLogPrefix() + " > " + obj);
		}
	}

	/**
	 * Log a message with WARN priority
	 * 
	 * @param obj - Object to be logged
	 */
	@SuppressWarnings("deprecation")
	public void warn(Object obj) {
		if (LOG.isEnabledFor(Priority.WARN)) {
			LOG.warn(getLogPrefix() + " > " + obj);
		}
	}

	/**
	 * Log a message with TRACE priority
	 * 
	 * @param obj - Object to be logged
	 */
	public void trace(Object obj) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(getLogPrefix() + " > " + obj);
		}
	}

	/**
	 * Log a message at TRACE level notifying entry into a method.
	 * 
	 * @param obj - Zero or more Objects to be logged
	 */
	public void enter(Object... obj) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(getLogPrefix() + " > Inside method.");
			int index = 1;
			for(Object o : obj) {
				LOG.trace("\t Param " + (index++) + " : "  + o);
			}
		}
	}

	/**
	 * Log a message at TRACE level notifying exit from a method.
	 * 
	 * @param obj - Zero or more Objects to be logged
	 */
	public void exit(Object... obj) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(getLogPrefix() + " > Exiting method.");
			int index = 1;
			for(Object o : obj) {
				LOG.trace("\t Param " + (index++) + " : "  + o);
			}
		}
	}

	/**
	 * Method that parses the call stack and returns the calling
	 * class name to be using during logging.
	 *  
	 * @return - Name of the calling class.
	 */
	private String getLogPrefix() {
		StackTraceElement[] s = new RuntimeException().getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append(s[2].getClassName()).append(" - ")
				.append(s[2].getMethodName());
		return sb.toString();
	}
}
