import java.util.* ;
import java.io.*; 
public class Solution {
	public static boolean isPossible(int[] arr, int n) {
		// Write your code here.
		boolean changed = false;

		for(int i = 0; i<n-1; i++){
			if(arr[i] <= arr[i+1])
				continue;
				
			if (changed) 
				return false;

			// Decreasing the element
			// [3, 4, 2]
			// Left one
			if (i==0 || arr[i+1] >= arr[i-1])
				arr[i] = arr[i+1];
			// Right one
			else
				arr[i+1] = arr[i];
			changed = true;
		}

		return true;
	}
}