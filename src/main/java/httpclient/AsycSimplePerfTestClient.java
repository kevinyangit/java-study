package httpclient;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;

/**异步压测工具
 * @author guangfeng.yang
 *
 */
public class AsycSimplePerfTestClient implements Runnable {
	
	private static int requestRunTime = 0;
	private static CloseableHttpAsyncClient httpclient = null;
	
	public AsycSimplePerfTestClient(int runTime) {
		// TODO Auto-generated constructor stub
		requestRunTime = runTime;
	}
	
	static{
		try {
			RequestConfig requestConfig = RequestConfig.custom()
		            .setSocketTimeout(30000)
		            .setConnectTimeout(30000)
		            .build();
			
			ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
	        PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(ioReactor);
	        connManager.setMaxTotal(500);
	        connManager.setDefaultMaxPerRoute(500);
	        
		    httpclient = HttpAsyncClients.custom().setConnectionManager(connManager)
		        .setDefaultRequestConfig(requestConfig)
		        .build();
		    System.out.println("建立客户端");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void doGetRequest(int runTime) throws InterruptedException, ExecutionException, IOException {
		
	    try {
	        httpclient.start();
	        final HttpGet request = new HttpGet("http://m.kaola.com");
	        final CountDownLatch latch = new CountDownLatch(runTime);
	        for(int i = 0; i < runTime; i++){
		        httpclient.execute(request, new FutureCallback<HttpResponse>() {
	
		            public void completed(final HttpResponse response) {
		                latch.countDown();
//		                System.out.println(request.getRequestLine() + "->" + response.getStatusLine());
		            }
	
		            public void failed(final Exception ex) {
		                latch.countDown();
		                ex.printStackTrace();
		            }
	
		            public void cancelled() {
		                latch.countDown();
		                System.out.println(request.getRequestLine() + " cancelled");
		            }
	
		        });
	        }
	        latch.await();
	        System.out.println("Shutting down");
	    } finally {
	        httpclient.close();
	    }
	    System.out.println("Done");
	}
	
	public void run() {
		try {
			doGetRequest(requestRunTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void main(String[] args) {
		int threadNum = 10;
		int runTime = 1000;
		//10个线程，每个执行1000次来访问这个地址
		for(int i = 0; i < threadNum; i++ ){
			new Thread(new AsycSimplePerfTestClient(runTime)).start();
		}
	}
}