package countdownlatch5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{

	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started");
		latch.countDown();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {		}
		System.out.println("Finished");
		
	}
}

public class CountDownLatchExample {
	public void main() {
		CountDownLatch latch = new CountDownLatch(3);  	// wait on 3 threads, each thread will do a countdown
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++) executor.submit(new Processor(latch));
		
		try {
			// will wait for 3 threads to make the latch 0
			latch.await();
		} catch (InterruptedException e) {		}
		
		System.out.println("Done");
		executor.shutdown();
	}
}
