package threadpool4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {		}
		System.out.println("Ending: " + id);
	}
}

public class ThreadPool {
	public void main() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++) executor.submit(new Processor(i));
		
		executor.shutdown();  		// thsi will noyt shutdown immediately but will instead wait for all the threads to finish
		
		System.out.println("All tasks submitted");
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {		}
		System.out.println("All tasks finished");
	}

}
