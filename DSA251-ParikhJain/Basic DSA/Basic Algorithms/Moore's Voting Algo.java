import java.io.*;
import java.util.* ;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		
		int ele=-1, count = 0;
		
		for (int i = 0; i<n; i++) {
			if (count == 0) {
				count = 1;
				ele = arr[i];
			}
			else if (arr[i] == ele) {
				count++;
			}
			else {
				count--;
			}
		}

		int count1 = 0;
		for (int i = 0; i<n; i++) {
			if (ele == arr[i]) count1++;
		}

		if (count1 > n/2) 	return ele;
		else return -1;
	}
}