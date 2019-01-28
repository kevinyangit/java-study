package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class URLTest {

	@Test
	public void test() {
		try {
			System.out.println("url");
			URL url = new URL("http://www.baidu.com");
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile();
			String path = url.getPath();
			String query = url.getQuery();
			String authority = url.getAuthority();
			System.out.println("url");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
		@Test
		public void testMulti() {
			try {
				System.out.println("url");
				 URL baidu =new URL("http://www.baidu.com");
				URL url =new URL(baidu,"/aa/index.html?username=tom#test");//？表示参数，#表示锚点
				String protocol = url.getProtocol();
				String host = url.getHost();
				int port = url.getPort();
				String file = url.getFile();
				String path = url.getPath();
				String query = url.getQuery();
				String ref = url.getRef();//相对路径，就是锚点，即#号后面的内容
				String authority = url.getAuthority();
				System.out.println("url");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	}
		@Test
		public void testConnection() throws IOException {
			for (int i = 0; i < 10; i++) {
				try {
					URL url = new URL("http://10.83.36.91:9014");
					
					url.openConnection();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		@Test
		public void testOpenStream()  {
			URL url;
			try {
				for (int i = 0; i < 10; i++) {
					url = new URL("http://10.83.36.91:9014");
					InputStream openStream = url.openStream();
					InputStreamReader inputStreamReader = new InputStreamReader(openStream, "utf-8");
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					String readLine = bufferedReader.readLine();
					while (null != readLine) {
						System.out.println(readLine);
						readLine = bufferedReader.readLine();
					}
					openStream.close();
					inputStreamReader.close();
					bufferedReader.close();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}

		}
		
		@Test
		public void testStream2Byte() throws Exception {
			URL url = new URL("http://10.83.36.91:9014");
			InputStream openStream = url.openStream();
			byte[] b = new byte[1024];
			
			StringBuilder sb= new StringBuilder();
			while ( -1 != openStream.read(b)) {
				String string = new String(b, "utf-8");
				sb.append(string);
			}
			System.out.println(sb);
		}

}
