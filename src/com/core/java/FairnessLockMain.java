package com.core.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockMain {

	public static void main(String[] args) {
		FairnessLock unfair = new FairnessLock();
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				unfair.accessResource();
			}
		};
		
		Thread t1 = new Thread(task, "thread 1");
		Thread t2 = new Thread(task, "thread 2");
		Thread t3 = new Thread(task, "thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class FairnessLock{
	
	private final Lock unfair = new ReentrantLock(); //without fairness/order i.e. threads will execute random order
	
	public void accessResource() {
		unfair.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " aquired the lock");
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName() + " released the lock");
			unfair.unlock();
		}
	}
}


