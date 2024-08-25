package com.core.java.multithreading;

public class VolatileAtomicMain {

	public static void main(String[] args) {
		
		SharedObject sharedObject = new SharedObject();
		
		Thread writerThread = new Thread(() -> {
			try {
				Thread.sleep(1000); //line 1 : writer thread should sleep for 1 second as reader thread should enter into loop as line 2 
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			sharedObject.setFlagTrue();
		});
		Thread readerThread = new Thread(() -> sharedObject.printIfFlagTrue());
		
		writerThread.start();
		readerThread.start();
		
	}

}

class SharedObject {
	
	private boolean flag = false;
	
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
		//reader thread will execute and read the flag falue and store it into its local cache i.e. false
		//after, the flag value is updated by the writer thread is not available to the reader thread
		//the updated flag value is in writer's thread local cache value but not reflect to the reader thread or ram memory
	}
}
