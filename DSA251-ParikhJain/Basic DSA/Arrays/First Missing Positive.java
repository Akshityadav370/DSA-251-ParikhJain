import java.util.* ;
import java.io.*; 
public class Solution {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int firstMissing(int[] arr, int n) {
		// Write your code here.		
		
		// Check which number is first missing from 1 to n
		for(int i = 0; i<n; i++) {
			int element = arr[i];

			if(element>0 && element<n) {
				int chair = element - 1;
				
				if(arr[chair] != element) {
					swap(arr, chair, i); // arr[i] is the element
					i--; // if the swapped element is in its position or not
				}
			}
		}

		for(int i = 0; i<n; i++) {
			if (i+1 != arr[i]) return i+1;
		}

		return n+1;
	}
}
