package in.k2s.raspberry.garden.control.util;

public class ThreadUtil {
	
	public static void sleep(Long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
