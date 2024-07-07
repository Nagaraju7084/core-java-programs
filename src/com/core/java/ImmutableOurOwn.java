package com.core.java;

public class ImmutableOurOwn {
	public static void main(String[] args) {
		Immutable t1 = new Immutable(10);
		System.out.println(t1.getX());
		Immutable t2 = t1.modify(20);
		System.out.println(t1.getX());
		System.out.println(t2.getX());
	}
}

class Immutable{
	final int x;
	Immutable(int x){
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public Immutable modify(int x) {
		if(this.x == x) {
			return this;
		}
		return new Immutable(x);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+x;
	}
}
