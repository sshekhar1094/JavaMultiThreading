package demo1;

class RunnerAgain implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Hello" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ImplementRunnable {
	public void mainFunc() {
		Thread t1 = new Thread(new RunnerAgain());
		Thread t2 = new Thread(new RunnerAgain());
		
		t1.start();
		t2.start();
	}
}
