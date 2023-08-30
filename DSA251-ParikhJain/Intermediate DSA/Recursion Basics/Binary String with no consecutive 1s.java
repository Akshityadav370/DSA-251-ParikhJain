import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void generateBinaryStrings(List<String> ans, int N, String currString) {
        if (N==0) {
            ans.add(currString);
        } else {
            if (currString.length()==0) {
                generateBinaryStrings(ans, N-1, currString+"0");
                generateBinaryStrings(ans, N-1, currString+"1");
            } else {
                generateBinaryStrings(ans, N-1, currString+"0");
                if (currString.charAt(currString.length()-1) != '1') 
                    generateBinaryStrings(ans, N-1, currString+"1");
            }
        }
    }

    public static List< String > generateString(int N) {
        // Write your code here.
        int length = N;
        List<String> ans = new ArrayList<>();
        generateBinaryStrings (ans, N, "");
        return ans;
    }
}
