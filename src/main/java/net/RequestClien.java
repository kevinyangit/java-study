package net;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class RequestClien {

	public void parseRequest() {
		InputStream inputStream = null;
		LineNumberReader br = new LineNumberReader(new InputStreamReader(inputStream));
		StringBuffer sb = new StringBuffer();
		String str = null;
		try {
			// 读取请求行
			String requestLine = br.readLine();
			String method = null;
			if (!StringUtils.isEmpty(requestLine)) {
				sb.append(requestLine);
				String[] reqs = requestLine.split(" ");
				if (reqs != null && reqs.length > 0) {
					if ("GET".equals(reqs[0])) {
						method = "GET";
					} else {
						method = "POST";
					}
				}
			}
			HashMap<String, String> headers = new HashMap<String, String>();
			// 读取请求头
			while ((str = br.readLine()) != null) {
				if ("".equals(str)) {
					break;
				}
				if (!StringUtils.isEmpty(str)) {
					if (str.indexOf(":") > 0) {
						String[] strs = str.split(":");
						headers.put(strs[0].toLowerCase(), strs[1].trim());
					}
				}
				sb.append(str).append("\n");
			}
			// POST请求，Content-type为 multipart/form-data
			String contentType = null;
			HashMap<String, String> parameters = new HashMap<String, String>();
			if ("POST".equals(method) && ((contentType = headers.get("content-type")) != null
					&& headers.get("content-type").startsWith("multipart/form-data"))) {
				// 文件上传的分割位 这里只处理单个文件的上传
				String boundary = contentType.substring(contentType.indexOf("boundary") + "boundary=".length());
				// 解析消息体
				while ((str = br.readLine()) != null) {
					// 解析结束的标记
					do {
						// 读取boundary中的内容
						// 读取Content-Disposition
						str = br.readLine();
						// 说明是文件上传
						if (str.indexOf("Content-Disposition:") >= 0 && str.indexOf("filename") > 0) {
							str = str.substring("Content-Disposition:".length());
							String[] strs = str.split(";");
							String fileName = strs[strs.length - 1].replace("\"", "").split("=")[1];
							System.out.println("fileName = " + fileName);
							// 这一行是Content-Type
							br.readLine();
							// 这一行是换行
							br.readLine();
							// 正式去读文件的内容
							BufferedWriter bw = null;
							try {
								//TODO:应该是输入
								bw = new BufferedWriter(new OutputStreamWriter(
										new FileOutputStream("G:\\LearnVideo\\fileLoad" + File.separator + fileName),
										"UTF-8"));
								while (true) {
									str = br.readLine();
									if (str.startsWith("--" + boundary)) {
										break;
									}
									bw.write(str);
									bw.newLine();
								}
								bw.flush();
							} catch (Exception e) {

							} finally {
								if (bw != null) {
									bw.close();
								}
							}
						}
						if (str.indexOf("Content-Disposition:") >= 0) {
							str = str.substring("Content-Disposition:".length());
							String[] strs = str.split(";");
							String name = strs[strs.length - 1].replace("\"", "").split("=")[1];
							br.readLine();
							StringBuilder stringBuilder = new StringBuilder();
							while (true) {
								str = br.readLine();
								if (str.startsWith("--" + boundary)) {
									break;
								}
								stringBuilder.append(str);
							}
							parameters.put(name, stringBuilder.toString());
						}
					} while (("--" + boundary).equals(str));
					// 解析结束
					if (str.equals("--" + boundary + "--")) {
						break;
					}
				}
			}
			// System.out.println(sb.toString());
			// 获取URI
			// String uri = StringUtils.parserUri(sb.toString(), " ");
			// TODO:有问题
			String uri = StringUtils.substring(sb.toString(), 1);
			int flag = -1;
			// 说明有参数
			if ((flag = uri.indexOf('?')) >= 0) {
				String oldUri = uri;
				uri = uri.substring(0, flag);
				String parameterPath = oldUri.substring(flag + 1);
				String[] parameter = parameterPath.split("&");
				if (parameter != null && parameter.length > 0) {
					for (int i = 0; i < parameter.length; i++) {
						String str1 = parameter[i];
						if ((flag = str1.indexOf('=')) >= 0) {
							String key = str1.substring(0, flag);
							String value = str1.substring(flag + 1);
							parameters.put(key, value);
						} else {
							parameters.put(str, null);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
