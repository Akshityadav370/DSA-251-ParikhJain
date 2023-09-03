import java.util.* ;
import java.io.*; 

public class Solution {

    static class MinStack {

        // Constructor
        Stack<Integer> st1;
        Stack<Integer> st2;
        MinStack() {
            // Write your code here.
            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            st1.push(num);
            if (st2.isEmpty() || num<=st2.peek()) {
                st2.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            // Write your code here.
            if (st1.isEmpty())  return -1;
            int popped = st1.pop();
            if (popped == st2.peek()) {
                st2.pop();
            }
            return popped;
            
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
            if (st1.isEmpty())  return -1;
            return st1.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            // Write your code here.
            if (st1.isEmpty())  return -1;
            return st2.peek();
        }
    }
}