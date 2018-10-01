package producerConsumer6;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Implementing conumer producer
 * This is a polling mechanism since the consumer keeps checking if anything put into queue
 * We can do better by wait notify
 */
public class Producerconsumer {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	public void main() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {		}
	}
	
	private void producer() throws InterruptedException {
		Random rand = new Random();
		while(true) {
			queue.put(rand.nextInt(100));
		}
	}
	
	private void consumer() throws InterruptedException {
		Random rand = new Random();
		while(true) {
			Thread.sleep(100);
			if(rand.nextInt(10) == 0) {
				int val = queue.take();
				System.out.println("Value taken from queue = " + val + "; size = " + queue.size());
			}
		}
	}
	
}
