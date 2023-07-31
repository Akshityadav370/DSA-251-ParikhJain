
public class Solution {

	public static void spiralPrint(int matrix[][]){
		//Your code goes here
		 if(matrix.length==0 || matrix[0].length == 0){
            return;
        }

		int n = matrix.length;
		int m = matrix[0].length;

		int rstart = 0, rend = n-1;
		int cstart = 0, cend = m-1;

		int count = 0;

		while(count < n*m) {

			for (int i = cstart; count<n*m && i<=cend; i++){
				System.out.print(matrix[rstart][i] + " ");
				count++;
			}
			rstart+=1;

			for (int i = rstart; count<n*m && i<=rend; i++){
				System.out.print(matrix[i][cend] + " ");
				count++;
			}
			cend-=1;

			for (int i = cend; count<n*m && i>=cstart; i--){
				System.out.print(matrix[rend][i] + " ");
				count++;
			}
			rend-=1;

			for (int i = rend; count<n*m && i>=rstart; i--){
				System.out.print(matrix[i][cstart] + " ");
				count++;
			}
			cstart+=1;
		}
	}
}
