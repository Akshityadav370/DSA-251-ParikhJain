import java.util.* ;
import java.io.*; 
public class Solution {

    public static int[] sort(int n, int arr[]) {
		 int  max = Arrays.stream(arr).max().getAsInt();
        int min  = Arrays.stream(arr).min().getAsInt();
        
       int[] count = new int[max - min + 1 ] ;
        int out[] = new int[n] ;
        
     
        
        for(int i = 0 ; i < n ; i++){
            ++count[arr[i] - min] ;
        }
        for(int i = 1 ; i < count.length ; i++){
            count[i]+=count[i-1];
        }
        
        for(int i = 0 ; i < n ; i++){
            out[--count[arr[i] - min] ] = arr[i] ;
        }
        
        
        return out ;
	}

}
