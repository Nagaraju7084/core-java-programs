package com.core.java.multithreading;

public class VolatileAtomicMain {

	public static void main(String[] args) throws InterruptedException {
		
//		SharedObject sharedObject = new SharedObject();
//		
//		Thread writerThread = new Thread(() -> {
//			try {
//				Thread.sleep(1000); //line 1 : writer thread should sleep for 1 second as reader thread should enter into loop as line 2 
//			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
//			}
//			sharedObject.setFlagTrue();
//		});
//		Thread readerThread = new Thread(() -> sharedObject.printIfFlagTrue());
//		
//		writerThread.start();
//		readerThread.start();
		
		VolatileCounter volatileCounter = new VolatileCounter();
		Thread writerThread1 = new Thread(() -> {
					for(int i=0; i<1000; i++) {
						volatileCounter.incrementCounter();
					}
				});
		Thread writerThread2 = new Thread(() -> {
			for(int i=0; i<1000; i++) {
				volatileCounter.incrementCounter();
			}
		});
		
		writerThread1.start();
		writerThread2.start();
		writerThread1.join();
		writerThread2.join();
		
		System.out.println(volatileCounter.getCounter());
	}

}

class SharedObject {
	
	//private boolean flag = false; //shared value one thread is updating the other thread is reading
	private volatile boolean flag = false; //if we make it volatile the updated value is reflect for all threads i.e. state is same for all threads
	
	//writer
	public void setFlagTrue() {
		System.out.println("writer thread made the falg as true...");
		flag = true;
	}

	//reader
	public void printIfFlagTrue() {
		while(!flag) { //line 2 : reader thread will enter into loop when line 1 writer thread will pause its execution for one second
			//do nothing
		}
		System.out.println("reader thread reading the flag..."); //line 3 : after one second, writer thread update the flag as true but reader thread will not read the update value, it doesn't know the updated state of the falg
		//because the flag variable is from ram but each thread will maintain its own local cache i.e. reader thread will maintain its own local memory for flag and the values is false i.e. before writer thread execution
		//reader thread will execute and read the flag value and store it into its local cache i.e. false
		//after, the flag value is updated by the writer thread is not available to the reader thread
		//the updated flag value not reflect to the reader thread rather the value reflect on ram memory
	}
}

class VolatileCounter {
	
	private volatile int counter = 0; //here, volatile is not working because volatile will reflect the state of the object or value of the variable to the other threads but here, problem is different multiple threads accessing counter variable
	
	public void incrementCounter() {
		counter++;
	}
	
	public int getCounter() {
		return counter;
	}
	
}
