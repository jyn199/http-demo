package com.jyn.http_demo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.jyn.http_demo.model.TreesModel;

/**
 * Hello world!
 * 
 */
public class QunarItTest {

	// BATE
	public static final String BATE_TREE_URL = "http://l-backyard1.ops.beta.cn0.qunar.com:10050/api/employees/?require=tree";

	private static HttpClientContext context;

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		context = HttpClientContext.create();
		
		String tree_url = BATE_TREE_URL;
		get(tree_url);
	}

	private static void post(String url) throws ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		HttpPost post = null;
		CloseableHttpClient client = HttpClients.createDefault();
		post = new HttpPost(url);
		response = client.execute(post, context);
		if (response.getStatusLine().getStatusCode() == 200) {
			String result = EntityUtils.toString(response.getEntity());
			System.out.println("返回的结果=====" + result);
		} else {
		}
		client.close();
	}

	private static void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		HttpGet get = null;
		CloseableHttpClient client = HttpClients.createDefault();
		get = new HttpGet(url);
		response = client.execute(get, context);
		if (response.getStatusLine().getStatusCode() == 200) {
			String result = EntityUtils.toString(response.getEntity());
			TreesModel r = JSONObject.parseObject(result, TreesModel.class);
			System.out.println("返回的结果=====" + r.getMsg());
		} else {
		}
		client.close();
	}

}
