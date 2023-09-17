public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        // 1.Brute Force
        // for (int i=1; i<31; i++) {
        //     int no=1;
        //     for (int j=0; j<n; j++) {
        //         no = no*i;
        //     }
        //     if (no==m)  return i;
        // }
        // return -1;

        // 2. Binary Search
        int low = 1, high = m;

        while (low<=high) {
            int mid = low + (high-low)/2;
            double no = Math.pow(mid, n);
            
            if (no == m)    return mid;
            else if(no>m)   high = mid-1;
            else    low = mid+1;
        }
        return -1;
    }
}
