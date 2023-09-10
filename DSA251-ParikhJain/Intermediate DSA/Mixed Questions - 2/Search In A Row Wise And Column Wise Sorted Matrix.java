import java.util.* ;
import java.io.*; 
/*************************************
 
    Following is the Pair Class structure.
    
    class Pair{
        int x; int y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

*************************************/

public class Solution {
    // static class Pair {
    //     int x;
    //     int y;
    //     Pair (int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }
    // }
	public static Pair search(int [][] matrix, int x) {
		// Write your code here.
        int n = matrix.length;

        // 1. Brute Force
        // for (int i = 0; i<n; i++) {
        //     for (int j=0; j<n; j++) {
        //         if (matrix[i][j] == x)
        //             return new Pair(i, j);
        //     }
        // }

        // 2. Binary Search
        // for (int i=0; i<n; i++) {
        //     int low=0,high=n-1;
        //     while (low<=high) {
        //         int mid = (low+high)/2;
        //         if (matrix[i][mid] == x)
        //             return new Pair(i, mid);
        //         else if (matrix[i][mid] < x) 
        //             low = mid+1;
        //         else 
        //             high = mid-1;
        //     }
        // }

        // 3. Optimal
        if (n == 0) {
            return new Pair(-1, -1);
        }

        int i = 0; 
        int j = n - 1;

        while (i < n && j >= 0) {

            if (matrix[i][j] == x) {
                return new Pair(i, j);
            }
            // Move to the previous column.
            if (matrix[i][j] > x) {
                j--;
            } 
            // Move to the next row.
            else {
                i++;
            }
        }

        return new Pair(-1, -1);
	}
}
