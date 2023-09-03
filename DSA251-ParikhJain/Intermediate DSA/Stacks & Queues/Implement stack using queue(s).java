import java.util.*;
public class Solution{
    static class Stack {
        // Define the data members.
        Queue<Integer> q1, q2;

        public Stack() {
            // Implement the Constructor.
            // Primary
            q1 = new LinkedList<>();
            // Helper
            q2 = new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            // Implement the getSize() function.
            return q1.size();
        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            return q1.isEmpty();
        }

        public void push(int element) {
            // Implement the push(element) function.
            if (q1.isEmpty()) {
                q1.add(element);
            } else {
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
                q1.add(element);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
        }

        public int pop() {
            // Implement the pop() function.
            if (q1.isEmpty())   return -1;
            return q1.remove();
        }

        public int top() {
            // Implement the top() function.
            if (q1.isEmpty())   return -1;
            return q1.peek();
        }
    }
}