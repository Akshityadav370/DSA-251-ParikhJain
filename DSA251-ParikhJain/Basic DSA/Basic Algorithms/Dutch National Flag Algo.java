import java.util.* ;
import java.io.*; 
public class Solution 
{

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int[] arr)
    {
        //Write your code here

        // Brute Force : Sorting-> O(nlogn)
        // Better : maintaing couters for 0, 1, 2 -> O(2n)

        // Optimal : O(N)
        // a[0, low-1] -> 0 , extreme left
        // a[low, mid-1] -> 1
        // a[high+1, n-1] -> 2 , extreme right

        // 0 ..|0,0,...,0|.. (low-1)(low) ..|1,1,...,1|.. (mid-1)(mid) ..|1,2,0,1(unsorted)|.. (high)(high+1) ..|2,2,...,2|.. (n-1)
        // a[mid] == 0, swap (a, mid, low); low++, mid++
        // a[mid] == 1, mid++
        // a[mid] == 2, swap (a, mid, high); high--

        int low=0, mid=0, high=arr.length-1;

        while (mid<=high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                mid++;
                low++;
            }
            else if (arr[mid] == 1) {
                mid++;
            } 
            else {
                swap(arr, mid, high);
                high--;
            }
        }

    }
}