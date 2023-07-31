import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {

		// Write your code here.
		int count = 0;		

		int rows = mat.size();
		int cols = mat.get(0).size();

		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {

				if (mat.get(i).get(j) == 0) {

					// Top checking
					if(i>0 && mat.get(i-1).get(j)==1)
						count++;

					// Left checking
					if(j>0 && mat.get(i).get(j-1)==1)
						count++;

					// Bottom checking
					if(i<rows-1 && mat.get(i+1).get(j)==1)
						count++;

					// Right checking
					if(j<cols-1 && mat.get(i).get(j+1)==1)
						count++;
				}
			}
		}

		return count;
		
	}
}
