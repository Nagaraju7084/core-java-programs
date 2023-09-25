package com.core.java.techgig;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnimalTransportation3Failed {

	public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt(); // Number of animals
            int X = scanner.nextInt(); // Available capacity

            if (N < 1 || X < 1 || X > N) {
                throw new IllegalArgumentException("Invalid input: N and X should be positive integers, and X should be less than or equal to N.");
            }

            long[] energyLevels = new long[N]; // Array to store energy levels

            for (int i = 0; i < N; i++) {
                energyLevels[i] = scanner.nextLong(); // Read energy level of each animal
                if (energyLevels[i] < 1) {
                    throw new IllegalArgumentException("Invalid input: Energy level should be a positive integer.");
                }
            }

            Arrays.sort(energyLevels); // Sort the energy levels in ascending order

            long minEnergyLevel = -1; // Initialize the minimum energy level to -1

            long left = 1; // Left boundary for binary search
            long right = energyLevels[N - X]; // Right boundary for binary search

            while (left <= right) {
                long mid = left + (right - left) / 2;

                if (canTransport(energyLevels, mid, X)) {
                    minEnergyLevel = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(minEnergyLevel);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    // Helper method to check if X animals can be transported with energy level P
    private static boolean canTransport(long[] energyLevels, long P, int X) {
        int count = 0;

        for (int i = energyLevels.length - 1; i >= 0; i--) {
            if (energyLevels[i] >= P) {
                count++;
                if (count == X) {
                    return true;
                }
            } else {
                break;
            }
        }

        return false;
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