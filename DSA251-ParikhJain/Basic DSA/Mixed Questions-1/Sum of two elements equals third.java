import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static  ArrayList<Integer> findTriplets(int[] arr, int n) 
    {
	    //Write your code here.
		// Brute Force 1
		ArrayList<Integer> ans = new ArrayList<>();
		// for (int i=0; i<n; i++) {
		// 	for (int j=i+1; j<n; j++) {
		// 		for (int k=j+1; k<n; k++) {
		// 			if ((arr[i] + arr[j] == arr[k]) || (arr[j] + arr[k] == arr[i]) || (arr[k] + arr[i] == arr[j])) {
        //                 ans.add(arr[i]);
        //                 ans.add(arr[j]);
        //                 ans.add(arr[k]);

        //                 return ans;
        //             }
		// 		}
		// 	}
		// }
		// return ans;
		
		// Using sets
		// HashSet<Integer> set = new HashSet<>();
		
		// for (int i = 0; i<n; i++) {
		// 	for (int j=i+1; j<n; j++) {
		// 		if (set.contains(arr[i]+arr[j])) {
		// 			ans.add(arr[i]+arr[j]);
		// 			ans.add(arr[i]);
		// 			ans.add(arr[j]);
					
		// 			return ans;
		// 		} else {
		// 			set.add(arr[j]);
		// 		}
		// 	}
		// 	set.add(arr[i]);
		// }
		// return ans;

		// Sorting the arr.
		Arrays.sort(arr);

		for (int i = n - 1; i >= 0; i--) 
        {

			int j = 0;
			int k = i - 1;

			// Use two pointer technique to find the required triplet.
			while (j < k) 
            {

				// If we find a valid triplet.
				if (arr[i] == arr[j] + arr[k]) 
                {
					ans.add(arr[i]);
					ans.add(arr[j]);
					ans.add(arr[k]);
					return ans;
				}

				// If the current element is greater than the sum of the other two, increment j.
				else if (arr[i] > arr[j] + arr[k]) 
                {
					j = j + 1;
				}

				// If the current element is smaller than the sum of the other two, decrement k.
				else 
                {
					k = k - 1;
				}
			}
		}
		return ans;
		
	}
}