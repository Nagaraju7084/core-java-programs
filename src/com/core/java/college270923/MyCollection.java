package com.core.java.college270923;

//270923
public class MyCollection {
	private Object[] elementData;
	private int size;
	
	public MyCollection() {
		elementData = new Object[10]; //intial capacity/length
		size = 0; //intially no values are present in the array
	}
	
	public void addObject(Object obj) {
		if(size() == capacity()) {
			grow();
		}
		elementData[size] = obj;
		size++;
	}
	
	public void grow() {
		Object[] newObjArray = new Object[capacity() * 2];
		for(int i=0; i<elementData.length; i++) {
			newObjArray[i] = elementData[i];
		}
		elementData = newObjArray;
	}
	
	//array length is technically called as capacity
	public int capacity() {
		return elementData.length;
	}
	
	//to know how many elements/values present in the array
	public int size() {
		return size;
	}
}
