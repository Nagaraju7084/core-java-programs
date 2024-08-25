package com.core.java.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//cyclicbarrier complex program
		int numberOfSubsystems = 4;
		CyclicBarrier barrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
			
			@Override
			public void run() { //line 2 : this will execute after all threads come together at a certain point / place
				System.out.println("all subsystems are up and running. system startup complete...");
			}
		});
		
		Thread webServerThread = new Thread(new Subsystem("web server", 2000, barrier));
		Thread databaseThread = new Thread(new Subsystem("database", 4000, barrier));
		Thread cacheThread = new Thread(new Subsystem("cache", 3000, barrier));
		Thread messagingServiceThread = new Thread(new Subsystem("messaging service", 3500, barrier));
		
		webServerThread.start();
		databaseThread.start();
		cacheThread.start();
		messagingServiceThread.start();
		
	}

}

class Subsystem implements Runnable {
	
	private String name;
	
	private int intializationTime;

	private final CyclicBarrier barrier;
	
	public Subsystem(String name, int intializationTime, CyclicBarrier barrier) {
		this.name = name;
		this.intializationTime = intializationTime;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + "intialization started...");
			Thread.sleep(intializationTime); //simulate time taken to initialize
			System.out.println(name + "intialization complete...");
			barrier.await(); //line 1 : all threads come to certain point / place then line 2 will execute
		}catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
