package com.playground.playground.geeks4geeks.fibonacci;

/*
Program to print Fibonacci Triangle
Difficulty Level : Medium
Last Updated : 19 May, 2021
Given the value of n(n < 10), i.e, number of lines, print the Fibonacci triangle.

Examples:

Input : n = 5
Output :
1
1 2
3 5 8
13 21 34 55
89 144 233 377 610

Input : n = 7
Output :
1
1 2
3 5 8
13 21 34 55
89 144 233 377 610
987 1597 2584 4181 6765 10946
17711 28657 46368 75025 121393 196418 317811

The Fibonacci numbers are the numbers in the following integer sequence.
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

    Fn = Fn-1 + Fn-2
with seed values F1 = 1 and F2 = 1.
*/
public class FibonacciTriangle {

    static void fibonacci (int[] f, int n) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            // Add the previous 2 numbers
            // in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }
    }

    static void fiboTriangle (int n) {
        // Fill Fibonacci numbers in f[] using fibonacci().
        // We need N = n*(n+1)/2 Fibonacci numbers to make a triangle of height n
        int N = n * (n + 1) / 2;
        int f[] = new int[N + 1];
        fibonacci(f, N);

        // to store next fibonacci number to print
        int fiboNum = 1;

        // for loop to keep numbers of the line
        for (int i = 1; i <= n; i++) {
            // for loop to keep track of numbers in each line
            for (int j = 1; j <= i; j++) {
                System.out.print(f[fiboNum++] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int n=5;
        fiboTriangle(5);
    }
}
