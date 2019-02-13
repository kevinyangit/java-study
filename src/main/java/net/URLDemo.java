package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) {
//		String str = "http://218.17.36.89/bqjr/wage/login.jsp";
		String str = "http://www.51gjie.com/java/782.html";
		try {
			URL url = new URL(str);
			URLConnection openConnection = url.openConnection();
			openConnection.connect();
			InputStream inputStream = openConnection.getInputStream();
			byte[] b = new byte[1024];
			while (inputStream.read(b) != -1) {
				String string = new String(b);
				System.out.println(string);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
