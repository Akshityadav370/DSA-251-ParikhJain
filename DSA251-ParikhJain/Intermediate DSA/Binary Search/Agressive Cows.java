import java.util.*;
public class Solution {
    public static boolean canWePlaceCows(int[] stalls, int dist, int totalCows) {
        
        int countCows = 1, lastCow = stalls[0];

        for (int i=1; i<stalls.length; i++) {
            if (stalls[i]-lastCow >= dist) {
                countCows += 1;
                lastCow = stalls[i];
                if (countCows >= totalCows)     return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        // Approach 1: Linear Search
        // Time Complexity = O(N^2)
        // Space Complexity = O(log(N))
        // Arrays.sort(stalls);

        // int dist = stalls[stalls.length-1] - stalls[0];
        // int ans = 1;
        // for (int i=1; i<=dist; i++) {
        //     if (canWePlaceCows(stalls, i, k)){
        //         ans = i;
        //     }
        // }

        // return ans;

        // Approach 2: Binary Search
        // Time Complexity = O(N * log(N))
        // Space Complexity = O(log(N))
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n-1] - stalls[0];

        while (low<=high) {
            int mid = (low+high)/2;
            if (canWePlaceCows(stalls, mid, k)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return high;

    }
}