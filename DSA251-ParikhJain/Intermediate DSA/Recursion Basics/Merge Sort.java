public class Solution {

	public static void conquer(int[] arr, int si, int mid, int ei) {
		int merged[] = new int[ei-si+1];
		int indx1 = si, indx2 = mid+1, x = 0;

		while(indx1<=mid && indx2<=ei) {
			if (arr[indx1] <= arr[indx2]) {
				merged[x++] = arr[indx1++];
			} else {
				merged[x++] = arr[indx2++];
			}
		}
		while(indx1 <= mid) {
			merged[x++] = arr[indx1++];
		}
		while(indx2 <= ei) {
			merged[x++] = arr[indx2++];
		}
		
		for (int i=0, j=si; i<merged.length; i++, j++) {
			arr[j] = merged[i];
		}
	}

	public static void divide(int[] arr, int si, int ei) {
		if (si==ei) 	return;
		int mid = si+(ei-si)/2;
		
		divide (arr, si, mid);
		divide (arr, mid+1, ei);

		conquer (arr, si, mid, ei);
	}
	
	public static void mergeSort(int[] arr, int n) {
		// Write your code here.
		divide(arr, 0, n-1);
	}
}