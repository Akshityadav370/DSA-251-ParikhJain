import java.util.* ;
import java.io.*; 
public class Solution {
	public static int minimumParentheses(String pattern) {
		// Write your code here.
		
		// Time - O(N)
		// Space - O(1)
		int open = 0, close = 0;
		// Look only for invalid paranthesis

		for (int i = 0; i<pattern.length(); i++) {
			// open the brackets whenever possible
			if (pattern.charAt(i) == '(')	open++;
			else {
				// if its not possible to make a pair then add the closed ones
				if (open == 0) 	close++;
				// closing the earlier opened brackets
				else open--;
			}
		}
		// for making each invalid bracket a valid one, we need to include its opposite one
		return (open + close);
	}
}