import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean isMatrixSymmetric(int[][] matrix) {
        // Write your code here.
        boolean flag = true;

        int n = matrix.length;
        int m = matrix[0].length;

        if (n!=m)   return false;

        // int[][] transpose = new int[n][m];

        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<m; j++) {
        //         transpose[i][j] = matrix[j][i];
        //     }
        // }

        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<m; j++) {
        //         if (transpose[i][j] != matrix[i][j])
        //             return false;
        //     }
        // }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (matrix[j][i] != matrix[i][j])
                    return false;
            }
        }

        return true;
    }
}