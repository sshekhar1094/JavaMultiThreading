package lolLevelProducerConsumer8;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<>();
	private Object lock = new Object();
	private int Limit = 10;			// the size limit of our list
	
	public  void produce() throws InterruptedException {
		int val=0;
		while(true) {
			synchronized (lock) {
				// while size is limit, wait
				while(list.size() == Limit) {
					lock.wait();
				}
				
				list.add(val++);
				lock.notify(); 		// notify the consumer that now the list has value
			}
		}
	}
	
	public void consume() throws InterruptedException {
		int val;
		Random rand = new Random();
		
		while(true) {
			synchronized (lock) {
				while(list.size() == 0) {
					lock.wait(); 	// wait until there is a value in list
				}
				
				System.out.print("List size is: " + list.size());
				val = list.removeFirst();
				System.out.println(" ; valus is " + val);
				lock.notify();		//notify producer that it can now add values
			}
			
			Thread.sleep(rand.nextInt(1000));
		}		
	}
	
}
