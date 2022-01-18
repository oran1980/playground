package com.playground.playground.geeks4geeks.catalannumbers;

/**
 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting
 * problems like following.
 * 
 * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched.
 * For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * 
 * 2) Count the number of possible Binary Search Trees with n keys
 * 
 * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either
 * two children or no children) with n+1 leaves.
 * 
 * 4) Given a number n, return the number of ways you can draw n chords in a circle with 2 x n
 * points such that no 2 chords intersect.
 * 
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862,
 * …
 * 
 * Recursive Solution Catalan numbers satisfy the following recursive formula.
 * 
 * C_0=1 \ and \ C_{n+1}=\sum_{i=0}^{n}C_iC_{n-i} \ for n>=0
 */
public class NthCatalanNumber {
    // recursive function to find nth catalon number

    int catalan (int n) {
        int res = 0;

        // Base case
        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i <n; i++) {
            res += catalan(i) * catalan(n - i-1);
        }
        return res;
    }

    public static void main (String[] args) {
        NthCatalanNumber catalanNumber = new NthCatalanNumber();
        for(int i=0; i<5; i++){
            System.out.println(catalanNumber.catalan(i)+ " ");
        }
    }

}
