import java.util.* ;
import java.io.*; 
public class Solution {
    public static int pairSum(int arr[], int n, int target) {
        // Write your code here.
        int count = 0;
        
        // Optimised Approach
        int i = 0, j = n-1;
        while(i<j) {
            int sum = arr[i] + arr[j];

            if (sum < target)
                i++;
            else if (sum > target)
                j--;
            else {
                count++;
                i++;
                j--;
            }
        }

        // Brute Force
        // for (int i =0; i<arr.length; i++) {
        //     for (int j=i+1; j<arr.length; j++) {
        //         if (arr[i]+arr[j] == target)
        //             count++;
        //     }
        // }

        return count!=0?count:-1;
    }
}