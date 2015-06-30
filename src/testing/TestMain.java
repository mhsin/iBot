package testing;

import java.io.IOException;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ui.UI;
import bot.HttpHelper;

public class TestMain {

	public static void main(String[] args) throws IOException {

//		Availability ga = new Availability();
//		ga.createIrAvailJson();
		
		HttpHelper client = new HttpHelper();
		Map<String, String> params = new HashMap<String, String>();
		
		UI ui = new UI();
		
//	    params.put("channel", "1");
//	    params.put("partNumber", "MJ2T2ZP/A");
//	    params.put("returnURL", "http%3A%2F%2Fstore.apple.com%2Fhk%2Fbuy-watch%2Fapple-watch-sport%3FpreSelect%3Dtrue%26product%3DMJ2T2ZP%2FA%26step%3Ddetail");
//	    params.put("store", "R409");
//	    params.put("eventId", "next");
	    
	    params.put("channel", "1");
	    params.put("partNumber", "MJ2T2LL/A");
	    params.put("returnURL", "http%3A%2F%2Fstore.apple.com%2Fhk%2Fbuy-watch%2Fapple-watch-sport%3FpreSelect%3Dtrue%26product%3DMJ2T2ZP%2FA%26step%3Ddetail");
	    params.put("store", "R102");
	    params.put("eventId", "next");
	    
//		LogIn logIn = new LogIn(client);
////		logIn.getSms("HI");
//		logIn.prepareLogInPage(params);
//		logIn.getCaptcha();
		
		 CookieStore cookieStore = client.cookieManager.getCookieStore();

	        List<HttpCookie> cookieList = cookieStore.getCookies();

//
//			for (HttpCookie cookie : cookieList){
//				// gets domain set for the cookie
//
//				System.out.println("Domain: " + cookie.getDomain());
//
//				// gets max age of the cookie
//				System.out.println("max age: " + cookie.getMaxAge());
//
//				// gets name cookie
//
//				System.out.println("name of cookie: " + cookie.getName());
//
//				// gets path of the server
//
//				System.out.println("server path: " + cookie.getPath());
//				// gets boolean if cookie is being sent with secure protocol
//
//				System.out.println("is cookie secure: " + cookie.getSecure());
//
//				// gets the value of the cookie
//
//				System.out.println("value of cookie: " + cookie.getValue());
//
//			}


	}
}
