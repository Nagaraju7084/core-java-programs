package com.core.java;

public class ArrayOperations {
	
	private Object[] elementData;
	private int size;
	
	public ArrayOperations() {
		elementData = new Object[10];
		size = 0;
	}
	
	public void add(Object obje) {
		if(size() == capacity()) {
			grow();
		}
	}
	private void grow() {
		Object[] newArray = new Object[elementData.length * 2];
		for(int i=0; i<elementData.length; i++) {
			newArray[i] = elementData[i];
		}
		elementData = newArray;
	}

	public int size() {
		return size;
	}
	public int capacity() {
		return elementData.length;
	}

}
