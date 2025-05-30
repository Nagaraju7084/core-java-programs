package com.core.java;

public class PalindromTest {

	public static void main(String[] args) {
		String s = "aba";
		System.out.println("isPalindrome:\t"+isPalindrome(s));
	}

	 public static boolean isPalindrome(String s) {
	        int left = 0;
	        int right = s.length() - 1;
	        
	        // Check symmetry by comparing characters at both ends
	        while (left < right) {
	            if (s.charAt(left) != s.charAt(right)) {
	                return false; // Not a palindrome if characters don't match
	            }
	            left++;
	            right--;
	        }
	        return true; // Symmetry confirmed, it's a palindrome
	    }

}
