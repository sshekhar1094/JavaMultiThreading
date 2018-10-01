package synchronization2;

public class Synchronized2 {
	
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public void mainFunc() {
		Synchronized2 obj = new Synchronized2();
		obj.doWork();
	}
	
	private void doWork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					//count++;		// if we do this, since the otehr thraed is also incrementing, result might not be as expected
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					//count++;
					increment();
				}
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
		
		System.out.println("Count = " + count);
	}
}
