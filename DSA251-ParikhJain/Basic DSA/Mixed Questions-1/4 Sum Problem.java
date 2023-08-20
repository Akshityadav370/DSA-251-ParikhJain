import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      // Write your code here.
      // Approach 1: Brute force (or) Naive
      // for (int i=0; i<n; i++) {
      //   for (int j=i+1; j<n; j++) {
      //     for (int k=j+1; k<n; k++) {
      //       for (int m=k+1; m<n; m++) {
      //         if (arr[i]+arr[j]+arr[k]+arr[m]==target) {
      //           return "Yes";
      //         }
      //       }
      //     }
      //   }
      // }
      // return "No";

      // Approach 2: Better (Sorting)
      //  First sort the array.
        Arrays.sort(arr);

        /* 
            Fix first two elements and find other 
            two elements using two pointer technique.
        */
        for (int i = 0; i < n - 3; ++i) {
            for (int j = i + 1; j < n - 2; ++j) {
                // First index of remaining elements.
                int left = j + 1;
                // Last index of remaining elements.
                int right = n - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    // If we found the target sum then we return Yes.
                    if (sum == target) {
                        return "Yes";
                    } else if (sum < target) {

                        /*
                            As we already sort the array this implies arr[left] < = arr[right]
                            And arr[right] is already having a greater value 
                            so we can not increase arr[right] further. In this case, we move 
                            forward through the left pointerb because 
                            arr[left+1] >= arr[left] to match up with the required sum.
                         */

                        ++left;
                    } else {

                        /*
                            If the sum is greater than target that means we need to 
                            decrease our current sum so in this case, we move 
                            backward through the right pointer because 
                            arr[right-1] <= arr[right] to match up with the required sum.
                         */

                        --right;
                    }
                }

            }
        }
        // If we can not found the target sum then we return No.
        return "No";
  }
}
