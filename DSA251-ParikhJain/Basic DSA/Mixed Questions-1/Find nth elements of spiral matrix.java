import java.util.* ;
import java.io.*; 
public class Solution {

	public static int findKthElement(int[][] matrix, int k) {
	    // Write your code here.
		int total = matrix.length*matrix[0].length;
		int count = 1;

		int rs = 0, re = matrix.length-1;
		int cs = 0, ce = matrix[0].length-1;
		int temp = k+1;
		int p=0, q=0;
		while(count<temp && count<=total) {
			p=rs; q=cs;
			for (int i=cs; (count<temp&&count<=total) && i<=ce; i++, count++) {
				if (count==k)
					return matrix[rs][i];
				q+=1;
			}
			rs++;
			p=rs; q=ce;
			for (int i=rs; (count<temp&&count<=total) && i<=re; i++, count++) {
				if (count==k)
					return matrix[i][ce];
				p+=1;
			}
			ce--;
			p=re; q=ce;
			for (int i=ce; (count<temp&&count<=total) && i>=cs; i--, count++) {
				if (count==k)
					return matrix[re][i];
				q-=1;
			}
			re--;
			p=re; q=cs;
			for (int i=re; (count<temp&&count<=total) && i>=rs; i--, count++) {
				if (count==k)
					return matrix[i][cs];
				p-=1;
			}
			cs++;
		}
		return matrix[p][q];
	}
}
