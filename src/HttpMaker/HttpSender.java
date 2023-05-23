package HttpMaker;

import java.util.List;
import java.util.Scanner;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;

public class HttpSender {

	public HttpSender() {
		super();
	}

	public ContentResponse httpClientGet(String targetUrl) {
		
		HttpClient httpClient = new HttpClient();
		
		try {
			httpClient.start();
			
			Request request = httpClient.newRequest(targetUrl).method("GET");
			ContentResponse response = request.send();
			
			System.out.println(response.getContentAsString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ContentResponse httpClientPost(String targetUrl, String bodyData) {
		
		HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			
			Request request = httpClient.newRequest(targetUrl).method("POST");
			request.header("Content-Type", "application/json");
			request.content(new StringContentProvider(bodyData));
			
			ContentResponse response = request.send();
			
			System.out.println(response.getContentAsString());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
