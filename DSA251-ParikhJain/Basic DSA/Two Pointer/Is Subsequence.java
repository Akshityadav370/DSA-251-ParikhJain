import java.util.* ;
import java.io.*; 
public class Solution {

	public static String isSubsequence(String str1, String str2) {    
    	// Write your code here.


		// Two Pointer Approach 1
		// int i1 = 0, j1 = str1.length()-1;

		// int i2 = 0, j2 = str2.length()-1;

		// while (i1<=j1 && i2<=j2) {
		// 	if (str1.charAt(i1) == str2.charAt(i2)) {
		// 		i1++;
		// 		i2++;
		// 	} else {
		// 		i2++;
		// 	}
		// 	if (str1.charAt(j1) == str2.charAt(j2)) {
		// 		j1--;
		// 		j2--;
		// 	} else {
		// 		j2--;
		// 	}
		// }

		// if (i1>j1) {
		// 	return "True";
		// } else {
		// 	return "False";
		// }

		// Two Pointer Approach 2
		int s1=str1.length(),s2=str2.length();

		int curCh=0,i=0;

		while(i<s2 && curCh<s1){
			if(str1.charAt(curCh) == str2.charAt(i)){
				curCh++;
			}
			i++;
		}

		return (curCh==s1)?"True":"False";
	}

}