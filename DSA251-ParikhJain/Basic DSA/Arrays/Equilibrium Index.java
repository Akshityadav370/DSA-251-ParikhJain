// import java.util.* ;
// import java.io.*; 
// public class Solution {

// 	public static int arrayEquilibriumIndex(int[] arr){  
// 		//Your code goes here

// 		// Brute Force : O(n) - Time
//         //               O(1) - Space
// 		if(arr.length == 0) 	return -1;
		
// 		int n = arr.length, sum = 0;

// 		for(int i = 0; i<n; i++)
// 			sum += arr[i];

// 		int lsum = 0;
// 		for(int i = 0; i<n; i++){
// 			sum = sum - arr[i];

// 			if(lsum == sum)
// 				return i;
			
// 			lsum += arr[i];
// 		}

// 		return -1;
// 	}
// }


// Time: O(N)
// Space: O(N)
import java.util.* ;
import java.io.*; 
public class Solution {

	public static int arrayEquilibriumIndex(int[] arr){  
		//Your code goes here
		
		// Boundary Conditions
		if (arr.length == 1) 	return 0;
		if (arr.length == 2) 	return -1;

		int dup[] = new int[arr.length];

		dup[0] = arr[0];
		for(int i = 1; i<arr.length; i++){
			dup[i] = dup[i-1] + arr[i]; 
		}

		// LSum = dup[i] - arr[i]
		// Rsum = Total(dup[n-1]) - dup[i]

		for(int i= 0; i<arr.length; i++){
			int lsum = dup[i] - arr[i];
			int rsum = dup[arr.length - 1] - dup[i];

			if(lsum == rsum) {
				return i;
			}
		}

		return -1;
	}
}



