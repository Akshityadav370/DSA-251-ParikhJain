import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {
		// Write your code here.
		Map<String, ArrayList<String>> groupedAnagrams = new HashMap<>();
		
		for (String str: inputStr) {
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);

			String sortedStr = String.valueOf(charArr);
			
			if (!groupedAnagrams.containsKey(sortedStr)) {
				groupedAnagrams.put(sortedStr, new ArrayList<>());
			}

			groupedAnagrams.get(sortedStr).add(str);
		}

		return new ArrayList<>(groupedAnagrams.values());
	}
}
