import countdownlatch5.CountDownLatchExample;
import demo1.AnonymousRunnable;
import demo1.ExtendThread;
import demo1.ImplementRunnable;
import multipleLocks3.Worker;
import reentrantLocks9.ReentrantLocks;
import semaphores10.SemaphoreExample;
import synchronization2.Synchronized2;
import synchronization2.Volatile1;
import threadpool4.ThreadPool;
import waitNotify7.WaitNotify;

/**
 * Java MultiThreading by cave of programming: https://www.youtube.com/playlist?list=PLBB24CFB073F1048E
 *
 */
public class Main {

	public static void main(String[] args) {
		// 1. Basic introduction
		
		// Extending thread
		//new ExtendThread().mainFunc();
		
		//Implementing Runnable
		//new ImplementRunnable().mainFunc();
		
		// Anonymous runnable
		//new AnonymousRunnable().mainFunc();
		
		
		
		// 2,3 Synchronization:
		
		// volatile keyword
		//new Volatile1().mainfunc();
		
		
		// synchronized
		//new Synchronized2().mainFunc();
		
		
		
		// 4. Multiple locks
		//new Worker().main();
		
		
		// 5. Thread pool : executor service
		//new ThreadPool().main();
		
		
		//6. CountDown latch
		//new CountDownLatchExample().main();
		
		
		// 7. Wait n notify
		// new WaitNotify().main();
		
		
		// 8. Reentrant locks
		//new ReentrantLocks().main();
		
		
		//9. Semaphores
		new SemaphoreExample().main();
	}

}
