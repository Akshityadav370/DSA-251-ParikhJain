import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class Node<Integer>
    {
        int data;
        Node<Integer> next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

 *****************************************************************/
public class Solution {

    public static Node<Integer> addNodes(Node<Integer> head, int n, int m) {
        // Write your code here.
        if (head == null)   return head;

        Node<Integer> temp = head;

        while (temp!=null && temp.next!=null) {
            // Skipping the m nodes
            int count = m-1;
            while (count--!=0 && temp.next!=null) {
                temp = temp.next;
            }

            // Adding the n nodes
            count = n;
            int sum = 0;
            while (count--!=0 && temp.next!=null) {
                sum += temp.next.data;
                temp = temp.next;
            }
            if (sum!=0) {
                Node<Integer> sumNode = new Node<>(sum);
                if (temp.next!=null) {
                    sumNode.next = temp.next;
                }
                temp.next = sumNode;
                // Replacing the position of temp for next set of n & m
                temp = temp.next.next;
            }

        }

        return head;
    }
}