import java.util.*;

public class Solution {
	public static void pushZerosAtEnd(ArrayList<Integer> arr)
	{
		// Write your code here.

		// int p=0;

        // for(int i=0;i<arr.size();i++)

        // {

        //    if(arr.get(i)!=0)

        //    {

        //        arr.set(p,arr.get(i));

        //        p++;

        //    }

        // }

        // for(int i=p;i<arr.size();i++)

        // {

        //     arr.set(p,0);

        //     p++;

        // }

		int zptr = -1;
        int nzptr = -1;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) {
                zptr = i;
                break;
            }
        }

        if (zptr == -1) {
            return;
        }

        for (int i = zptr + 1; i < n; i++) {
            if (arr.get(i) != 0) {
                nzptr = i;
                break;
            }
        }

        if (nzptr == -1) {
            return;
        }

        while (nzptr < n) {
            Collections.swap(arr, zptr, nzptr);
            zptr++;
            while (nzptr < n && arr.get(nzptr) == 0) {
                nzptr++;
            }
        }
	}
}