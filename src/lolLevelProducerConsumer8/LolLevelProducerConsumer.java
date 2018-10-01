package lolLevelProducerConsumer8;


public class LolLevelProducerConsumer {
	final Processor proc = new Processor();

	public void main() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					proc.produce();
				} catch (InterruptedException e) {				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					proc.consume();
				} catch (InterruptedException e) {				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
