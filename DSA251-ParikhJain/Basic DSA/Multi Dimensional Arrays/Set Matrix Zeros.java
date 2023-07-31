import java.io.*;
import java.util.* ;

public class Solution {
    public static void setZeros(int matrix[][]) {
        // Write your code here..

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] rowzero = new boolean[n];
        boolean[] colzero = new boolean[m];

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if (matrix[i][j] == 0) {
                    rowzero[i] = true;
                    colzero[j] = true;
                }

        for (int i = 0; i<n; i++) 
            if (rowzero[i]) {
                for(int j = 0; j<m; j++)
                    matrix[i][j] = 0;
            }

        for (int j = 0; j<m; j++)
            if (colzero[j]) {
                for(int i=0; i<n; i++)
                    matrix[i][j] = 0;
            }
    }

}