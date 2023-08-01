import java.util.* ;
import java.io.*; 
public class Solution {

	public static char firstNonRepeatingCharacter(String str) {

		// Write your code here
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i<str.length(); i++) {
			
			if (map.containsKey(str.charAt(i))) {
				int value = map.get(str.charAt(i)) + 1;
				map.put(str.charAt(i), value);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		
		for (int i = 0; i<str.length(); i++) {
			
			if (map.get(str.charAt(i)) == 1)
				return str.charAt(i);
		}
	
		return str.charAt(0);	
	}
}