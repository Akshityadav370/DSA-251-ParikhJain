// import java.util.* ;
// import java.io.*; 
// public class Solution {
//     public static void swap(List<Integer> arr, int i, int j){
//         int temp = arr.get(i);
//         arr.set(i, arr.get(j));
//         arr.set(j, temp);
//     }
    
//     public static int partition(List<Integer> a, int si, int ei){
//         int pe = a.get(si);
//         int count = 0;
        
//         for(int i = si+1; i<=ei; i++)
//             if(a.get(i)<pe)
//                 count++;
        
//         swap(a, si, si+count);
        
//         int i = si, j = ei;
        
//         while(i<j){
//             if(a.get(i)<pe)
//                 i++;
//             else if(a.get(j)>=pe)
//                 j--;
//             else{
//                 swap(a, i, j);
//                 i++;
//                 j--;
//             }
//         }
//         return si+count;
//     }
    
//     public static void qs(List<Integer> arr, int si, int ei){
//         if(si>=ei)	return;
        
//         int pi = partition(arr, si, ei);
        
//         qs(arr, si, pi-1);
//         qs(arr, pi+1, ei);
//     }
// 	// public static void quickSort(int[] input) {
// 	// 	/* Your class should be named Solution
// 	// 	 * Don't write main().
// 	// 	 * Don't read input, it is passed as function argument.
// 	// 	 * No need to print or return the output.
// 	// 	 * Taking input and printing output is handled automatically.
// 	// 	 */
// 	// 	qs(input, 0, input.length-1);
        
// 	// }
	
//     public static List<Integer> quickSort(List<Integer> arr){
//         // Write your code here.
//         qs(arr, 0, arr.size()-1);
//         return arr;
//     }
// }
/*
    Time Complexity: O(N ^ 2)
    Space Complexity: O(N)

    Where 'N' is the size of the array.
*/

import java.util.Collections;
import java.util.List;

public class Solution {
    public static void quickSortHelper(List<Integer> arr, int l, int r){
		// Base condiition.
        if(l >= r){
            return;
        }

        int pivot = arr.get(r);

        int i = l, j = l;
		// Splitting the array.
        while(i < r){

            if(arr.get(i) <= pivot)
            {
                Collections.swap(arr, i, j);
                j++;
            }
            i++;
        }

        Collections.swap(arr, r, j);

		// Call quickSortHelper on both halves.
        quickSortHelper(arr, l, j - 1);

        quickSortHelper(arr, j + 1, r);
    }

    public static List<Integer> quickSort(List<Integer> arr) {

        quickSortHelper(arr, 0, arr.size() - 1);

        return arr;    
    }

}


