package com.core.java.multithreading;

public class SynchronizationUsage {
	public static void main(String[] args) {
		Counter counter = new Counter(); //shared object meaning threads are sharing this object/resource
		MyThread t1 = new MyThread(counter);
		MyThread t2 = new MyThread(counter);
		//here t1 and t2 are two threads are sharing the same resource/object i.e. counter
		t1.start();
		t2.start();
		try {
			t1.join(); //main,t1 should wait until completion of t1
			t2.join(); //main should wait until completion of t2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(counter.getCounter()); //now we will get actual value i.e. 2000
		//how many times we will execute this program those many times get the same result because
		//the incrementCounter method in Counter class is synchronized
	}
}

class MyThread extends Thread {
	
	private Counter counter;
	
	MyThread(Counter counter){
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			counter.incrementCounter(); //now we will get consistent values
		}
	}
}

class Counter {
	
	private int counter = 0;
	
	//with synchronization
	public synchronized void incrementCounter() { //only one thread is allowed to call/operate this method at a time
		counter++;
	}
	
	public int getCounter() {
		return counter;
	}
}
