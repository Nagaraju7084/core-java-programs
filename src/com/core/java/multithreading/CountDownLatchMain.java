package com.core.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//problem without countdownlatch
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<String> future1 = executorService.submit(new DependentService());
		Future<String> future2 = executorService.submit(new DependentService());
		Future<String> future3 = executorService.submit(new DependentService());
		
		future1.get(); //main should wait until complition of future1, future2, future3. here we don't call join method because we are using executor framework
		future2.get(); //problem is here, main should wait until completion of all dependent services
		future3.get(); //here, 3 services we wrote 3 times future.get(), if suppose there are many services are there, if write many times future.get() its not good programming, to resolve this use countdownlatch
		
		System.out.println("all dependent services finished. starting main service");
		executorService.shutdown(); //if don't call this, keep on executing, so after completion of tasks, it should be call
		
	}

}

class DependentService implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " service started...");
		Thread.sleep(2000);
		return "ok";
	}
	
}
