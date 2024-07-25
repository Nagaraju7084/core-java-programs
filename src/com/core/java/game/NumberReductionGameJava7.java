package com.core.java.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberReductionGameJava7 {
	public static void main(String[] args) {
		int N = 100;
		int simulations = 1000; //assumption
		runSimulations(N, simulations);
	}

	private static void runSimulations(int N, int simulations) {
		Random random = new Random();
		int smallWins = 0;
		int largeWins = 0;
		
		for(int s = 0; s < simulations; s++) {
			List<Integer> numbers = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				numbers.add(i); // initializing the list with the numbers 1 to N
			}
			
			while(numbers.size() > 1) {
				int index1 = random.nextInt(numbers.size()); // select first random index
				int number1 = numbers.remove(index1); // remove and get the number
				
				int index2 = random.nextInt(numbers.size()); // select second random index
				int number2 = numbers.remove(index2); // remove and get the numebr
				
				int newNumber = Math.abs(number1 - number2); // calculate the difference
				numbers.add(newNumber);
			}
			int finalNumber = numbers.get(0);
			if(finalNumber <= N/2) {
				smallWins++; // increment the count if the final number is smaller category
			}else {
				largeWins++; // increment the count if the final number is larger category
			}
		}
		System.out.println("smaller numbers won: " + (smallWins * 100.0/simulations) + "%");
		System.out.println("larger numbers won: " + (largeWins * 100.0/simulations) + "%");
	}
}
