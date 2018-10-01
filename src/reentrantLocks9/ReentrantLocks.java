package reentrantLocks9;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
	
	private int count = 0;
	private ReentrantLock lock = new ReentrantLock();
	
	private void increment() {
		for(int i=0; i<10000; i++) {
			count++;
		}
	}

	private void firstThread() {
		lock.lock();
		increment();
		lock.unlock();
	}
	
	private void secondThread() {
		lock.lock();
		increment();
		lock.unlock();
	}
	
	private void finished() {
		System.out.println("Count = " + count);
	}
	
	public void main() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				firstThread();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				secondThread();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finished();
	}
	
}
