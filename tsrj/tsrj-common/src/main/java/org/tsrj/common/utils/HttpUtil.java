package org.tsrj.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.http.HttpRequest;
import org.tsrj.common.http.HttpResponse;
import org.tsrj.common.http.HttpTools;
import org.tsrj.common.http.Method;

/**
 * 基于 httpclient 的 http工具类
 *
 */
public class HttpUtil {

	private static final CloseableHttpClient httpClient;
	public static final String CHARSET = "UTF-8";
	private static  Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	static {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(20000)
				.setSocketTimeout(20000).build();
		httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config)
				.build();
	}


	public static String doGet(String url, Map<String, String> params) {
		return doGet(url, params, CHARSET);
	}

	public static String doPost(String url, Map<String, String> params) {
		return doPost(url, params, CHARSET);
	}

	/**
	 * HTTP Get 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	public static String doGet(String url, Map<String, String> params,
			String charset) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		try {
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(
						params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
				url += "?"
						+ EntityUtils.toString(new UrlEncodedFormEntity(pairs,
								charset));
			}
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpGet.abort();
				throw new RuntimeException("HttpClient,error status code :"
						+ statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			return result;
		} catch (Exception e) {
			logger.error("http get error",e);
		}
		return null;
	}

	/**
	 * HTTP Post 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	public static String doPost(String url, Map<String, String> params,
			String charset) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
			}
			HttpPost httpPost = new HttpPost(url);
			if (pairs != null && pairs.size() > 0) {
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
			}
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :"
						+ statusCode);
			}
			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();
			return result;
		} catch (Exception e) {
			logger.error("http doPost error",e);
		}
		return null;
	}

	public static void main(String[] args) {
		String getData = doGet("http://www.oschina.net/", null);
		System.out.println(getData);
		System.out.println("----------------------分割线-----------------------");
		String postData = doPost("http://www.oschina.net/", null);
		System.out.println(postData);
	}

	/**
	 * http post 带文件
	 * @param url
	 * @param params
	 * @param fileName
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static String doPostFile(String url, Map<String, String> params, String fileName, String filePath) throws Exception {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		try {
			HttpRequest request = new HttpRequest(url);
			request.setMethod(Method.POST);
			StringBuffer paramBuffer = new StringBuffer();
			for (Map.Entry<String, String> m : params.entrySet())  {
				request.addParam(m.getKey(), m.getValue());
				if(StringUtils.isBlank(paramBuffer.toString()))
					paramBuffer.append(m.getKey() + "=" + m.getValue());
				else
					paramBuffer.append("&" + m.getKey() + "=" + m.getValue());
			}
			request.addFile(fileName, new File(filePath));
			HttpResponse response = request.exeute();
			String retStr = HttpTools.getString(response);
			logger.debug("http post url=>{},param=>{},returnCode{}", url, paramBuffer.toString(), retStr);
			return retStr;
		} catch (Exception e) {
			logger.error("http doPost error",e);
		}
		return null;
	}
}
