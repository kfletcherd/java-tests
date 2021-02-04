package test.server;

import java.util.HashMap;

final class Response {

	private int code;
	private StringBuilder body;
	private HashMap<String, String> headers;

	public Response(){
		body = new StringBuilder(256);
		headers = new HashMap<>();

		setCode(200);
		setHeader("Content-Type", "application/json");
	}

	public void setCode(int code){
		this.code = code;
	}

	public void setHeader(String key, String val){
		headers.put(key, val);
	}

	public void setBody(String body){
		this.body = new StringBuilder(body);
	}

	public void appendBody(String body){
		this.body.append(body);
	}

	public String getResponse(){
		return new StringBuilder()
			.append("HTTP/1.1 ")
			.append(code)
			.append(" Done\r\n")
			.append(getRawHeaders())
			.append("\r\n")
			.append(body.toString())
			.toString();
	}

	private String getRawHeaders(){
		StringBuilder rawHeader = new StringBuilder(256);

		for(String key : headers.keySet()){
			rawHeader
				.append(key)
				.append(": ")
				.append(headers.get(key))
				.append("\r\n");
		}

		rawHeader
			.append("Content-Length: ")
			.append(body.length())
			//.append(body.length() * Character.BYTES)
			.append("\r\n");

		return rawHeader.toString();

	}

}

