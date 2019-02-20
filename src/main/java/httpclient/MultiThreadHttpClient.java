package httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

/**同步多线程发请求
 * @author guangfeng.yang
 *
 */
public class MultiThreadHttpClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		PoolingHttpClientConnectionManager sm = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(sm).build();
		String[] urls = { "https://www.baidu.com", "http://10.40.1.38:8089/show/index/", "http://www.baidu.com",
				"http://www.baidu.com" };
		GetThread[] threads = new GetThread[urls.length];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new GetThread(httpClient, urls[i]);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (GetThread getThread : threads) {
			try {
				getThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class GetThread extends Thread {

	private HttpClient httpClient;
	private HttpContext httpContext;
	private String url;

	public GetThread(HttpClient httpClient, String url) {
		super();
		this.httpClient = httpClient;
		this.url = url;
		httpContext = HttpClientContext.create();
	}

	@Override
	public void run() {
		HttpGet httpGet = new HttpGet(url);
		try {
			CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(httpGet, httpContext);
			HttpEntity entity = response.getEntity();
			System.out.println("网页的长度" + entity.getContentLength());
			response.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}
}
