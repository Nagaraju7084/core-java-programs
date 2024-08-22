package com.core.java;

public class SynchronizationUsage {
	public static void main(String[] args) {
		Counter counter = new Counter(); //shared object meaning threads are sharing this object/resource
		MyThread t1 = new MyThread(counter);
		MyThread t2 = new MyThread(counter);
		//here t1 and t2 are two threads are sharing the same resource/object i.e. counter
		//due to this, we will get inconsistent value
		t1.start();
		t2.start();
		try {
			t1.join(); //main,t1 should wait until completion of t1
			t2.join(); //main should wait until completion of t2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(counter.getCounter()); //we will not get consistent value
		//i.e. at each execution the counter value is different, it is not actual/consistent
		//to overcome this, go for synchronization using synchronized method or synchronized block
	}
}

class MyThread extends Thread {
	
	private Counter counter;
	
	MyThread(Counter counter){
		this.counter = counter;
	}
	
	//without synchronization
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			counter.incrementCounter(); //two threads are calling this so we will get the counter value as 2000 but we won't get because it is sharable
		}
	}
}

class Counter {
	
	private int counter = 0;
	
	public void incrementCounter() {
		counter++;
	}
	
	public int getCounter() {
		return counter;
	}
}
