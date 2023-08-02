// import java.util.* ;
// import java.io.*; 

// public class Solution {

// 	public static void swap(int[] arr, int i, int j) {
// 		int temp = arr[i];
// 		arr[i] = arr[j];
// 		arr[j] = temp;
// 	}

// 	public static void insertionSort(int n , int[] arr) {
// 		// Write your code here.

// 		int i = 1; 

// 		while (i<n) {
// 			int j = i;
// 			int temp = arr[j--];

// 			while (j>=0 && arr[j]>temp) {
// 				// swap(arr, j, j+1);
// 				arr[j+1] = arr[j];
// 				j--;
// 			}

// 			arr[j+1] = temp;
// 			i++;
// 		}
// 	}
// }

/*
	Time complexity: O(N^2)
	Space complexity: O(1)
	
	Where 'N' is the size of the array.
*/

public class Solution {

	public static void insertionSort(int n , int[] arr) {

		// To traverse all the elements.
		for (int i = 1; i < n; ++i) {

			// To store the current element.
			int curr = arr[i];

			// To traverse previous elements.
			int idx = i - 1;

			while (idx >= 0 && arr[idx] > curr) {

				// Change elements position.
				arr[idx + 1] = arr[idx];

				--idx;
			}

			// Change current element.
			arr[idx + 1] = curr;
		}

	}

}

