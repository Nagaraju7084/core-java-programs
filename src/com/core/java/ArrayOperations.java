package com.core.java;

//260923
public class ArrayOperations {
	
	private int[] array;        //declare an integer array to store the elements
	private int size;           //initialize a variable to keep track the number of elements in the array
	private int capacity; //intialize a variable to store the maximum capacity of the array
	
	//constructor for intializing variables/assign initial values to the variables with an initial capacity
	public ArrayOperations(int initialCpacity) {
		if(initialCpacity <= 0) {
			throw new IllegalArgumentException("intial capacity must be greater than 0");
		}
		array = new int[initialCpacity];
		size = 0;
		this.capacity = initialCpacity;
	}
	
	//insert an element at the begining of an array
	public void insertAtFirst(int element) {
		ensureCapacity(); //ensure that the array has enough space to insert an element
		for(int i=size; i>0; i--) {
			array[i] = array[i-1]; //shift elements to the right to make space for the new element
		}
		array[0] = element; //insert the new element at the begining
		size++;
	}
	
	//insert an element at the specified index/position
	public void insertAtIndex(int element, int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		ensureCapacity();
		for(int i=size; i>index; i--) {
			array[i] = array[i-1];
		}
		array[index] = element; //insert new element at specified index
		size++;
	}
	
	//insert an element at last position/index
	public void insertAtLast(int element) {
		ensureCapacity();
		array[size] = element;
	}
	
	//update an element at specified index/position with the given element
	public void updateAtIndex(int index, int newValue) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		array[index] = newValue;
	}
	
	//delete first element
	public void deleteFirst() {
		if(size == 0) {
			throw new IllegalStateException("array is empty");
		}
		for(int i=0; i<size-1; i++) {
			array[i] = array[i+1]; //shift elements to the left to remove the fist element
		}
		size--; //decrease the size
	}
	
	//delete element at specified index/position
	public void deleteAtIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		for(int i=index; i<size-1; i++) {
			array[i] = array[i+1]; //shifr elements to the left to remove the element at the specified index
		}
		size--;
	}
	
	//delete the last element in the array
	public void deleteLast() {
		if(size == 0) {
			throw new IllegalStateException("array is empty");
		}
		size--;
	}
	
	//return first element
	public int returnFirstElement() {
		return array[0];
	}
	
	//search for the first occurence of element
	public int searchFirst(int element) {
		for(int i=0; i<size; i++) {
			if(array[i] == element) {
				return i; //element found and return its index
			}
		}
		return -1; //element not found
	}
	
	//search for the first occurence of an element starting from a specified index/position and return its index
	public int searchAtIndex(int element, int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		for(int i=index; i<size; i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	//search for the last occurence of an element and return its index
	public int searchLast(int element) {
		for(int i=size-1; i>=0; i--) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	//ensure that the array has enough space to insert an element
	private void ensureCapacity() {
		if(size == capacity) {
			increaseCapacity(capacity * 2); //double the capacity if its reached maximum capacity
		}
	}

	//increase the capacity of an array with the specified capacity
	private void increaseCapacity(int newCapacity) {
		if(newCapacity <= capacity) {
			throw new IllegalArgumentException("new capacity must be greater than the current capacity");
		}
		int[] newArray = new int[newCapacity];
		//System.arraycopy(array, 0, newArray, 0, size);
		customArrayCopy(array, newArray);
		array = newArray;
		capacity = newCapacity;
	}

	private void customArrayCopy(int[] sourceArray, int[] destinationArray) {
		if(sourceArray.length != destinationArray.length) {
			throw new IllegalAccessError("source and destination array must have the same length");
		}
		for(int i=0; i<sourceArray.length; i++) {
			destinationArray[i] = sourceArray[i];
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getSize() {
		return size;
	}
	public void display() {
		for(int i=0; i<size; i++) {
			System.out.println(array[i] + " ");
		}
	}
	
	public void sortAscendingBubbleSort() {
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size-i-1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	//override toString method for printing array/collection elements
	@Override
	public String toString() {
		
		if(size == 0)
			return "[]";
		//convert array to String
		//copy or append each element from the array to StringBuilder object becuase
		//String is immutable, each addition/modification every String object will be created it leads to performance issue
		//StringBuffer is synchronized for each and every operation lock and unlock is required and hence StringBuilder is best to achieve this conversion
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		
		for(int i=0; i<size; i++) {
			builder.append(array[i]);
			builder.append(", ");
		}
		
		int start = builder.lastIndexOf(", ");
		int end = start + 2;
		builder.delete(start, end); //start is inclusive and end is exclusive and hence 2 is taken here
		
		builder.append("]");
		
		return builder.toString();
	}
	public void clean() {
		array = null;
	}

}
