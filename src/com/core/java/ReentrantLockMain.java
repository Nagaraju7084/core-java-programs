package com.core.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

	public static void main(String[] args) {
		ReentrantLockEx lockEx = new ReentrantLockEx();
		lockEx.outerMethod();
		
	}

}

class ReentrantLockEx{
	
	private final Lock lock = new ReentrantLock(); //by using reentrantlock we prevent deadlock
	
	public void outerMethod() {
		lock.lock();
		try {
			System.out.println("outer method");
			innerMethod();
		}finally {
			lock.unlock(); //for every lock there should be unlcok otherwise lock will not release rather we will get RE: IlleagalMonitorStateException
		}
	}

	public void innerMethod() {
		lock.lock(); //it shouldn't wait for the lock here deadlock situation will not occur with the help of reentrantlock
		try {
			System.out.println("inner method");
		}finally {
			lock.unlock();
		}
	}
}
