package com.core.java.techgig;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnimalTransportation5Failed {

	public static void main(String[] args) {
		//test case1
		/*
		 * int N = 5; int X = 4; long[] energyLevels = {1,3,2,4,5}; long value =
		 * calculateMinimumEnergyLevel(N, X, energyLevels); System.out.println(value);
		 */
		//test case2
		int N = 6;
		int X = 3;
		long[] energyLevels = { 7, 5, 9, 6, 8, 10 };
		
		long value = calculateMinimumEnergyLevel(N, X, energyLevels); System.out.println(value);
		 
	}
	
	public static long calculateMinimumEnergyLevel(int N, int X, long[] energyLevels) {
        if (N < 1 || X < 1 || X > N) {
            throw new IllegalArgumentException("Invalid input: N and X should be positive integers, and X should be less than or equal to N.");
        }

        Arrays.sort(energyLevels);

        long left = 1;
        long right = energyLevels[N - 1];
        long minEnergyLevel = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canTransport(energyLevels, mid, X)) {
                minEnergyLevel = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minEnergyLevel;
    }

    private static boolean canTransport(long[] energyLevels, long P, int X) {
        int count = 0;

        for (int i = energyLevels.length - 1; i >= 0; i--) {
            if (energyLevels[i] >= P) {
                count++;
            }
        }

        return count <= X;
    }
}

/*
Test Case 1:
Input:
5 4
1 3 2 4 5
Output:
2
Test Case 2:
Input:
6 3
7 5 9 6 8 10
Output:
7
Test Case 3:
Input:
8 5
1 2 3 4 5 6 7 8
Output:
4

*/