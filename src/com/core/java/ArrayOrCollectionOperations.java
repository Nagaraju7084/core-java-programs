package com.core.java;

//260923
public class ArrayOrCollectionOperations {
	
	private Object[] elementData;
	private int size;
	
	//custom hashmap as key and value

	private Object[] keys;
	private Object[] values;
	
	private int tableSize;
	
	public ArrayOrCollectionOperations() {
		elementData = new Object[10];
		size = 0;
		
		keys = new Object[10];
		values = new Object[10];
		tableSize = 0;
	}
	
	public void add(Object obj) {
		if(size() == capacity()) 
			grow();
		this.elementData[size++] = obj;
	}

	public int capacity() {
		return elementData.length;
	}
	
	public int tableCapacity() {
		return keys.length;
	}
	
	public int size() {
		return size;
	}
	
	public int tableSize() {
		return tableSize;
	}
	
	private void grow() {
		
		int newCapacity = capacity() * 2;
		
		Object[] nextArray = new Object[newCapacity];
		
		for(int i=0; i<elementData.length; i++) {
			nextArray[i] = elementData[i];
		}
		
		elementData = nextArray;
		
	}
	
	private void tableGrow() {
		
		int newCapacity = capacity() * 2;
		
		Object[] keyNextArray = new Object[newCapacity];
		Object[] valueNextArray = new Object[newCapacity];
		
		for(int i=0; i<keys.length; i++) {
			keyNextArray[i] = keys[i];
			valueNextArray[i] = values[i];
		}
		keys = keyNextArray;
		values = valueNextArray;
	}

	private void customArrayCopy(int[] sourceArray, int[] destinationArray) {
		if(sourceArray.length != destinationArray.length) {
			throw new IllegalAccessError("source and destination array must have the same length");
		}
		for(int i=0; i<sourceArray.length; i++) {
			destinationArray[i] = sourceArray[i];
		}
	}
	
