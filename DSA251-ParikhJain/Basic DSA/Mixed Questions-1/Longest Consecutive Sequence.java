import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.

        // Brute Force
        // Time: O(N*logN)
        // Space: O(1)
        // int count = 1;
        // int n=N;
        // int maxCount = 1;
        // Arrays.sort(arr);
        // for (int i = 1; i<n; i++) {
        //     if (arr[i]==(arr[i-1]+1)){
        //         count += 1;
        //         maxCount = Math.max(maxCount, count);
        //     }
        //     else if (arr[i]==arr[i-1])
        //         continue;
        //     else 
        //         count = 1;
        // }

        // return maxCount;

        // Using HashSet
        // Time: O(n)
        // Space: O(n)
        int maxCount = 0;

        HashSet<Integer> set = new HashSet<>();

        for (Integer element: arr)
            set.add(element);

        for (Integer element: arr) {
            int previousConsecutiveElement = element-1;

            if (!set.contains(previousConsecutiveElement)) {
                int j = element;

                while(set.contains(j)) {
                    j++;
                }

                maxCount = Math.max(maxCount, j-element);
            }
        }
        
        return maxCount;
    }
}