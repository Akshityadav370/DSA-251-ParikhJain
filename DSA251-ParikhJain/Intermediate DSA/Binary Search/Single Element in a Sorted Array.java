import java.util.ArrayList;
import java.util.HashMap;
public class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
        // Approach 2: 
        // HashMap, Time: O(N); Space: O(N)
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int i=0; i<arr.size(); i++) {
        //     Integer key = arr.get(i);
        //     map.putIfAbsent(key, 0);
        //     map.put(key, map.get(key) + 1);
        // }

        // for (Integer key: map.keySet()) {
        //     if (map.get(key) != 2)
        //         return key;
        // }
        // return -1;

        // Approach 1:
        // Linear Search, Time: O(N); Space: O(1)
        // int n = arr.size();

        // int answer = 0;

        // if (n == 1) {

        //     return arr.get(0);
        // }

        // for (int i = 0; i < n - 1; i += 2) {

        //     // If adjacent elements are not equal then update answer
        //     int first = arr.get(i);
        //     int second = arr.get(i + 1);

        //     if (first != second) {

        //         answer = arr.get(i);
        //         break;
        //     }
        // }

        // // Update answer
        // int last = arr.get(n - 1);
        // int secondLast = arr.get(n - 2);

        // if (last != secondLast) {

        //     answer = arr.get(n - 1);
        // }

        // return answer;

        // Approach 3
        // Bit Manipulation, Time: O(N); Space: O(1)
        // int answer = 0;

        // for (int element: arr) {
        //     answer ^= element;
        // }

        // return answer;

        // Approach 4
        // Binary Search, Time: O(N); Space: O(1)
        int n = arr.size();
        int low = 0, high = n - 1, mid;

        // Do binary search
        while (low < high) {

            // Calculate mid
            mid = (low + high) / 2;

            // Update low and high.
            if (mid % 2 == 1) {

                int a = arr.get(mid);
                int b = arr.get(mid - 1);

                if (a == b) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            else if (mid % 2 == 0) {

                int a = arr.get(mid);
                int b = arr.get(mid + 1);

                if (a == b) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
        }

        return arr.get(low);
    }
}