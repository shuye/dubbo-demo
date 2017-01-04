package com.hobay.nocashtransactions.soa.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.hobay.nocash.soa.remote.domain.Hello;
import com.hobay.nocashtransactions.soa.web.Page.Sort;

public class HttpPost {
	static Gson gson = new Gson();
	public static void main(String[] args) throws Exception {
		/*Page<Hello> page = new Page<Hello>();
		page.addParam("username", "shuye");
		page.addParam("category", 1);
		Map<String, Sort> sorts = new HashMap<String, Page.Sort>();
		sorts.put("id", Sort.ASC);
		sorts.put("time", Sort.DESC);
		page.setSorts(sorts);
		System.out.println(gson.toJson(page));*/
		
		Hello hello = new Hello();
		hello.setName("shuye");
		String urlString = "http://localhost:8084/hello/hello";
		String urlString2 = "http://localhost:8084/hello/hello-json";
		httpPostJson(urlString2, hello);
		//httpPostForm(urlString, hello);
	}

	static void httpPostForm(String urlString, Hello hello) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("cookie", "token=34_45758747hdhdg999");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		//connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Type","application/json");
		connection.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream(), "utf-8");
		//out.write(getParam(hello));
        out.write(gson.toJson(hello));
		out.flush();
		out.close();

		// 读取响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String lines;
		StringBuffer sb = new StringBuffer("");
		while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), "utf-8");
			sb.append(lines);
		}
		System.out.println(sb);
		reader.close();
	}

	public static String getParam(Hello hello) throws Exception {
		StringBuffer param = new StringBuffer();
		for (Field key : hello.getClass().getDeclaredFields()) {
			key.setAccessible(true);
			param.append(key.getName()).append("=").append(key.get(hello))
					.append("&");
		}
		return param.substring(0, param.length() - 1);
	}

	static void httpPostJson(String urlString, Hello hello) throws Exception {
		
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("cookie", "token=34_45758747hdhdg999");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		//connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Type","application/json");
		
		connection.connect();

		// POST请求
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());

		out.writeBytes(gson.toJson(hello));
		out.flush();
		out.close();

		// 读取响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String lines;
		StringBuffer sb = new StringBuffer("");
		while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), "utf-8");
			sb.append(lines);
		}
		System.out.println(sb);
		reader.close();
	}

}
