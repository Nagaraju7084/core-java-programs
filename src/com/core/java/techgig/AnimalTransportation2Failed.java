package com.core.java.techgig;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnimalTransportation2Failed {

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

            for (int i = N - X; i >= 0; i--) {
                if (energyLevels[i] <= energyLevels[i + X - 1]) {
                    minEnergyLevel = energyLevels[i];
                    break;
                }
            }

            System.out.println(minEnergyLevel);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input: Please enter integers for N and X, and long integers for energy levels.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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