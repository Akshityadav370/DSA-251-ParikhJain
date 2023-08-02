// import java.util.* ;
// import java.io.*; 
// public class Solution {
// 	public static void selectionSort(int arr[], int n) {
// 		// Write your code here.

// 		int pivot = 0, min = Integer.MAX_VALUE;
// 		int pointer = 0;

// 		while (pivot < n) {

// 			min = Integer.MAX_VALUE;
// 			for (int i=pivot; i<n; i++) {
// 				while (arr[i] < min) {
// 					min = arr[i];
// 					// storing the min elements position.
// 					pointer = i;
// 				}
// 			}
// 			// swapping the min element to its correct position (pivot)
// 			int temp = arr[pivot];
// 			arr[pivot] = arr[pointer];
// 			arr[pointer] = temp;

// 			pivot++;
// 		}

// 	}
// }
/*
    Time Complexity : O(N^2)
    Space Complexity : O(1)

    Where 'N' is the length of the given array.
 */

public class Solution {
	// This function is used to swap two elements of the array.

	public static void selectionSort(int arr[], int n) {
		int minVal;

		// This is used to iterate over all elements of array.
		for (int i = 0; i < n - 1; i++) {
			// This is used to store the minimum value index.
			minVal = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[minVal]) {
					minVal = j;
				}

			// Swapping the minimum element with the first element.
			int temp = arr[minVal];
			arr[minVal] = arr[i];
			arr[i] = temp;
		}
	}
}