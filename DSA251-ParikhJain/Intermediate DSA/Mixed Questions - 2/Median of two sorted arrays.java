public class Solution {
    // public static double median(int[] a, int[] b) {
    // 	// Write your code here.
    //     int n1 = a.length, n2 = b.length;
    //     int i=0, j=0;
        
    //     int n = (n1+n2);
    //     int ind2 = n/2;
    //     int ind1 = ind2-1;

    //     int count = 0;
    //     int ind1el = -1, ind2el = -1;

    //     while (i<n1 && j<n2) {
    //         if (a[i] <  b[j]) {
    //             if (count == ind1)  ind1el = a[i];
    //             if (count == ind2)  ind2el = a[i];
    //             count++;
    //             i++;
    //         } else {
    //             if (count == ind1)  ind1el = b[j];
    //             if (count == ind2)  ind2el = b[j];
    //             count++;
    //             j++;
    //         }
    //     }
    //     while (i<n1) {
    //         if (count == ind1)  ind1el = a[i];
    //         if (count == ind2)  ind2el = a[i];
    //         count++;
    //         i++;
    //     }
    //     while (j<n2) {
    //         if (count == ind1)  ind1el = b[j];
    //         if (count == ind2)  ind2el = b[j];
    //         count++;
    //         j++;
    //     }

    //     if (n%2 == 1)
    //         return ind2el;
    //     else {
    //         double ans = ((double)(ind1el+ind2el))/2.0;
    //         return ans;
    //     }
    // }
    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

}