package http.simple.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Administrator
 *
 */
public class HttpInputStream {
	InputStream in;

	public HttpInputStream(InputStream in) {
		super();
		this.in = in;
	}

	public String readHttpLine() throws IOException{
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String readLine = bufferedReader.readLine();
		return readLine;
	}
}
