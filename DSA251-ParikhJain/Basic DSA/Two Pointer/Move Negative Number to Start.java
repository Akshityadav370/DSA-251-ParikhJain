public class Solution {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] separateNegativeAndPositive(int a[]) {
        int i = 0, j = a.length-1; 

        while (i<j) {
            // + & -
            if (a[i] >= 0 && a[j] < 0){
                swap(a, i, j);
                i++;
                j--;
            }
            // + & +
            else if ( a[i] >= 0 && a[j]>=0) {
                j--;
            }
            // - & +
            else if (a[i] < 0 && a[j]>=0 ) {
                i++;
            }
            // - & -
            else {
                i++;
                // j--;
            }
        }

        return a;
    }
}