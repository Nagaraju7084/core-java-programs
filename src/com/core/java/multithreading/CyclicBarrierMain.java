package com.core.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//cyclicbarrier
		int numberOfServices = 3;
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
		CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
		executorService.submit(new WorkerService(barrier));
		executorService.submit(new WorkerService(barrier));
		executorService.submit(new WorkerService(barrier));
		
		System.out.println("main..."); //main should not wait here to complete all the worker threads job because all threads to reach certain point for the execution
		executorService.shutdown();
	}

}

class WorkerService implements Callable<String> {

	private final CyclicBarrier barrier;
	
	public WorkerService(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " service started...");
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName() + " is waiting at the barrier ");
		barrier.await(); //wait until all threads reached to certain point
		return "ok";
	}
	
}
