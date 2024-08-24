package com.core.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ManualThreadsCreationMain {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		//Thread[] threads = new Thread[9]; //here 9 locations for 9 threads creation
		ExecutorService executorService = Executors.newFixedThreadPool(3); //here we are creating only 3 threads those are reusing to achieve the task
		for(int i=1; i<10; i++) {
			int finalI = i;
			//threads[i-1] = new Thread( //threads are creating manually one by one and not reusing here
			executorService.submit(()->{
						long result = factorial(finalI);
						System.out.println(result);
					});
		}
		
		executorService.shutdown(); //if not shutdown, it will keep on using
		try {
			executorService.awaitTermination(100, TimeUnit.SECONDS); //main should not wait if not write this statement 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("total time taken for execution : " + (System.currentTimeMillis() - startTime)); //this line will execute first if we don't call awaitTermination method on executerService 
	}
	
	private static long factorial(int n) { //factorial logic
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}

}
