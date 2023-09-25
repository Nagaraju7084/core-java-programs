package com.core.java.techgig;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnimalTransportation6Failed {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of animals
        int X = scanner.nextInt(); // Available capacity
        long[] energyLevels = new long[N]; // Array to store energy levels

        for (int i = 0; i < N; i++) {
            energyLevels[i] = scanner.nextLong();
        }

        // Sort the energy levels in ascending order
        Arrays.sort(energyLevels);

        long minEnergyLevel = -1; // Minimum energy level to save exactly X animals
        int count = 0; // Counter for the number of animals saved

        for (int i = N - 1; i >= 0; i--) {
            if (energyLevels[i] >= minEnergyLevel) {
                count++;
            }

            // Check if X animals have been saved
            if (count == X) {
                minEnergyLevel = energyLevels[i];
                break;
            }
        }

        if (count < X) {
            minEnergyLevel = -1;
        }

        System.out.println(minEnergyLevel);
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