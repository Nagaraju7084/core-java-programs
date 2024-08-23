package com.core.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockMain {

	public static void main(String[] args) throws InterruptedException {
		
		ReentrantReadWrite counter = new ReentrantReadWrite();
		
		Runnable readTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getName() + " : " + counter.getCounter());
				}
			}
		};
		
		Runnable writeTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					counter.incrementCounter();
					System.out.println(Thread.currentThread().getName() + " : incremented");
				}
			}
		};
		
		Thread writerThread = new Thread(writeTask, "writer thread");
		Thread readerThread = new Thread(readTask, "reader thread-1");
		Thread readerThread2 = new Thread(readTask, "reader thread-2");
		
		writerThread.start();
		readerThread.start();
		readerThread2.start();
		
		writerThread.join();
		readerThread.join();
		readerThread2.join();
		
		System.out.println("final counter = " + counter.getCounter());
	}

}

class ReentrantReadWrite {
	
	private int counter = 0;
	
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private final Lock readLock = lock.readLock();
	
	private final Lock writeLock = lock.writeLock();
	
	public void incrementCounter() {
		writeLock.lock();
		try {
			counter++;
		}finally {
			writeLock.unlock();
		}
	}
	
	public int getCounter() {
		readLock.lock();
		try {
			return counter;
		}finally {
			readLock.unlock();
		}
	}
}