	/*
	 * public void sortAscendingBubbleSort() { for(int i=0; i<size-1; i++) { for(int
	 * j=0; j<size-i-1; j++) { if(elementData[j] > elementData[j+1]) { int temp =
	 * elementData[j]; elementData[j] = elementData[j+1]; elementData[j+1] = temp; }
	 * } } }
	 */
	
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
			builder.append(elementData[i]);
			builder.append(", ");
		}
		
		int start = builder.lastIndexOf(", ");
		int end = start + 2;
		builder.delete(start, end); //start is inclusive and end is exclusive and hence 2 is taken here
		
		builder.append("]");
		
		return builder.toString();
	}
	
	public String displayTable() {
		if(size == 0)
			return "{}";
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		
		for(int i=0; i<size; i++) {
			builder.append(keys[i]+"="+values[i]);
			builder.append(", ");
		}
		
		int start = builder.lastIndexOf(", ");
		int end = start + 2;
		builder.delete(start, end);
		
		builder.append("}");
		
		return builder.toString();
	}
	
	public boolean contains(Object obj) {
		
		//contains and indexOf methods using smae code, so core redundancy is there
		//we have to write unique code but not duplicate
		//to resolve calling one method in another
		//here if we call contains in indexOf method, contains method reutrns boolean and
		//indexOf method returns int, boolean to int conversion is not possible, so
		//call indexOf method in contains method, so we can convert int to boolean
		
		return indexOf(obj) >= 0;
		
		
		/*
			if (obj == null) { // we can compare values in two ways 1.== operator 2. equals methos
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null) //here, we will get performance issue, for each iteration reading null
					return true;		//is bad so instead of obj == elementData[i], directly use null == elementData[i] but write elementData[i] == null -> its good programming practise
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (obj.equals(elementData[i]))
					return true;
			}
		}
		return false;
		
		*/
		
	}
	
	public int indexOf(Object obj) { //this will return first occurence
		if (obj == null) { // we can compare values in two ways 1.== operator 2. equals methos
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null) 
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (obj.equals(elementData[i]))
					return i;
			}
		}
		
		return -1;
	}
	
	public int lastIndexOf(Object obj) {
		
		if (obj == null) { // we can compare values in two ways 1.== operator 2. equals methos
			for (int i = size-1; i >= 0; i--) {
				if (elementData[i] == null) 
					return i;
			}
		} else {
			for (int i = size; i >= 0; i--) {
				if (obj.equals(elementData[i]))
					return i;
			}
		}
		
		return -1;
	}
	
	public Object get(int index) {
		
		if(index < 0 || index >= size) 
				throw new IndexOutOfBoundsException("given index is not found : "+index);
		return elementData[index];
	}
	
	public void remove(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("invalid index");
		for(; index<size-1; index++) {
			elementData[index] = elementData[index + 1];
		}
		elementData[size-1] = null;
		size--;
	}
	
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if(index >= 0) {
			remove(index);
			return true;
		}
		return false;
	}
	
	public void add(int index, Object obj) {
		if(index < 0 || index >= size) 
			throw new ArrayIndexOutOfBoundsException(index);
		if(size() == capacity())
			grow();
		for(int i=size-1; i>=index; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[index] = obj;
		size++;
	}
	
	public Object set(int index, Object obj) {
		if(index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException(index);
		Object oldObject = get(index);
		elementData[index] = obj;
		return oldObject;
	}
	
	public void put(Object key, Object value) {
		if(tableSize() == tableCapacity())
			tableGrow();
		
		keys[tableSize] = key;
		values[tableSize] = value;
		
		tableSize++;
	}
	
	public void clean() {
		elementData = null;
	}
	
	public static void main(String[] args) {
		ArrayOrCollectionOperations arrayObj = new ArrayOrCollectionOperations();
		System.out.println(arrayObj.capacity());
		System.out.println(arrayObj.size());
		
		arrayObj.add("a");
		arrayObj.add("b");
		arrayObj.add(5);
		arrayObj.add(6.7);
		arrayObj.add('a');
		arrayObj.add(null);
		arrayObj.add(true);
		arrayObj.add(new Ex(5,6));
		
		System.out.println(arrayObj.size());
		System.out.println(arrayObj);
		
		System.out.println();
		System.out.println("is \"a\" found : "+arrayObj.contains("a"));
		System.out.println("is \"b\" found : "+arrayObj.contains("b"));
		System.out.println("is \"A\" found : "+arrayObj.contains("A"));
		System.out.println("is 5 found : "+arrayObj.contains(5));
		System.out.println("is 'a' found : "+arrayObj.contains('a'));
		System.out.println("is Ex(5,6) found : "+arrayObj.contains(new Ex(5,6)));
		System.out.println("is null found : "+arrayObj.contains(null));
		
		System.out.println("\"a\" is found at index : "+arrayObj.indexOf("a"));
		System.out.println("\"b\" is found at index : "+arrayObj.indexOf("b"));
		System.out.println("\"A\" is found at index : "+arrayObj.indexOf("A")); //-1 means not found
		System.out.println("5 is found at index : "+arrayObj.indexOf(5));
		System.out.println("'a' is found at index : "+arrayObj.indexOf('a'));
		System.out.println("Ex(5,6) is found at index : "+arrayObj.indexOf(new Ex(5,6)));
		System.out.println("null is found at index : "+arrayObj.indexOf(null));
		System.out.println();
		
		System.out.println("last index of \"a\" is found at : "+arrayObj.lastIndexOf("a"));
		System.out.println("last index of \"b\" is found at : "+arrayObj.lastIndexOf("b"));
		System.out.println("last index of \"A\"  is found at : "+arrayObj.lastIndexOf("A")); //-1 means not found
		System.out.println("last index of 5 is found at : "+arrayObj.lastIndexOf(5));
		System.out.println("last index of 'a' is found at : "+arrayObj.lastIndexOf('a'));
		System.out.println("last index of Ex(5,6) is found at : "+arrayObj.lastIndexOf(new Ex(5,6)));
		System.out.println("last index of true is found at : "+arrayObj.lastIndexOf(true));
		System.out.println("last index of null is found at : "+arrayObj.lastIndexOf(null));
		System.out.println();
		
		System.out.println(arrayObj);
		System.out.println("which object at index 0 : "+arrayObj.get(0));
		//System.out.println("which object at index 30 : "+arrayObj.get(30)); //RE : index out of bounds exception
		
		int index = arrayObj.indexOf(new Ex(5,6));
		Object obj = arrayObj.get(index);
		Ex ex = (Ex)obj;
		ex.setX(ex.getX() + 5);
		System.out.println(ex);
		//arrayObj.remove(null);
		System.out.println("is 6.7 removed : "+arrayObj.remove(6.7));
		System.out.println("is 6.7 removed : "+arrayObj.remove(6.7));
		System.out.println("is 6.7 removed : "+arrayObj.remove(6.7));
		System.out.println(arrayObj);
		arrayObj.add(5, 10);
		System.out.println(arrayObj);
		System.out.println(arrayObj.set(1, 10));
		System.out.println(arrayObj.set(4, true));
		System.out.println(arrayObj);
		
		//create table or map object
		//its created as above(Obejct creation time)
		
		//print capacity and size of the elements
		System.out.println("table capacity : "+arrayObj.tableCapacity());
		System.out.println(arrayObj.tableSize());
		//add entries
		arrayObj.put("a", 1);
		arrayObj.put("b", 2);
		arrayObj.put(5, "c");
		arrayObj.put(6.7, 'a');
		arrayObj.put(true, 3);
		arrayObj.put(null, 6);
		arrayObj.put("a", 7);
		arrayObj.put(5, 8);
		arrayObj.put(new Ex(5,6), new Ex(7,8));
		arrayObj.put(new Ex(5,6), new Ex(7,8));
		//test capacity growing or not
		System.out.println("table capacity : "+arrayObj.tableCapacity());
		System.out.println("table size : "+arrayObj.tableSize());
		System.out.println("elements in a table : "+arrayObj.displayTable());
		//again print elements
	}

}

class Ex{
	
	private int x;
	private int y;
	
	public Ex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ex) {
			Ex ex = (Ex)obj;
			return this.getX() == ex.getX() && this.getY() == ex.getY();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Ex("+x+ "," + y +")";
	}
}
