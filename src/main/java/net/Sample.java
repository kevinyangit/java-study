package net;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Sample {

	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		@Override
		public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
			HttpEntity entity = response.getEntity();
			return entity != null ? EntityUtils.toString(entity) : null;

		}

	};

	public static String Get(CloseableHttpClient http, String url) {
		HttpGet httpget = new HttpGet(url);

		System.out.println("Executing request " + httpget.getRequestLine());

		String html = "";

		try {
			html = http.execute(httpget, responseHandler);
		} finally {
			return html;
		}
	}

	public static void main(String[] args) throws Exception {
		CloseableHttpClient http = HttpClients.createDefault();
		try {
			Get(http, "http://10.83.36.91:9014/111.txt");
			Get(http, "http://10.83.36.91:9014/222.txt");
			Get(http, "http://10.83.36.91:9014/333.txt");
		} finally {
			http.close();
		}
	}
}