package http.simple.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpRequest {

	private String method, version, requestURI;
	private URI uri;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRequestURI() {
		return uri.getPath();
	}

	public String getRequestURL() {
		return uri.getScheme() + uri.getPath();
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	//请求报文格式get的方法
	//get url http/1.0 crlf
	//crl
	public void read(HttpInputStream in) {
		String[] tokens;
		String line, request;
		try {
			line = in.readHttpLine();
			tokens = line.split("\\s");
			this.method = tokens[0];
			request = tokens[1];
			if(tokens.length > 2) version = tokens[2];
			else version = "HTTP/0.9";
			
			tokens = request.split("?");//parameter first one
			this.requestURI = tokens[0].substring(1);
			//this.requestURI = tokens[0];//实际有 问题的
			uri = new URI(requestURI);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
	@Override
	public String toString() {
		return "HttpRequest [method=" + method + ", version=" + version + ", requestURI=" + requestURI + ", uri=" + uri
				+ "]";
	}
}
