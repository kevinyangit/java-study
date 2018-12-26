package http.simple.server;

import java.net.URI;

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
	

	public <HttpInputStream> void read(HttpInputStream in){
		
	}
}
