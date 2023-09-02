/*************************************************************

	Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node segregateOddEven(Node head) {
		// Write your code here.
		// 1.Time: O(N), Space: O(N)
		// if (head == null || head.next == null)	return head;

		// Node odd = new Node(1);
		// Node even = new Node(2);

		// Node temp1 = odd, temp2 = even;
		// Node temp = head;

		// while (temp!=null) {
		// 	if (temp.data%2==0) {
		// 		temp2.next = new Node(temp.data);
		// 		temp2 = temp2.next;
		// 	} else {
		// 		temp1.next = new Node(temp.data);
		// 		temp1 = temp1.next;
		// 	}
		// 	temp = temp.next;
		// }
		// temp1.next = even.next;
		// return odd.next;
		
		// 2. Time: O(N), Space: O(1)
		if (head == null || head.next == null)	return head;
		
		Node oddStart=null, oddEnd=null;
		Node evenStart=null, evenEnd=null;

		Node curr = head;
		
		while (curr!=null) {
			if (curr.data%2 == 1) {
				if (oddStart==null) {
					oddStart = curr;
					oddEnd = oddStart;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}
			else {
				if (evenStart==null) {
					evenStart = curr;
					evenEnd = evenStart;
				} else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			}
			
			curr = curr.next;
		}

		if (oddStart==null || evenStart==null) {
			return head;
		}

		oddEnd.next = evenStart;
		evenEnd.next = null;

		return oddStart;
	}
}