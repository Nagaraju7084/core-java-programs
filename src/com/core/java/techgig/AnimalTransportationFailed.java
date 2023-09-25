package com.core.java.techgig;

import java.util.Arrays;
import java.util.Scanner;

public class AnimalTransportationFailed {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of animals
        int X = scanner.nextInt(); // Available capacity
        
        long[] energyLevels = new long[N]; // Array to store energy levels
        
        for (int i = 0; i < N; i++) {
            energyLevels[i] = scanner.nextLong(); // Read energy level of each animal
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