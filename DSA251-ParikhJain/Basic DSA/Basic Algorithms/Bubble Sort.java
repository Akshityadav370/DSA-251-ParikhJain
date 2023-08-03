// import java.util.* ;
// import java.io.*; 

// public class Solution {
    

//     public static void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
//     public static void bubbleSort(int[] arr, int n) {   
//         // Write your code here.
//         for (int i=0; i<n-1; i++) {
//             for (int j = 0; j<n-i-1; j++) {
//                 if (arr[j] > arr[j+1])
//                     swap(arr, j, j+1);
//             }
//         }

//     }

// }

/*
    Time Complexity : O(N^2)
    Space Complexity : O(1)

    Where N is the length of the given array.
*/

public class Solution {

	public static void bubbleSort(int[] arr, int n) {

		// This is used to skip extra iterations in case of sorted array.
		boolean flag;

		for (int i = 0; i < n - 1; i++) {
			flag = false;

			for (int j = 0; j < n - i - 1; j++) { 

                // If the adjacent element is not sorted, swap the elements.
				if (arr[j] > arr[j + 1]) {
					
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					flag = true;
				}
			}
            
			// If the array is already sorted, break from the current loop iteration.
			if (flag == false) {
				break;
			}
		}

		return;
	}

}
