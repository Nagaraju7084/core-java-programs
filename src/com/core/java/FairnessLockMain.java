package com.core.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockMain {

	public static void main(String[] args) {
		FairnessLock fairness = new FairnessLock();
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				fairness.accessResource();
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
	
	private final Lock fairnessLock = new ReentrantLock(true); //with fairness/order now threads will execute sequential order
	//and also each thread will get the chance to acquire the lock compulsory 
	
	public void accessResource() {
		fairnessLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " aquired the lock");
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName() + " released the lock");
			fairnessLock.unlock();
		}
	}
}


