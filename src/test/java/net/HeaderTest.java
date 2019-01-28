package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.net.util.Base64;
import org.junit.Test;

public class HeaderTest {

	@Test
	public void testHeader() throws Exception {
		StringBuilder data = new StringBuilder();
		String urlstr = "http://10.83.36.91:9014";
		String user = "user";
		String password = "password";
		String code = "utf-8";
		URL url = new URL(urlstr);
		int counts = 0;
		while (true) {
			try {
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				String authString = user + ":" + password;
				// System.out.println("auth string: " + authString);
				byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
				String authStringEnc = new String(authEncBytes);
				// 设置header
				connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
				// System.out.println("Base64 encoded auth string: " +
				// authStringEnc);
				connection.setRequestProperty("User-Agent", "MSIE 7.0");
				// 设置参数，是怎么设置的
				connection.setRequestProperty("hello", "world");
				connection.setConnectTimeout(5000);
				InputStream inputStream = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, code));
				String line = null;
				while ((line = br.readLine()) != null) {
					data.append(line);
					data.append("\r\n");
				}
				connection.disconnect();
				break;
			} catch (ConnectException e) {
				if (counts >= 5) {
					System.out.println(urlstr + " : " + e.toString());
					// e.printStackTrace();
				}
				counts++;
				System.out.println("再次尝试");
				continue;
			} catch (Exception e) {
				if (counts >= 5) {
					System.out.println(urlstr + " : " + e.toString());
					// e.printStackTrace();
				}
				counts++;
				System.out.println("再次尝试");
				continue;
			}
		}
	}
}
