package semaphores10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
	
	public void main() {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0; i<200; i++) {
			executor.submit(new Runnable() {
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {		}
	}
	
}
