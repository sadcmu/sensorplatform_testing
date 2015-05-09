package edu.cmu.sv.sdsp.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 * Utility Helper class to make GET and POST requests to a URL. This class also
 * handles parameters you would like to send as part of the POST request. Note
 * that responses from the server are returned to the caller of this API for 
 * every request.
 * 
 * @author Surya Kiran
 *
 */
public class HttpHelper {
	private static final Logger log = Logger.get();
	
	/**
	 * Utility method which performs GET operation on a URL
	 * and returns the response from server. 
	 * 
	 * @param urlStr - URL to perform a GET on.
	 * 
	 * @return - String representation of the response.
	 * 
	 * @throws HttpException
	 * @throws IOException
	 */
	public static String performHttpGet(String urlStr) throws HttpException, IOException {
		log.enter(urlStr);
		
		HttpClient client = getHttpClient();
				
		GetMethod get = new GetMethod(urlStr);
		get.setFollowRedirects(true);

		String response = null;
		try {
			int responseCode = client.executeMethod(get);
			log.debug("Response code from server :: " + responseCode);
			response = get.getResponseBodyAsString();	
		} finally {
			get.releaseConnection();
		}
		
		logResponse(response);
		
		return response;
	}
	
	public static String performHttpPost(String urlStr, String content) throws HttpException, IOException {
		log.enter(urlStr, content);
		
		String response = null;
		HttpClient client = getHttpClient();

		PostMethod post = new PostMethod(urlStr);
		StringRequestEntity sre = new StringRequestEntity(content, Constants.CONTENT_TYPE_JSON, Constants.CHARSET_UTF8);
		post.setRequestEntity(sre);
		
		try {
			int respCode = client.executeMethod(post);
			log.debug("Response code from server :: " + respCode);
			response = post.getResponseBodyAsString();
		} finally {
			post.releaseConnection();
		}
		
		logResponse(response);
		return response;
	}
	
	public static String performHttpDelete(String urlStr) throws HttpException, IOException {
		log.enter(urlStr);
		
		String response = null;
		HttpClient client = getHttpClient();
		
		DeleteMethod delete = new DeleteMethod(urlStr);
		delete.setFollowRedirects(true);
		
		try {
			int responseCode = client.executeMethod(delete);
			log.debug("Response code from server :: " + responseCode);
			response = delete.getResponseBodyAsString();	
		} finally {
			delete.releaseConnection();
		}
		
		logResponse(response);
		return response;
	}
	
	public static String performHttpPut(String urlStr, String content) throws HttpException, IOException {
		log.enter(urlStr, content);
		
		String response = null;
		HttpClient client = getHttpClient();

		PutMethod put = new PutMethod(urlStr);
		StringRequestEntity sre = new StringRequestEntity(content, Constants.CONTENT_TYPE_JSON, Constants.CHARSET_UTF8);
		put.setRequestEntity(sre);
		
		try {
			int respCode = client.executeMethod(put);
			log.debug("Response code from server :: " + respCode);
			response = put.getResponseBodyAsString();
		} finally {
			put.releaseConnection();
		}
		
		logResponse(response);
		return response;
	}
	
	private static HttpClient getHttpClient() {
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(Constants.CONNECTION_TIMEOUT);
		
		return client;
	}
	
	private static void logResponse(String response) {
		if(response == null || response.length() <= 200) {
			log.exit(response);
		} else {
			log.exit(response.substring(0, 199) + " << Truncated");
		}
	}
}
