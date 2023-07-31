import java.util.* ;
import java.io.*; 
public class Solution {
	
	public static boolean allNines(String number) {
		
		for (int i = 0; i<number.length(); i++) {
			if (number.charAt(i) != '9')
				return false;
		}
		
		return true;
	}

	public static boolean allZeros(String number) {
		
		for (int i=0; i<number.length(); i++) {
			if (number.charAt(i) != '0') 
				return false;
		}

		return true;
	}

	
	public static String nextLargestPalindrome(String number, int length) {
		// Write your code here.
		
		if (allNines(number)) {
			String temp = "1";
			for(int i=0; i<length-1; i++) {
				temp+= "0";
			}
			temp += "1";

			return temp;
		}

		if (allZeros(number)) {
			String temp = "0";
			for(int i=0; i<length-2; i++) {
				temp+= "1";
			}
			temp+= "0";

			return temp;
		}
		
		char[] n = number.toCharArray();
		
		// Setting our pointers from the mid of the number
		// Initially, it is set to the mid for odd no's, 
		// for even no's on either side
		int leftP = length/2, rightP = length/2;

		if (length%2 == 0) {
			leftP--;
		}
		
		// Skipping the part of the number where it is already palindrome
		while(leftP>=0 && n[leftP] == n[rightP]) {
			leftP--;
			rightP++;
		}

		if (leftP < 0 || n[leftP] < n[rightP]) {
			
			// Resetting our pointers
			leftP = length/2;
			rightP = length/2;
			
			if (length%2 == 0) {
				leftP--;
			}

			int carry = 1;
			
			// Adding a carry to the left part & 
			// pasting the left part onto the right part
			while (leftP >= 0) {
				
				int num = (n[leftP] - '0') + carry; // Subtracting '0' -> converts char to int
				carry = num / 10;
				n[leftP] = (char)(num % 10 + '0'); // Adding '0' -> converts int to char
				n[rightP] = n[leftP];
				rightP++;
				leftP--;
 			}
		} else {
			// case where the left digit is already greater than right digit of the symmetry line
			while (leftP >= 0) {
				n[rightP] = n[leftP];
				rightP++;
				leftP--;
			}
		}
		
		String ans = String.valueOf(n);

		return ans;
	}
}