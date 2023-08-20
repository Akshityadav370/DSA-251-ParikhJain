import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int calculateSquareSum(ArrayList<ArrayList<Integer>> arr, int p, int q, int k) {
		int sum=0;
		for (int i=p; i<k+p; i++) {
			for (int j=q; j<k+q; j++) {
				sum += arr.get(i).get(j);
			}
		}	
		return sum;
	}

	public static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(ArrayList<ArrayList<Integer>> arr, int k) {

		//    Write your code here.
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		if (arr.size()==0 || k==0)	return ans;

		int n = arr.size();

		for (int i=0; i<=n-k; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j=0; j<=n-k; j++) {
				// if ((i+k-2)<n && (j+k-2)<n) {
					int newEle = calculateSquareSum(arr, i, j, k);
					temp.add(newEle);
				// }
			}
			ans.add(temp);
		}

		return ans;
	}
}
