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
		
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
		
		CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
		
		executorService.submit(new DependentService(countDownLatch));
		executorService.submit(new DependentService(countDownLatch));
		executorService.submit(new DependentService(countDownLatch));
		
		countDownLatch.await(); //main should wait until lock release
		
		System.out.println("main...");
		executorService.shutdown(); //if don't call this, keep on executing, so after completion of tasks, it should be call
		
	}

}

class DependentService implements Callable<String> {

	private final CountDownLatch latch;
	
	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public String call() throws Exception {
		try {
			System.out.println(Thread.currentThread().getName() + " service started...");
			Thread.sleep(2000);
		}finally {
			latch.countDown(); //it will decrement for each execution, suppose the count starts with 3, for each iteration it will decrease until 0, once it is 0 then main will execute
		}
		return "ok";
	}
	
}
