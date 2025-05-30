package com.core.java;

import java.util.Arrays;

public class TestNew {

	public static void main(String[] args) {
		/**
		 * Java - Coding Test
		Maximize Profit.
		Cost Price of 1 Stock from Day-1 to Day-7 is as follows,
		Input: 6, 4, 2, 4, 3, 20, 1
		Output: Day-3 & Day-6 
		 */
		
		int[] prices = {6, 4, 2, 4, 3, 20, 1}; // Stock prices for Day-1 to Day-7

        int minIndex = 0; // Track the buying day (smallest price)
        int maxProfit = 0;
        int buyDay = 0, sellDay = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i; // Update lowest price index
            }
            //calculating the profit
            //profit = selling price - buying price
            int profit = prices[i] - prices[minIndex]; // selling price - buying price

            if (profit > maxProfit) {
                maxProfit = profit;
                buyDay = minIndex + 1; // Convert index to Day (1-based)
                sellDay = i + 1;
            }
        }

        System.out.println("Buy on Day-" + buyDay + " & Sell on Day-" + sellDay);
        
        splitStringUsingComma();
	}

	private static void splitStringUsingComma() {
		String str = "abc,def,ghi,jkl,mno";
		
		String[] wordsArr = str.split(",");
		System.out.println(Arrays.toString(wordsArr));
	}

}

