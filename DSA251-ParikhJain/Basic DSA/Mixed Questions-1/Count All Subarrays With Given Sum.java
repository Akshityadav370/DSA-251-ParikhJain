import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.
        // Approach 1: Brute force (TLE error)
        // int count = 0;

        // for (int i=0; i<arr.length; i++) {
        //     int sum=0;
        //     for (int j=i; j<arr.length; j++) {
        //         // System.out.println(sum);
        //         sum += arr[j];
        //         if (sum==s)
        //             count+=1;
                
        //     }
        // }

        // return count;    

        // Approach 2: Using HashMaps & prefixSum array
        HashMap<Integer, Integer> prefixSums = new HashMap<>();

        int count = 0;
        int sum = 0;
        prefixSums.putIfAbsent(sum, 1);
        for (int i=0; i<arr.length; i++) {
            sum+=arr[i];
            if (prefixSums.containsKey(sum-s)) {
                count += prefixSums.get(sum-s);
            }
            if (prefixSums.containsKey(sum)) {
                prefixSums.put(sum, prefixSums.get(sum)+1);
            } else {
                prefixSums.put(sum, 1);
            }
        }   
        return count;
    }
}