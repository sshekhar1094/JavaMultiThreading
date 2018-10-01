package synchronization2;

import java.util.Scanner;

/**
 * JVM might think ki we are never changing the value of runnign, so why not cache it
 * volatile makes sure that it is not cached
 */
class Processor extends Thread{
	
	private volatile boolean running = false;		// to ensure value of thsi 
	
	public void run() {
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		this.running = false;
	}
}

public class Volatile1 {
	public void mainfunc() {
		Processor proc = new Processor();
		proc.start();
		
		System.out.println("Enter return to end");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();		// will wait for user to enter return
		
		proc.shutdown();
		scan.close();
	}
}
