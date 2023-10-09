package com.core.java;

public class ImmutableOurOwn {
	public static void main(String[] args) {
		Test t1 = new Test(10);
		System.out.println(t1.getX());
		Test t2 = t1.modify(20);
		System.out.println(t1.getX());
		System.out.println(t2.getX());
	}
}

class Test{
	final int x;
	Test(int x){
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public Test modify(int x) {
		if(this.x == x) {
			return this;
		}
		return new Test(x);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+x;
	}
}
