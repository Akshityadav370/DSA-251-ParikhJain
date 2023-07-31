import java.util.* ;
import java.io.*; 
public class Solution {
	public static String encode(String message) {
		// Write your code here.
		StringBuilder ans = new StringBuilder();

		for(int i = 0; i<message.length();i++) {
			char currChar = message.charAt(i);
			int currFreq = 1;

			while(i+1 < message.length() && message.charAt(i+1) == currChar) {
				i++;
				currFreq++;
			}
			ans.append(currChar);
			ans.append(currFreq);
		}
		return ans.toString();
	
		}
	}
