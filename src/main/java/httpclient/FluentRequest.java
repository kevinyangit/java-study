package httpclient;

import java.io.IOException;

import org.apache.http.client.fluent.Request;

public class FluentRequest {
	public static String get(String url) {
		String result = "";
		try {
			result = Request.Get(url).connectTimeout(1000).socketTimeout(1000).execute().returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(get("https://www.baidu.com/"));
	}
}
