import java.util.* ;
import java.io.*; 
public class Solution
{
public static int maxSumRectangle(int[][] arr, int n, int m)
    {
        // Write your code here.
        // 1) Brute Force
        // Time complexity: O((N * M)^3)
	    // Space complexity: O(1)
        // int maxSum = Integer.MIN_VALUE;
        // for (int leftCornerI = 0; leftCornerI<n; leftCornerI++) {
        //     for (int leftCornerJ = 0; leftCornerJ<m; leftCornerJ++) {
        //         for (int rightCornerI = leftCornerI; rightCornerI<n; rightCornerI++) {
        //             for (int rightCornerJ = leftCornerJ; rightCornerJ<m; rightCornerJ++) {
        //                 int sum = 0;

        //                 for (int i=leftCornerI; i<=rightCornerI; i++) {
        //                     for (int j=leftCornerJ; j<=rightCornerJ; j++) {
        //                         sum += arr[i][j];
        //                     }
        //                 }
        //                 maxSum = Math.max(sum, maxSum);
        //             }
        //         }
        //     }
        // }
        // return maxSum;

        // 2) Using Kadane's Algo
        // Time complexity: O(N * M * M)
        // Space complexity: O(N)
        int[] sum = new int[n];
        int maxSum = Integer.MIN_VALUE;

        for (int cStart=0; cStart<m; cStart++) {
            Arrays.fill(sum, 0);
            for (int cEnd=cStart; cEnd<m; cEnd++) {
                for (int row=0; row<n; row++) {
                    sum[row] += arr[row][cEnd];
                }
                int currMax = kadans(sum);
                maxSum = Math.max(currMax, maxSum);
            }
        }

        return maxSum;

    }

    public static int kadans(int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum=0;

        for (int i=0; i<arr.length; i++) {
            if (sum<0) {
                sum = 0;
            }
            sum+=arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
