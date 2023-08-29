import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution
{	

	public static int countSmallerThanAndEqualToMid (ArrayList<Integer> arr, int mid) {
		int l=0, h=arr.size()-1;

		while (l<=h) {
			int md = (l+h)/2;

			if (arr.get(md) <= mid) {
				l = md+1;
			} else {
				h = md-1;
			}
		}

		return l;
	}
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
		// Approach 1: Brute Force
		// Time: O((n*m)log(n*m)), Space: O(n*m)
		// ArrayList<Integer> arr = new ArrayList<>();

		// int n = matrix.size();
		// int m = matrix.get(0).size();

		// for (int i=0; i<n; i++) {
		// 	for (int j=0; j<m; j++) {
		// 		arr.add(matrix.get(i).get(j));
		// 	}
		// }

		// // Arrays.sort(arr);
		// Collections.sort(arr);

		// int total = n*m;
		// int mid = (total-1)/2;
		// return arr.get(mid);


		// Approach 2: Binary Search (Efficient)
		int n = matrix.size();
		int m = matrix.get(0).size();

		int low = 1, high = 100000;

		while (low<=high) {

			int mid = (low+high)/2;
			int count = 0;

			for (int i=0; i<n; i++) {
				count += countSmallerThanAndEqualToMid(matrix.get(i), mid);
			}

			if (count <= (n*m/2)) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}

		return low;
	}

}
// CN solution
/*
    Time Complexity : O(N * log(M) * log(MAX - MIN) )
    Space Complexity : O(1)

    Where 'N' is the number of rows,
    and 'M' is the number of columns in the given matrix,
    and 'MAX' and 'MIN' are the minimum and maximum element of the matrix, respectively.
*/

// import java.util.ArrayList;

// public class Solution 
// {
// 	// It returns the index of the first element in the range [first, last) which compares grater than val.
// 	private static int upper_bound(ArrayList<Integer> arr, int first, int last, int val) 
// 	{
// 		// Initialise the "low" and "high" appropriately.
// 		int low = first, high = last;
		
// 		while (low < high) 
// 		{
// 			int mid = (low + high) / 2;

// 			if (arr.get(mid) > val) 
// 			{
// 				// If the current element is less than val, reduce the search space to left half.
// 				high = mid;
// 			} 
// 			else 
// 			{
// 				// If the current element is greater than or equal to val, reduce the search space to right half.
// 				low = mid + 1;
// 			}
// 		}

// 		return low;
// 	}

// 	public static int getMedian(ArrayList<ArrayList<Integer>> matrix) 
// 	{
// 		int n = matrix.size();
// 		int m = matrix.get(0).size();

// 		// Since, 1 <= matrix.get(i).get(j) <= 10^5, set the "low" and "high" value accordingly.
// 		int low = 1, high = 100000;

// 		// Loop until our search spaces convergers to single element.
// 		while (low < high) 
// 		{

// 			int mid = (low + high) / 2;

// 			// To count number of elements less than or equal to "mid".
// 			int count = 0;

// 			// Iterate through each row and increment the "count".
// 			for (int i = 0; i < n; i++) 
// 			{
// 				/*
// 				    NOTE:
// 				    upper_bound (ForwardIterator first, ForwardIterator last, const T& val);
// 				    Returns an iterator pointing to the first element in the range [first,last) which compares greater than val.
// 				*/
// 				count = count + upper_bound(matrix.get(i), 0, matrix.get(i).size(), mid);
// 			}

// 			if (count >= (n * m + 1) / 2) 
// 			{
// 				// The median will lie in the range of ["mid", "high"].
// 				high = mid;
// 			} 
// 			else 
// 			{
// 				// The median will lie in the range of ["mid" + 1, "high"].
// 				low = mid + 1;
// 			}
// 		}
// 		return low;
// 	}
// }