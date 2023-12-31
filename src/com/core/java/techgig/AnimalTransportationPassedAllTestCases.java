package com.core.java.techgig;

/*
problem statement :
You are camping in a forest area at night. You are living with the forest officers to experience their challenges and hardships to create a documentary on them. Everything was going well. Suddenly, a fire has broken out in the forest and it is expanding exponentially. There is a lot of chaos and cries of animals. It is going to take alot of time for the backup. Some of the posts in the forest have also caught fire. The officers are trying everything to safeguard the animals but the fire is spreading too fast. Amid such chaos, the petrol tankers of the officers have also caught fire. The fire is unstoppable now and the commanding officer is taking important decisions with his officers.

The officers know the energy levels of all the N animals in the forest at the moment. It is a tough decision for them as they can only save exactly X animals because of the current situation of the transports they have. Since, the animals are pride of the forest, the energy level of the animals are represented with P. All the animals with energy level equal to P or greater than P can board the available transports and they will be moved to a safer place. But since the capacity is for exactly X animals it is going to be tough to figure out.

Officer needs your help to figure out the minimum energy level P such that they can get exactly X animals to transport. If it is not possible to save exactly X animals, then you should respond with -1 so that they can think of some other plan. The officers are busy trying to get control of the fire and are counting on you to figure out the minimum P to save and transport exactly X animals. 

Example:

Number of animals, N = 5

Energy level of N animals = { 1, 3, 2, 4, 5 }

Current available capacity, X = 4
You should choose P = 2, so that exactly 4 animals with energy levels (2, 3, 4 and 5) can be saved as these have energies greater than or equal to P.

Input Format
The first line of input consists of two space-separated integers, N (number of animals) and X (available capacity for animals that can be transported).

The second line of input consists of N space-separated integers, representing the energy of all the animals.

Constraints
1<= N <=10^5

1<= X <=N

1<= arr[i] <=10^12

Arr[i] represents the energy level of the ith animal.

Output Format
Print the minimum energy level P such that exactly X animals can be saved or transported. If it is not possible to save exactly X animals, then print -1.

Sample TestCase 1
Input
5 4
1 3 2 4 5
Output
2
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AnimalTransportationPassedAllTestCases {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println(minEnergy(N, X, arr));
    }

    public static int minEnergy(int N, int X, List<Integer> arr) {
        Collections.sort(arr, Collections.reverseOrder());
        if (X == N) {
            return arr.get(X - 1);
        } else if (arr.get(X - 1).equals(arr.get(X))) {
            return -1;
        } else {
            return arr.get(X - 1);
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
----
here the code is converted from python to java using online tools
https://www.codeconvert.ai/python-to-java-converter
python code
 * from typing import List


def min_energy(n: int, x: int, arr: List[int]) -> int:
    arr.sort(reverse=True)
    return arr[x-1] if x == n else -1 if arr[x-1] == arr[x] else arr[x-1]


def main():
    N, X = list(map(int, input().strip().split(' ')))
    arr = list(map(int, input().strip().split(' ')))
    print(min_energy(N, X, arr))


if __name__ == '__main__':
    main()
----

*/