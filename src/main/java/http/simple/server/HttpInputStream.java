package http.simple.server;

import java.io.IOException;
import java.io.InputStream;

public class HttpInputStream {
	InputStream in;

	public HttpInputStream(InputStream in) {
		super();
		this.in = in;
	}

	public String readHttpLine() throws IOException{

		return null;
	}
}
