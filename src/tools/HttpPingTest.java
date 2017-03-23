package tools;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class HttpPingTest {
	
	public static boolean speedPing(String host) throws Exception {
		// TODO isReachable?
		boolean	flag = InetAddress.getByName(host).isReachable(2000);
		
		return flag;
	}
	
	public static boolean headPing(String url) throws Exception {
		//TODO HTTP-METHOD : HEAD
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setConnectTimeout(1000);
		conn.setReadTimeout(1000);
		conn.setRequestMethod("HEAD");
		int responseCode = conn.getResponseCode();
		
		return (200<=responseCode && responseCode<=399);
	}
	
	public static boolean getPing(String url) throws Exception {
		// TODO HTTP-METHOD : GET
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setConnectTimeout(1000);
		conn.setReadTimeout(1000);
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();
		
		return (200<=responseCode && responseCode<=399);
	}

	
	/**
	 * Testing ALL Methods..
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		if(speedPing("www.kisia.or.kr")) {
			System.out.println("개빠름?");
		}
		
		if(getPing("https://www.google.co.kr")) {
			System.out.println("GET: 정상 응답 ");
		}
		
		if(headPing("http://www.google.co.kr")) {
			System.out.println("HEAD: 정상 응답");
		}
	}

}
