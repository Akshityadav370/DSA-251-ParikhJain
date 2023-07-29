import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
		// Write your code here.

		if(arr.length == 0)	return -1;

		Arrays.sort(arr);
		
		int largest = arr[n-1];

		// to find the second largest
		// there might be an array as such
		// ex: 1 2 3 4 4, so we just can't return arr[n-2]
		for(int i=n-2; i>=0; i--){
			if(arr[i]<largest)
				return arr[i];
		}

		return -1;

	}
}