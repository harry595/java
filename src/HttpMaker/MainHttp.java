package HttpMaker;

import org.eclipse.jetty.client.api.ContentResponse;

public class MainHttp {
	
	public static void main(String[] args) {
		
		HttpSender httpSender = new HttpSender();
		ContentResponse res = httpSender.httpClientGet("http://127.0.0.1:8080/queue");
		String resString = res.getContentAsString();
		
	}
}
