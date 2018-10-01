package waitNotify7;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer running...");
			wait();					// release the lock and wait
			System.out.println("Producer resumed...");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for you to hit enter");
			scanner.nextLine();
			System.out.println("Return key pressed");
			notify();				// ntify the waitign thread
			Thread.sleep(5000); 		// now wait for 5s before releasing the lock
		}
	}
}
