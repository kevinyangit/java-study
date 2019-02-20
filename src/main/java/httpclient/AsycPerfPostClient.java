package httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * POST请求分为两种：
参数为JSON（application/json）格式：使用StringEntity对象进行body构造；
参数为form（application/x-www-form-urlencoded）格式：使用NameValuePair进行body构造；
还可以在响应回调FutureCallback对象的completed方法中对响应体的正确性进行断言校验。
 * @author guangfeng.yang
 *
 */
public class AsycPerfPostClient 
{
	/*
	 * method : Post request 
	 * Content-type : application/json
	 */
    public void doPostForJson() throws InterruptedException, ExecutionException
    {
    	CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
    	try {
    	    // Start the client
    	    httpclient.start();

    	    // One most likely would want to use a callback for operation result
    	    final CountDownLatch latch = new CountDownLatch(1);
    	    final HttpPost request = new HttpPost("http://sp.kaola.com/api/cart");
    	    
    	    //construct request header
    	    request.setHeader("Content-type", "application/json; charset=UTF-8");
    	    request.setHeader("appVersion", "3.9.0");
    	    request.setHeader("apiVersion", "207");
    	    request.setHeader("platform", "1");
    	    request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.103 Safari/537.36");
    	    request.setHeader("ursId", "7144239B529794E56E7733F2CAA95A803FAEE9F695EC30637D2D80EC2DB30FCC64C384852ED312E1ECE6E2456B8528581");
    	    request.setHeader("ursToken", "3a8f8d342f56fcfac9a0f9d5168dc189e");
    	    
    	    //construct request body
    	    String JsonParam = "{\"skuId\":\"17752-68a3e5516d7a7dc21fbe0e7ee13bfc1c\",\"isHuanGou\":0,\"goodsId\":\"23430\",\"selected\":1,\"tempBuyAmount\":1,\"innerSource\":\"DETAIL\", \"goodsType\": 0, \"activitySchemeId\": 0}";
    	    
    	    StringEntity entity = new StringEntity(JsonParam);
    	    
    	    request.setEntity(entity);
    	    
    	    httpclient.execute(request, new FutureCallback<HttpResponse>() {

    	        public void completed(final HttpResponse response) {
    	            latch.countDown();
    	            try {
						String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
						if (response.getStatusLine().getStatusCode() != 200 || !responseBody.contains("\"code\":0")) {
							System.out.println(request.getRequestLine() + "-> error:" +  responseBody);
						}else {
							System.out.println(request.getRequestLine() + "-> right:" +  responseBody);
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	        }

    	        public void failed(final Exception ex) {
    	            latch.countDown();
    	            System.out.println(request.getRequestLine() + "->" + ex);
    	        }

    	        public void cancelled() {
    	            latch.countDown();
    	            System.out.println(request.getRequestLine() + " cancelled");
    	        }

    	    });
    	    latch.await();

    	    // In real world one most likely would also want to stream
    	    // request and response body content

    	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
    	    try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
	/*//TODO:
	 * method : Post request ，还可以自己写支持application/json的格式
	 * Content-type : application/x-www-form-urlencoded
	 */
    public void doPostForFrom() throws InterruptedException, ExecutionException
    {
    	CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
    	try {
    	    // Start the client
    	    httpclient.start();

    	    // One most likely would want to use a callback for operation result
    	    final CountDownLatch latch = new CountDownLatch(1);
    	    final HttpPost request = new HttpPost("https://www.kaola.com/cartAjax/modify.html");
    	    
    	    //construct request header
    	    request.setHeader("Content-type", "application/x-www-form-urlencoded");
    	    request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.103 Safari/537.36");
    	    request.setHeader("Cookie", "NTES_SESS=GFPzQP2ESrC7x6FtQRFxFxm_BqVjxTHcbjouDqrgZcQQM6xQ.MSx83AOErZ6..CVNzkl9Gaa6WbbiMymWLDvzLd0_ABLGn3JwQvGjtvLgLCRinMEwLh7cr1VbLC6OwZKDExj4gzPCr.wEdx_8603JN38JXh9AnPs.9QQMwwExAVpfbso6tM7Ad.yIt5RcQheU");
    	    
    	    //construct request body
    	    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    	    nvps.add(new BasicNameValuePair("number", "1"));
    	    nvps.add(new BasicNameValuePair("goodsId", "23430"));
    	    nvps.add(new BasicNameValuePair("skuId", "17752-68a3e5516d7a7dc21fbe0e7ee13bfc1c"));
    	    nvps.add(new BasicNameValuePair("innerSource", "DETAIL"));
    	    
    	    request.setEntity(new UrlEncodedFormEntity(nvps));
    	    
    	    httpclient.execute(request, new FutureCallback<HttpResponse>() {

    	        public void completed(final HttpResponse response) {
    	            latch.countDown();
    	            try {
						String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
						if (response.getStatusLine().getStatusCode() != 200 || !responseBody.contains("\"retcode\":200")) {
							System.out.println(request.getRequestLine() + "-> error:" +  responseBody);
						}else {
							System.out.println(request.getRequestLine() + "-> right:" +  responseBody);
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	        }

    	        public void failed(final Exception ex) {
    	            latch.countDown();
    	            System.out.println(request.getRequestLine() + "->" + ex);
    	        }

    	        public void cancelled() {
    	            latch.countDown();
    	            System.out.println(request.getRequestLine() + " cancelled");
    	        }

    	    });
    	    latch.await();

    	    // In real world one most likely would also want to stream
    	    // request and response body content

    	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
    	    try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
		AsycPerfPostClient asycPerfPostClient = new AsycPerfPostClient();
		asycPerfPostClient.doPostForFrom();
	}
}