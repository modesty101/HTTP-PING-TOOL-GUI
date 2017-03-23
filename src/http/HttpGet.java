package http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {

	public static long useHttpGet(String url) {
		try {
			url = url.replaceFirst("^https", "http");
			final URL link = new URL("http://" + url);
			HttpURLConnection con = (HttpURLConnection) link.openConnection();
			HttpURLConnection.setFollowRedirects(false);

			con.setRequestMethod("GET");
			con.setConnectTimeout(1000);
			con.setReadTimeout(1000);

			final long startTime = System.currentTimeMillis();
			con.connect();
			final long endTime = System.currentTimeMillis();

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {

				return endTime - startTime;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
