import java.util.* ;
import java.io.*; 
public class Solution {

    public static void swap(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int left, int right) {
        int temp = arr1.get(left);
        arr1.set(left, arr2.get(right));
        arr2.set(right, temp);
    }
    
    public static int findKthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {
        // Write your code here.
        // Approach 1 
        // Time Complexity: O(M + N)
        // Space Complexity: O(1)
        int left = arr1.size()-1;
        int right = 0;
        
        int n=arr1.size(), m=arr2.size();

        while ((left>=0&&right<m) && arr1.get(left) >= arr2.get(right)) {
            swap(arr1, arr2, left, right);
            left--;
            right++;
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        
        // for (Integer x: arr1) {
        //     System.out.print(x+" ");
        // }
        // System.out.println();
        // for (Integer x: arr2) {
        //     System.out.print(x+" ");
        // }
        // System.out.println();
        
        if (k<=n) {
            // System.out.println(k);
            return arr1.get(k-1);
            
        }
        else {
            k = k-n;
            // System.out.println(k);
            return arr2.get(k-1);
        }
        
    }
}