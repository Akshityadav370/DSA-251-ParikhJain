import java.util.ArrayList;
public class Solution {
    public static int[] helper(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (Integer x: arr) {
            max = Math.max(x, max);
            sum += x;
        }

        int[] help = new int[2];
        help[0] = max;
        help[1] = sum;

        return help;
    }
    public static boolean isValid(ArrayList<Integer> arr, int n, int k, int max) {
        int students = 1;
        int sum = 0;

        for (Integer book: arr) {
            sum += book;

            if (sum > max) {
                sum = book;
                students += 1;
            }
            if (students > k) {
                return false;
            }
        }

        return true;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if (m>n)    return -1;

        int res = -1;
        int help[] = helper(arr);
        int start = help[0];
        int end = help[1];

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (isValid(arr, n, m, mid)) {
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return res;
    }
}