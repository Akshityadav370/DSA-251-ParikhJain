import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        // x-missing y-repeating

        // long sn = ( n*(n+1) ) / 2 ;
        // long s2n=(n*(n+1)*(2*n+1))/6;

        // long s=0, s2=0;
        // for (int i: arr) {
        //     s+=(long)i;
        //     s2+= (long)i*i;
        // }
        
        // long val1 = s-sn;
        // long val2 = s2-s2n;
        
        // long val3 = val2/val1;
        
        // long x = (val3 + val1)/2;
        // long y = x - val1;

        // int[] ans=new int[2];
        // ans[0] = (int)y;
        // ans[1] = (int)x;

        // return ans;
         int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){

            if(map.containsKey(arr.get(i))){

                ans[1] = arr.get(i);

            }else{

                map.put(arr.get(i), 1);

            }

        }

        for(int i = 1; i <= n; i++){

            if(!map.containsKey(i)){

                ans[0] = i;

            }

        }

        return ans;
        
    }
}