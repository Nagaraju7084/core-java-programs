package com.core.java;

public class ManualThreadsCreationMain {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Thread[] threads = new Thread[9];
		for(int i=1; i<10; i++) {
			//now using multi threading
			int finalI = i;
			threads[i-1] = new Thread(
					()->{
						long result = factorial(finalI);
						System.out.println(result);
					}
				);
			threads[i-1].start(); //10 threads along with main
		}
		
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("total time taken for execution : " + (System.currentTimeMillis() - startTime)); //now main thread should wait until completion of all child threads and now we will get correct result
		//without multi threading the time consumed for the execution is 9 seconds
		//with multi threading  the time consumed for the execution is 1 second
		//this is manual thread creation and execution
	}
	
	private static long factorial(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}

}
