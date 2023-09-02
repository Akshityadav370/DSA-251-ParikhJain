import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

	class Node {
		int data;
		Node next;

		Node(int data) {
		this.data = data;
		this.next = null;
	   }
   }

*****************************************************************/

public class Solution {
	public static Node pairsSwap(Node head) {
		// Write your code here.
		// 1. Using Recursion
		// if (head == null || head.next == null)	return head;
		
		// Node curr = head;
		// Node next = null, prev = null;

		// int count = 0;
		// while (curr!=null && count<2) {
		// 	next = curr.next;
		// 	curr.next = prev;
		// 	prev = curr;
		// 	curr = next;
			
		// 	count++;
		// }

		// if (next != null) {
		// 	head.next = pairsSwap(next);
		// }

		// return prev;

		// 2. Iterative
		Node dummy = new Node(0);
		dummy.next = head;

		Node point = dummy;

		while (point.next != null && point.next.next != null) {
			// Identify nodes to swap
			Node swap1 = point.next;
			Node swap2 = point.next.next;

			// Actually swap
			swap1.next = swap2.next;
			swap2.next = swap1;

			// Prepare for next
			point.next = swap2;
			point = swap1;
		}
		
		return dummy.next;
		
	}
}