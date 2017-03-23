package http;

import java.net.InetAddress;

public class HttpQuick {

	public static long useHttpQuick(final String url) {
		try {
			final long startTime = System.currentTimeMillis();
			InetAddress.getByName(url).isReachable(1000);
			final long endTime = System.currentTimeMillis();
			return endTime - startTime;
		} catch (Exception e) {
			return -1;
		}
	}
}
