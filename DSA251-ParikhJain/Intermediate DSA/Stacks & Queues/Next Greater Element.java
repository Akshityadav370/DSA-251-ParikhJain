import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here

		// Approach 1: Iterative (TLE)
		// int[] res = new int[n];

		// for (int i = 0; i<n; i++) {
		// 	int ele = arr[i];
		// 	int ans = -1;
		// 	for (int j = i+1; j<n; j++) {
		// 		if (arr[j]>ele) {
		// 			ans = arr[j];
		// 			break;
		// 		}
		// 	}
		// 	res[i] = ans;
		// }

		// return res;

		// Approach 2: Using Stack
		int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];

            // Pop elements from the stack while they are smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If the stack is empty, there is no greater element to the right
            // Otherwise, the top element of the stack is the next greater element
            res[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element onto the stack
            stack.push(current);
        }
		
		return res;

		
	}

}
