package http;

public class HttpPing {
	public static long httpRuntime(final String url) {
		try {
			Runtime time = Runtime.getRuntime();
			final long startTime = System.currentTimeMillis();
			Process proc = time.exec("ping -c 1 " + url);

			int mPingResult = proc.waitFor();
			final long endTime = System.currentTimeMillis();
			if (mPingResult == 0) {
				return endTime - startTime;
			} else {
				return -1;
			}
		} catch (Exception e) {

		}
		return -1;
	}
}
