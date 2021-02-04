package test.server;

import java.net.URI;

import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

final class Request {

	final private String method;
	final private URI uri;
	final private String protocol;
	final private HashMap<String, String> headers;
	final private String body;

	public Request(String req)
	throws Exception {
		headers = new HashMap<>();
		StringTokenizer reqMain = new StringTokenizer(req, "\r\n");
		StringTokenizer reqTop = new StringTokenizer(reqMain.nextToken(), " ");

		if(reqTop.countTokens() != 3)
			throw new Exception("Invalid start line");

		method = reqTop.nextToken();
		uri = new URI(reqTop.nextToken());
		protocol = reqTop.nextToken();
		reqTop = null;

		while(reqMain.hasMoreTokens()){
			String rawHead = reqMain.nextToken();

			if(rawHead.isBlank()) break;

			StringTokenizer head = new StringTokenizer(rawHead, ":");

			headers.put(head.nextToken(), head.nextToken(""));
		}

		if(reqMain.hasMoreTokens())
			body = reqMain.nextToken();
		else
			body = null;
	}

	public String getMethod(){
		return method;
	}

	public URI getURI(){
		return uri;
	}

	public String protocol(){
		return protocol;
	}

	public String getHeader(String key){
		return headers.get(key);
	}

	public Collection<String> getAllHeaders(){
		return headers.values();
	}

	public String getBody(){
		return body;
	}

}

