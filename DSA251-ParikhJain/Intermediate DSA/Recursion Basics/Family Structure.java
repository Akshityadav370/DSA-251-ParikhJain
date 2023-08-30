public class Solution {
	public static String kthChildNthGeneration(int n, long k) {
		// Write your code here
		// Time Complexity: O(min(N, log(K)))
    	// Space Complexity: O(N)
		if (n==1 || k==1) return "Male";

		long parentK = (k+1)/2;

		String parent = kthChildNthGeneration(n-1, parentK);

		// First Child
		if (k%2 == 1) {
			return parent;
		}
		// Second Child
		else {
			if (parent=="Male")	return "Female";
			else 	return "Male";
		}
	}

}