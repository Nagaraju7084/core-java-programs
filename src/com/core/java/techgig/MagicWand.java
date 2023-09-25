package com.core.java.techgig;

/*
You are a wizard who possesses a magical wand that can be used to change the values of an array. Your wand has two powers: Increase and Decrease. With each use of the wand, you can either increase or decrease any element of the array by 1.

One day, a group of villagers came to you with a problem. They had an array of positive integers of size N and a set of queries of size M. For each query, queries[i], they wanted to make all the elements of the array equal to queries[i] using your magic wand.

To help the villagers, you decided to use your magic wand to perform the operations. However, each time you perform an operation, the cost of using your wand increases. The cost of using your wand for an operation on an element is equal to the absolute difference between the value of the element and the desired value after the operation.

Example:

If you want to change an element from 5 to 3, it will cost you 2. If you want to change an element from 7 to 8, it will cost you 1.

You can perform any number of operations on any element of the array for a given query. However, the cost of using the wand for each operation accumulates, and you want to minimize the total cost of all operations for each query.

Input Format
The first line of the input consists of two space-separated integers N (length of array) and M (length of queries).

The second line of input consists of N space-separated integers arr[i].

The third line of input consists of M space-separated integers queries[i].

Constraints
1 <= N <= 10^5

1 <= M <= 10^5

1 <= arr[i] <= 10^9

1 <= queries[i] <= 10^9

Output Format
Print a list of integers of cost of length m, where cost[i] is the minimum cost to make all elements of nums equal to queries[i].

Sample TestCase 1
Input
5 3
1 2 3 4 5
5 2 1
Output
10 7 10
Explanation

Number of array elements, N = 5

Number of Queries,M = 3

For the first query, queries[0] = 5, you can increase the elements at indices 0, 1, 2, and 3 by 4, 3, 2 and 1 respectively. Total cost of operations = 10.

For the second query, queries[1] = 2, you can decrease the elements at indices 2, 3, and 4 by 1, 2, and 3, and increase the element at index 0 by 1. Total cost of operations = 7.

For the third query, queries[2] = 1, you can decrease the elements at indices 4, 3, 2, and 1, by 4, 3, 2 and 1. Total cost of operations = 10
*/
import java.util.Scanner;

public class MagicWand {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt(); // Length of array
            int M = scanner.nextInt(); // Length of queries

            if (N < 1 || M < 1) {
                throw new IllegalArgumentException("Invalid input: N and M should be positive integers.");
            }

            int[] arr = new int[N]; // Array of elements
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt(); // Read array elements
                if (arr[i] < 1) {
                    throw new IllegalArgumentException("Invalid input: Array elements should be positive integers.");
                }
            }

            int[] queries = new int[M]; // Array of queries
            for (int i = 0; i < M; i++) {
                queries[i] = scanner.nextInt(); // Read queries
                if (queries[i] < 1) {
                    throw new IllegalArgumentException("Invalid input: Queries should be positive integers.");
                }
            }

            int[] cost = new int[M]; // Array to store costs

            for (int i = 0; i < M; i++) {
                int totalCost = 0; // Total cost for current query
                for (int j = 0; j < N; j++) {
                    int diff = Math.abs(arr[j] - queries[i]); // Absolute difference between current element and query value
                    totalCost += diff; // Accumulate the cost
                }
                cost[i] = totalCost; // Store the total cost for the current query
            }

            // Print the costs
            for (int i = 0; i < M; i++) {
                System.out.print(cost[i]);
                if (i < M - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}