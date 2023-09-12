import java.util.*;

public class Solution {

  // 2. Using Stack (calculating prevSmaller & nextSmaller)
  public static ArrayList<Integer> nextSmaller(ArrayList<Integer> arr, int n) {

    Stack<Integer> stk = new Stack<>();

    ArrayList<Integer> ans = new ArrayList<>();

    stk.push(-1);

    for (int i = n - 1; i >= 0; i--) {

      int curr = arr.get(i);

      while (stk.peek() != -1 && curr <= arr.get(stk.peek())) {

        stk.pop();

      }

      ans.add(stk.peek());

      stk.push(i);

    }

    Collections.reverse(ans);

    return ans;

  }

 

  public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr, int n) {

    Stack<Integer> stk = new Stack<>();

    ArrayList<Integer> ans = new ArrayList<>();

    stk.push(-1);

    for (int i = 0; i < n; i++) {

      int curr = arr.get(i);

      while (stk.peek() != -1 && curr <= arr.get(stk.peek())) {

        stk.pop();

      }

      ans.add(stk.peek());

      stk.push(i);

    }

    return ans;

  }

 

  public static int largestRectangle(ArrayList<Integer> heights) {

    int n = heights.size();

    ArrayList<Integer> next = nextSmaller(heights, n);

    ArrayList<Integer> prev = prevSmaller(heights, n);

    int ans = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      int length = heights.get(i);

 

      if (next.get(i) == -1)

        next.set(i, n);

 

      int breadth = next.get(i) - prev.get(i) - 1;

 

      int area = length * breadth;

      ans = Math.max(ans, area);

    }

    return ans;

  }
  // public static int largestRectangle(ArrayList < Integer > heights) {
    // Write your code here.

    // 1. Brute Force
    // int maxArea = Integer.MIN_VALUE;

    // for (int i=0; i<heights.size(); i++) {
    //   int rightSmallerInd = i, leftSmallerInd = i;

    //   for (; leftSmallerInd>=0; leftSmallerInd--) {
    //     if (heights.get(leftSmallerInd) < heights.get(i) )
    //       break;
    //   }
    //   for (; rightSmallerInd<heights.size(); rightSmallerInd++) {
    //     if (heights.get(rightSmallerInd) < heights.get(i))
    //       break;
    //   }

    //   int width = rightSmallerInd-leftSmallerInd-1;

    //   maxArea = Math.max(maxArea, width*heights.get(i));
    // }

    // return maxArea;
    

  // }
}