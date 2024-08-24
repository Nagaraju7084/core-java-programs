package com.core.java;

public class ManualThreadsCreationMain {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i=1; i<10; i++) {
			//now using multi threading
			int finalI = i;
			Thread thread = new Thread(
					()->{
						long result = factorial(finalI);
						System.out.println(result);
					}
				);
			thread.start(); //here, one thread is created along with main thread
		}
		System.out.println("total time taken for execution : " + (System.currentTimeMillis() - startTime)); //main is not waiting because we won't call join method on thread so we got incorrect result
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
