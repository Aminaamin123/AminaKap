package com.company;
import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String args[]) {
        int w = 10;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        int n = wt.length;

        int[][] table = new int[n + 1][w + 1]; // create table
        for (int r = 0; r < w + 1; r++) {
            table[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            table[c][0] = 0;
        }

        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurr = table[item - 1][capacity];
                int maxValWithCurr = 0;

                int weightOfCurr = wt[item - 1];
                if (capacity >= weightOfCurr) { // check if item fit
                    maxValWithCurr = val[item - 1];

                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxValWithCurr += table[item - 1][remainingCapacity]; // Add  maximum value  remaining capacity
                }

                table[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr);
            }
        }

        System.out.println(table[n][w]);
        System.out.println(Arrays.deepToString(table));
    }
}
