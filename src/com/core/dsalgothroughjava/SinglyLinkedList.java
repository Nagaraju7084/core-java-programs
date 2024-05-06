package com.core.dsalgothroughjava;

public class SinglyLinkedList {
	
	private Node head;
	
	private static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void insertNodeAtBegining(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertNodeAtLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void insertNodeAtGivenPosition(int data, int position) {
		Node newNode = new Node(data);
		if(position == 1) {
			newNode.next = head;
			head = newNode;
		}else {
			Node previous = head;
			int count = 1;
			while(count < position - 1) {
				previous = previous.next;
				count++;
			}
			Node current = previous.next;
			newNode.next = current;
			previous.next = newNode;
		}
	}
	
	public Node deleteFirstNode() {
		if(head == null) {
			return null;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	
	public Node deleteLastNode() {
		if(head == null && head.next == null) {
			return null;
		}
		Node current = head;
		Node previouse = null;
		while(current.next != null){
			previouse = current;
			current = current.next;
		}
		previouse.next = null;
		return current;
	}
	
	public void deleteNodeAtGivenPosition(int position) {
		if(position == 1) {
			head = head.next;
		}
		Node previous = head;
		int count = 1;
		while(count < position - 1) {
			previous = previous.next;
			count++;
		}
		Node current = previous.next;
		previous.next = current.next;
	}
	
	public void printNodes() {
		if(head == null) {
			return;
		}
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	private int count = 0; //used only for count for length of the list other wise no need to write
	public int lenghtOfTheList() {
		if(head == null) {
			return 0;
		}
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			count++;//used only for count for length of the list other wise no need to write
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
		return count;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		
		singlyLinkedList.head = new Node(10);
		
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		
		singlyLinkedList.head.next = second;
		second.next = third;
		third.next = fourth;
		
		//print
		singlyLinkedList.printNodes();
		
		singlyLinkedList.insertNodeAtBegining(12);
		singlyLinkedList.insertNodeAtBegining(11);
		singlyLinkedList.printNodes();
		
		singlyLinkedList.insertNodeAtLast(17);
		singlyLinkedList.printNodes();
		
		singlyLinkedList.insertNodeAtGivenPosition(13, 3);
		singlyLinkedList.printNodes();
		
		singlyLinkedList.insertNodeAtGivenPosition(9, 1);
		singlyLinkedList.printNodes();
		
		System.out.println("deleted first node and data is = " + singlyLinkedList.deleteFirstNode().data);
		System.out.println("length of the list =  " + singlyLinkedList.lenghtOfTheList());
		
		System.out.println("deleted last node and data is = " + singlyLinkedList.deleteLastNode().data);
		System.out.println("length of the list =  " + singlyLinkedList.lenghtOfTheList());
		
		singlyLinkedList.deleteNodeAtGivenPosition(3);
		System.out.println("length of the list =  " + singlyLinkedList.lenghtOfTheList());
		
	}
	
}

/*
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

*/
