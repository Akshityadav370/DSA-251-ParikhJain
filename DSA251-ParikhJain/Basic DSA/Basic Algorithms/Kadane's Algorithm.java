import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here

		// Approach 1
		// long maxSum = 0;
		// long currSum = 0;

		// for (int i = 0; i<n; i++) {
			
		// 	currSum += arr[i];

		// 	if (currSum > maxSum)
		// 		maxSum = currSum;

		// 	if (currSum < 0)
		// 		currSum = 0;
		// }

		// return maxSum;

		// Approach 2
		// long current_max= arr[0]; 

        // long global_max = arr[0];


        // for ( int  i=1 ; i< n; i++){

        //     current_max = Math.max(arr[i], current_max + arr[i]);

        //     if (current_max > global_max){

        //         global_max = current_max;

        //     }

        // }

        // return global_max<0? 0: global_max ;

		// Approach 3
		//meh = max ending here
		//msf = max so far

		long meh = 0, msf = 0;

		for (int i = 0; i<n; i++) {

			meh = meh + arr[i];
			if (meh < arr[i])
				meh = arr[i];
			if (msf < meh)
				msf = meh;
		}

		return msf<0 ? 0 : msf;



	}

}
