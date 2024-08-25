package com.core.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//with countdownlatch
		int numberOfServices = 3;
		
		CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
		for(int i=0; i<numberOfServices; i++) {
			new Thread(new DependentService(countDownLatch)).start();
		}
		countDownLatch.await(); //main should wait until lock release
		
		System.out.println("main...");
	}

}

class DependentService implements Runnable {

	private final CountDownLatch latch;
	
	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " service started...");
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}finally {
			latch.countDown(); //it will decrement for each execution, suppose the count starts with 3, for each iteration it will decrease until 0, once it is 0 then main will execute
		}
	}
	
}
