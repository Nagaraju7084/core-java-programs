package com.psystem;

import java.math.BigDecimal;

public class B extends A{

	//B obj = new A(); //child reference should not hold parent object
	A obj1 = new B(); // parent reference can hold child object
	
}

class A{}

class D{
	
	int i = 2;
	
	public BigDecimal method1(String s1, String s2, BigDecimal val1) {
		BigDecimal j = new BigDecimal(5);
		System.out.println(j);
		val1 = val1.add(j);
		if(s1.equals(s2)) {
			val1 = val1.add(j);
		}
		val1 = val1.add(j);
		return val1;
	}
	
}
