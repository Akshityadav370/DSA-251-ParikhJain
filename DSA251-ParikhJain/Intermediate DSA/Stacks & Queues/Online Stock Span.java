import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        // 1) Iterative
        // ArrayList<Integer> res = new ArrayList<>();

        // res.add(1);

        // for (int i = 1; i<price.size(); i++) {
        //     int days = 0;
        //     for (int j=i; j>=0; j--) {
        //         if (price.get(j) <= price.get(i)) {
        //             days++;
        //         }else {
        //             break;
        //         }
        //     }
        //     res.add(days);
        // }

        // return res;

        // 2) Stack Approach (Reverse of Next greater element)
        ArrayList<Integer> span = new ArrayList<>();
        span.add(1);

        Stack<Integer> indexStack = new Stack<>();

        indexStack.push(0);

        for (int i=1; i<price.size(); i++) {

            while (!indexStack.isEmpty() && price.get(indexStack.peek()) <= price.get(i)) {
                indexStack.pop();
            }

            if (indexStack.isEmpty()) {
                span.add(i+1);
            } else {
                span.add(i-indexStack.peek());
            }

            indexStack.push(i);
        }

        return span;


    }
}