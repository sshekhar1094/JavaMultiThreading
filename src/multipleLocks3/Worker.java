package multipleLocks3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * @author s0s01gz
 * Had we used one lock, if t1 is running stg1, t2 will have to wait even if it wants to run stg2 bcz t1 has aquired the lock on the object
 * 
 */
public class Worker {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	Random rand = new Random();
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	
	public void stage1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(rand.nextInt(100));
		}
	}
	
	public void stage2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(rand.nextInt(100));
		}
	}
	
	public void process() {
		for(int i=0; i<1000; i++) {
			stage1();
			stage2();
		}
	}
	
	public void main() {
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken = " + (end-start));
		System.out.println("list1 = " + list1.size() + "; list2 = " + list2.size());
	}
}
