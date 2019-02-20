package httpclient;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import cn.hutool.core.io.IoUtil;

/**
 * @author guangfeng.yang
 *
 */
public class AsyncSimpleClient {
	public static void main(String[] args) throws Exception {
		 asynRequest();
//		synRequest();
	}

	public static void synRequest() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// Execute 500 request in sync
		for (int i = 0; i < 50; i++) {
			HttpGet request = new HttpGet("http://www.baidu.com");
			request.setHeader("Connection", "close");
			CloseableHttpResponse response = httpclient.execute(request);
			// System.out.println(response.getStatusLine());
			System.out.println(response.getStatusLine());
			;
			response.close();
		}

		httpclient.close();
	}

	/**
	 * 异步可以提升客户端调用的性能，但实际上是以提升并发为代价的，也就是latency和qps的关系
	 * 客户端异步没问题，但服务器端的性能必须跟的上，在我们的系统中，会通过控制batch的数量以及同时并发的mapper数量限制并发，以防止压垮服务器
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws IOException
	 */
	public static void asynRequest() throws InterruptedException, ExecutionException, IOException {
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		// Start the client
		httpclient.start();

		// Execute 100 request in async
		final HttpGet request = new HttpGet("http://www.baidu.com");
		request.setHeader("Connection", "close");
		List<Future<HttpResponse>> respList = new LinkedList<Future<HttpResponse>>();
		for (int i = 0; i < 50; i++) {
			respList.add(httpclient.execute(request, null));
		}

		// Print response code
		for (Future<HttpResponse> response : respList) {
			System.out.println(response.get().getStatusLine());
			 System.out.println(IoUtil.read(response.get().getEntity().getContent()));
		}

		httpclient.close();
	}
}
