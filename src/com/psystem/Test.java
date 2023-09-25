package com.psystem;

public class Test extends ParentTest {

	public Test(String name) {
		//super();
		this();
		System.out.println("Test class object is created");
	}
	Test(){
		System.out.println("Test class object without name");
	}
	
	public static void main(String[] args) {
		Test t = new Test("Hello");
	}
	
}

class ParentTest {

	public ParentTest() {
		System.out.println("In ParentTest");
	}
	
}


abstract class Discount{
	
	private int customerId;
	
	public abstract double flatDiscount();
	public abstract double couponDiscount();
}

class MondayDiscount extends Discount{

	@Override
	public double flatDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double couponDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class TuesedayDiscount extends Discount{

	@Override
	public double flatDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double couponDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class WebnesdayDiscount extends Discount{

	@Override
	public double flatDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double couponDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}