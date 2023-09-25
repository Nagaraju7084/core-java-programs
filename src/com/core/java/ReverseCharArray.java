package com.core.java;

public class ReverseCharArray {
    
  
    public static void main(String[] args)
    {
        char[] arr = {'a','b','c','d'};
        reverseArray(arr, arr.length);
    }

	private static void reverseArray(char[] arr, int length) {
		char[] ch = new char[length];
		int j = length;
		
		for(int i=0; i<length; i++) {
			ch[j-1] = arr[i];
			j = j-1;
		}
		System.out.println("reversed array is :\n");
		for(int k=0; k<ch.length; k++) {
			System.out.println(ch[k]);
		}
	}
    
}
