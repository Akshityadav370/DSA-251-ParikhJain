import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        

        // Approach 1: Sorting; Time: O(N*log(N)) Space: O(N)
        // if (str1.length()!=str2.length())   return false;

        // char[] ch1 = str1.toCharArray();
        // char[] ch2 = str2.toCharArray();

        // Arrays.sort(ch1);
        // Arrays.sort(ch2);

        // for (int i = 0; i<str1.length(); i++) {
        //     if (ch1[i] != ch2[i])   return false;
        // }

        // return true;

        // Approach 2: Hashing;
        //     Time complexity: O(N)
        //     Space complexity: O(Number of different characters). 
        if (str1.length() != str2.length()) {
			return false;
		}
		int NO_OF_CHARS = 256;

        // Create a count array and initialize all values as 0.
		int[] hash = new int[NO_OF_CHARS];
		for (int i = 0; i < NO_OF_CHARS; i++) {
			hash[i] = 0;
		}

        int i;
		/*
		   For each character in input strings,
		   increment count in the corresponding count array.
		*/
		for (i = 0; i < str1.length(); i++) {
			hash[str1.charAt(i)]++;
			hash[str2.charAt(i)]--;
		}

		// Check if all values in hash array are 0.
		for (i = 0; i < NO_OF_CHARS; i++) {
			if (hash[i] != 0) {
				return false;
			}
		}

        return true;
    }
}