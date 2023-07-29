import java.util.* ;
import java.io.*; 
class Solution {
	


	public static void reverse(int[] arr, int start, int end) {

		int temp;
		while(start<end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String args[]) {
		
		// Write code here
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();

		int k = sc.nextInt(), count = 0;
		if(k==0) 	return;
		// Brute - force
		// while(count < k){
			

		// 		int temp = arr[0];
		// 		for(int j = 1; j<n; j++){
		// 			arr[j-1] = arr[j];
		// 		}

		// 		arr[n-1] = temp;
		// 		count += 1;
			
		// }
		k = k%n;

		reverse(arr, 0, k-1);
		reverse(arr, k, n-1);
		reverse(arr, 0, n-1);


		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}