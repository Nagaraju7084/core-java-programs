package com.core.java;

public class InterThreadCommunicationMain {

	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		
		Thread producerThread = new Thread(new Producer(resource));
		Thread consumerThread = new Thread(new Consumer(resource));
		
		producerThread.start();
		consumerThread.start();
		
	}

}

class SharedResource {
	
	private int data;
	private boolean hasData;
	
	public synchronized void produce(int value) {
		while(hasData) { //if data is there in the buffer
			try {
				wait();
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt(); //restore its state
			}
		}
		data = value;
		hasData = true;
		System.out.println("produced : " + value);
		notify(); //notify to other thread to consume
		
	}
	public synchronized int consume() {
		while(!hasData) { //if there is no data
			try {
				wait();
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt(); //restore its state
			}
		}
		hasData = false;
		System.out.println("produced : " + data);
		notify();
		return data; //now buffer is empty
	}
}

class Producer implements Runnable {
	
	private SharedResource resource;
	
	Producer(SharedResource resource){
		this.resource = resource;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			resource.produce(i);
		}
	}
}

class Consumer implements Runnable {
	
	private SharedResource resource;
	
	Consumer(SharedResource resource){
		this.resource = resource;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			int value = resource.consume();
		}
	}
}
