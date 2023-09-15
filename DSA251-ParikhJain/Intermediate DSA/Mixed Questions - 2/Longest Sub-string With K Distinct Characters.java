// import java.util.* ;
// import java.io.*; 
// public class Solution {
// 	public static int getLengthofLongestSubstring(String s, int k) {
// 		// Write your code here.
// 		int ans = 0;
// 		int i=-1, j=-1;

// 		HashMap<Character, Integer> map = new HashMap<>();
// 		while (true) {
// 			boolean f1=false, f2=false;

// 			// Loop to add substring of k distinct characters
// 			while (i < s.length()-1) {
// 				f1 = true;
// 				i++;

// 				char ch = s.charAt(i);
// 				map.put(ch, map.getOrDefault(ch, 0) + 1);
// 				int len = i-j;
// 				if (map.size() < k) {
// 					ans = Math.max(ans, len);
// 					continue;
// 				} else if (map.size() == k) {
// 					ans = Math.max(ans, len);
// 				} else {
// 					break;
// 				}
// 			}
// 			// f1 = false;
// 			// Loop to remove more than k distinct chars from the substring
// 			while (j < i) {
// 				f2 = true;
// 				j++;

// 				char ch = s.charAt(j);
// 				if (map.get(ch) == 1) {
// 					map.remove(ch);
// 				} else {
// 					map.put(ch, map.get(ch) - 1);
// 				}

// 				if (map.size() > k) {
// 					continue;
// 				} else if (map.size() == k) {
// 					int len = i - j;
// 					if (len > ans) {
// 						ans = len;
// 					}
// 					break;
// 				}
// 			}

// 			if (f1==false && f2==false)	break;
			
// 		}

// 		return ans;
// 	}
// }
/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    Where N is the size of the string.
*/

public class Solution {

    // Returns the number of distinct characters in the array 'freq'.
    public static int countDistinct(int[] freq) {
        int distinct = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                distinct++;
            }
        }

        return distinct;
    }

    public static int getLengthofLongestSubstring(String s, int k) {

        int longestLength = 0;
        int n = s.length();

        int freq[] = new int[26];

        // Starting index of the window.
        int start = 0;

        // Traverse for ending index of the window.
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;

            while (countDistinct(freq) > k) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }

            longestLength = Math.max(longestLength, i - start + 1);
        }

        return longestLength;
    }
}