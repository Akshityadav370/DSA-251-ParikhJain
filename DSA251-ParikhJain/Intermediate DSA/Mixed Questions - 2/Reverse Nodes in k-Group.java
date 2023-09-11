import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static void reverse(Node start, Node end) {
		Node prev = null, curr = start, next = start.next;
		while (prev!=end) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next!=null)		next = next.next;
		}
	}
	public static Node reverseKGroups(Node head, int[] b, int i) {
		if (head==null || head.next==null || i>=b.length)	return head;
		if (b[i]==0) {
			head = reverseKGroups(head, b, i+1);
			return head;
		}
		Node start = head ,end = head;
		
		// move end to the kth position
		int inc = b[i]-1;
		while (inc!=0) {
			end = end.next;
			inc-=1;
			// if the value of k is greater than the lenght of the LL
			if (end.next==null)	break;
		}
		
		Node nextHead = null;
		// if ((i+1 != b.length) && b[i+1]==0) {
		// 	nextHead = reverseKGroups(head, b, i+2);
		// } else {
			nextHead = reverseKGroups(end.next, b, i+1);
		// }
		reverse(start, end);
		
		start.next = nextHead;

		return end;
		
	}
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
		return reverseKGroups(head, b, 0);
	}
}