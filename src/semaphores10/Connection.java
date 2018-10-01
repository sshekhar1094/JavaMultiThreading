package semaphores10;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance = new Connection();
	private int connections = 0;
	
	//Each call to connect makes a connection
	// now suppose we want to limit the no of connections made
	// we make a semaphore with permit size of 10, each connection has to acquire a semaphore before making a connection
	private Semaphore sem = new Semaphore(10);
	
	private Connection() {	//Singletone
		
	}
	
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		synchronized (this) {
			connections++;
			System.out.println("No of connections = " + connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {		}
		
		//while exiting decrement connections
		synchronized (this) {
			connections--;
		}
		
		sem.release();
	}
}
