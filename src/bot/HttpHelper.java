package bot;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class HttpHelper {

	private OkHttpClient client;
	public CookieManager cookieManager = new CookieManager();

	public HttpHelper() {

		client = new OkHttpClient();
		client.setFollowSslRedirects(true);

		
		CookieHandler.setDefault(cookieManager);
		cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		client.setCookieHandler(cookieManager);
      

	}

	public String httpGetUrl(String url) {

		Request request = new Request.Builder().url(url).build();
		Response response = null;
		
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			System.err.println("Unable to make GET request.");
		}

		return response.request().urlString();

	}

	public String httpGetBody(String url) {

		Request request = new Request.Builder().url(url).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
			
			return response.body().string();
		} catch (IOException e) {
			System.err.println("Unable to make GET request.");
		}

		return url;
		
	}

	public String httpPost(String url, Map<String, String> params){
		

		FormEncodingBuilder builder = new FormEncodingBuilder();
		for (String key : params.keySet()) {
			builder.add(key, params.get(key));
		}
		RequestBody formBody = builder.build();
		Request request = new Request.Builder()
				.url(url)
				.post(formBody).build();

		Response response;
		try {
			response = client.newCall(request).execute();		
			
			return response.request().urlString();
			
		} catch (IOException e) {
			System.err.println("Unable to make POST request.");
		}
		
		return url;
	}

	public String paramsToString(Map<String, String> params) {

		String result = "";
		for (Map.Entry<String, String> entry : params.entrySet()) {
			result += "&" + entry.getKey() + "=" + entry.getValue();
		}
		return result;

	}

	public Map<String, String> getUrlParamas(String url) {
		String param = url.substring(url.indexOf("?") + 1);
		if (param.indexOf("#") > -1) {
			param = param.substring(0, param.indexOf("#"));
		}
		String paramsStr[] = param.split("&");
		Map<String, String> params = new HashMap<String, String>();
		for (String str : paramsStr) {
			String keyVal[] = str.split("=");
			if (keyVal.length == 2 && keyVal[0].length() > 0
					&& keyVal[1].length() > 0) {
				params.put(keyVal[0], keyVal[1]);
			}
		}

		return params;
	}

}
