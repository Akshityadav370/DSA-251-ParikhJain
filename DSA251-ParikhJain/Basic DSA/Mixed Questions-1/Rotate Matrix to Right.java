import java.util.* ;
import java.io.*; 
// public class Solution {
// 	public static int[][] rotateMatRight(int[][] mat, int n, int m, int k) {
// 		// Write your code here.
		
// 		int[][] ans = new int[n][m];

// 		for(int i=0; i<n; i++)
// 			for(int j=0; j<m; j++) {
// 				if ((j+k)<m) {
// 					ans[i][j+k] = mat[i][j];
// 				} else {
// 					ans[i][(j+k)%m] = mat[i][j];
// 				}
// 			}

// 		return ans;
// 	}
// }
/*
    Time Complexity: O(N * M)
    Space Complexity: O(1)

    Where 'N' and 'M' denote the number of rows and columns of the given matrix.
*/

public class Solution {
	public static void rotateRightByK(int temp[], int k) {
		int i = 0, j = temp.length - 1;
		// Reversing the whole array row.
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;
		}
		// Reversing first 'K' elements.
		i = 0;
		j = k - 1;
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;

		}
		i = k;
		j = temp.length - 1;
		// Reversing the rest 'N' - 'K' elements.
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;
		}
	}

	public static int[][] rotateMatRight(int[][] mat, int n, int m, int k) {
		// Array to store the answer matrix sequence.
		int result[][] = new int[n][m];
		int resultIndex = 0;

		// Calculating effective rotations.
		k = k % m;

		// Iterating for each row and appending after rotations to the answer sequence.
		for (int i = 0; i < n; i++) {
			// Calling the function to rotate the row 'K' times.
			rotateRightByK(mat[i], k);

			// Append row 'i' to the answer sequence after rotation.
			result[resultIndex++] = mat[i];
		}
		// Return the answer sequence.
		return result;
	}
}