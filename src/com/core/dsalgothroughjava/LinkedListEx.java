package com.core.dsalgothroughjava;

public class LinkedListEx {
	
	Node head;
	private int size;
	
	public LinkedListEx() {
		this.size = 0;
	}

	class Node{
		String data;
		Node next;
		
		Node(String data){
			this.data = data;
			this.next = null;
			size++;
		}
	}
	
	//insert or add
	//add - first, add - last
	public void addFirst(String data) {
		//if linked list empty create a node and assign head
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		//if adding a node to existing linked list
		//next point to head and head is point to new node
		newNode.next = head;
		head = newNode;
		
	}
	
	//add - last
	public void addLast(String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
	}
	
	//print
	public void printList() {
		if(head == null) {
			System.out.println("linked list is empty");
			return;
		}
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.data+ " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}
	
	//delete first
	public void deleteFirst() {
		if(head == null) {
			System.out.println("linked list is empty");
			return;
		}
		size--;
		head = head.next;
	}
	
	//delete last
	public void deleteLast() {
		if(head == null) {
			System.out.println("linked list is empty");
			return;
		}
		
		size--;
		
		if(head.next == null) {
			head = null;
			return;
		}
		Node secondLast = head;
		Node lastNode = head.next; // head.next = null -> lastNode = null
		while(lastNode.next != null) { // null.next gives error so above if condition required
			lastNode = lastNode.next;
			secondLast = secondLast.next;
		}
		
		secondLast.next = null;
	}
	
	public int getSize() {
		return size;
	}
	
	//reversing linked list
	public void reverseIterate() {
		//corner cases
		if(head == null || head.next == null) {
			return;
		}
		Node prevNode = head;
		Node currentNode = head.next;
		while(currentNode != null) {
			Node nextNode = currentNode.next;
			currentNode.next = prevNode;
			
			//update
			prevNode = currentNode;
			currentNode = nextNode;
		}
		
		head.next = null;
		head = prevNode;
		
	}
	
	public static void main(String[] args) {

		LinkedListEx linkedListEx = new LinkedListEx();
		
		//addfirst
		linkedListEx.addFirst("a");
		linkedListEx.addFirst("is");
		
		//print or display
		linkedListEx.printList();
		
		//addlast
		linkedListEx.addLast("list");
		linkedListEx.printList();
		
		linkedListEx.addFirst("this");
		linkedListEx.printList();
		
		//delete first
		linkedListEx.deleteFirst();
		linkedListEx.printList();
		
		//delete last
		linkedListEx.deleteLast();
		linkedListEx.printList();
		
		//size
		System.out.println(linkedListEx.getSize());
		linkedListEx.addFirst("this");
		System.out.println(linkedListEx.getSize());
		
		linkedListEx.printList();
		linkedListEx.reverseIterate();
		linkedListEx.printList();
		
	}
	
}
