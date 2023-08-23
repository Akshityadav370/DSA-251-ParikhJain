import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		// Brute force or Naive approach
		// O(N)
		// int ans = 1;

		// for (int i=1; i<=N; i++) {
		// 	if (i*i <= N)
		// 	ans = i;
		// 	else 
		// 	break;
		// }

		// return ans;

		// Binary Search
		// O(log N)
		if (N == 0 || N == 1) {
			return (int) N;
		}
		// int ans = 1;
		long low = 2, high = N;

		while(low<=high) {
			long mid = (high+low)/2;

			if (mid*mid <= N){
				// ans = (int)mid;
				low = mid+1;
			} else {
				high = mid-1;
			}
			
		}

		// return ans;
		return (int)high;
	}
}
