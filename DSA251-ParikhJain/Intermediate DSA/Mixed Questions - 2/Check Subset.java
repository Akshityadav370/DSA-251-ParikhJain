import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
    // public static boolean search(int[] arr1, int n, int a2) {
    //     for (int i = 0; i<n; i++) {
    //         if (arr1[i] == a2) {
    //             arr1[i] = Integer.MIN_VALUE;
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public static boolean checkSubset(int[] arr1, int[] arr2, int n, int m) {
        // Write your code here.

        // Brute Force (My Approach) (TLE)
        // if (m>n) return false;

        // for (int a2: arr2) {
        //     if (!search(arr1, n, a2)) {
        //         return false;
        //     }
        // }

        // return true;

        // HashMap Approach
        // Map<Integer, Integer> map1 = new HashMap<>(); 

        // for (int a1: arr1) {
        //     map1.putIfAbsent(a1, 0);
        //     map1.put(a1, map1.get(a1) + 1);
        // }

        // for (int a2: arr2) {
        //     if (!map1.containsKey(a2)) {
        //         return false;
        //     } else {
        //         int value = map1.get(a2);
        //         if (value == 0)     return false;
        //         else    value-=1;
        //         map1.put(a2, value);
        //     }
        // }

        // return true;

        // Brute Force 2 (TLE)
        if (m > n) {
            return false;
        }
        // For every arr2 element check if it is present in arr1 or not.
        for (int i = 0; i < m; i++) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (arr2[i] == arr1[j]) {
                    // Replace arr1[i] to -1, so that duplicates numbers can be handled.
                    arr1[j] = -1;
                    break;
                }
            }
            // If arr2[j] is not present in arr1.
            if (j == n) {
                return false;
            }
        }
        // If we reach here then all elements of arr2 are present in arr1.
        return true;

    }
}