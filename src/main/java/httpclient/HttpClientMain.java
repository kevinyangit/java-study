package httpclient;

import java.util.HashMap;

import cn.hutool.http.HttpUtil;

public class HttpClientMain {

	public static void main(String[] args) {
		String url = "http://218.17.36.89:81/bqjr/wage/login.action";
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("no", "北京");
		String result= HttpUtil.post(url, paramMap);
		System.out.println(result);
	}
}
