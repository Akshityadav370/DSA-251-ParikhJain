import java.io.*;
import java.util.* ;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.

		// Approach 1: Finding out all subarrays and their sum
		// int len = 0;

		// for (int i = 0; i<arr.size(); i++) {
		// 	int sum = arr.get(i);
		// 	if (sum == 0) {
		// 		if (len < 1) {
		// 			len = 1;
		// 		}
		// 	}

		// 	for (int j = i+1; j<arr.size(); j++) {
		// 		sum += arr.get(j);
		// 		if (sum == 0) {
		// 			int n = j-i+1;
		// 			if (len<n) {
		// 				len = n;
		// 			}
		// 		}
		// 	}
		// }

		// return len;

		// Approach 2: Using prefixSum array & HashMap (prefixSums, index)
		// Map to store the previous sums
		Map<Integer, Integer> presum = new HashMap<>();

		int sum = 0; // sum of the elements
		int maxLen = 0; 
		int n = arr.size();

		for (int i = 0; i<n; i++) {

			sum += arr.get(i);

			if (arr.get(i) == 0 && maxLen==0)
				maxLen = 1;
			if (sum==0)
				maxLen = i+1;

			// Look for this sum in hashtable
			if (presum.containsKey(sum)) {
				// if sum is seen before , then update maxLen
				maxLen = Math.max(maxLen, i-presum.get(sum));
			} else {
				presum.put(sum, i);
			}
		}

		return maxLen;

	}
}