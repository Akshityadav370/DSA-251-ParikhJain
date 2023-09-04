import java.util.* ;
import java.io.*; 

public class Solution {

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
  
      // Write your code here.
      // 1. Reversing using stack
      // Stack<Integer> stack = new Stack<>();

      // while (!q.isEmpty()) {
      //   int temp = q.remove();
      //   stack.push(temp);
      // }

      // while (!stack.isEmpty()) {
      //   int temp = stack.pop();
      //   q.add(temp);
      // }

      // return q;
      
      // 2. Reversing using recursion stack
      if (q.isEmpty())  return q;

      int e = q.remove();

      Queue<Integer> res = reverseQueue(q);

      res.add(e);

      return res;

    }
  }