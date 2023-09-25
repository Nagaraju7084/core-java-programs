package com.core.java;

public class FrequencyCounter {

	public static void main(String[] args) {

		String str = "abbbbcdddefffff";
		str = str.toLowerCase();
		System.out.println("character\tfrequency");
		for(char ch='a'; ch<='z'; ch++) {
			int counter = 0;// counter variable
			for(int i=0; i<str.length(); i++) {
				if(ch == str.charAt(i)) 
					counter++;
				}
			if(counter != 0) {
				System.out.println(ch + "\t\t" + counter);
			}
		}
	}

}
