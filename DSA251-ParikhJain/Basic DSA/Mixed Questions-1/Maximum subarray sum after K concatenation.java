import java.util.* ;
import java.io.*; 
public class Solution {

	public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
		// Write your code here.
		long count = 0, maxSum = Integer.MIN_VALUE;

		for (int i=-1; i<n*k-1; i++) {
			if (count<0)
				count = 0;
			count += arr.get((i+1)%n);
			maxSum = Math.max(maxSum, count);
		}

		return maxSum;
	}
}