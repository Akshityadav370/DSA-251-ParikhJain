import java.io.*;
import java.util.* ;

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	// public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
	// 	// Write your code here.
	// 	if (head == null)	return head;
		
	// 	LinkedListNode<Integer> current = head;
		
	// 	// Inserting new nodes in between
	// 	while (current != null) {
	// 		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(current.data);
	// 		newNode.next = current.next;
	// 		current.next = newNode;
	// 		current = newNode.next;
	// 	}

	// 	current = head;
	// 	// Setting Random pointers of new nodes
	// 	while (current != null) {
	// 		if (current.next != null) {
	// 			current.next.random = (current.random != null) ? current.random.next : null;
	// 		}
	// 		current = current.next.next;
	// 	}
		
	// 	LinkedListNode<Integer> orig = head, copy = head.next, temp = copy;
	// 	// Separating both the linked lists
	// 	while (orig != null) {
	// 		// orig.next = orig.next.next;
	// 		// orig = orig.next;
	// 		// if (temp.next != null) {
	// 		// 	temp.next = temp.next.next;
	// 		// }
	// 		// temp = temp.next;
	// 		LinkedListNode<Integer> cloneNode = orig.next;
	// 		orig.next = cloneNode.next;
			
	// 		if (cloneNode.next != null) {
	// 			cloneNode = cloneNode.next.next;
	// 		}
	// 		temp = temp.next;
	// 	}

	// 	return copy;
	// }
	// This function clones a given linked list in O(1) space.
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> curr = head, temp = null;

		// Insert additional node after every node of original list.
		while (curr != null) {
			temp = curr.next;

			// Inserting node.
			curr.next = new LinkedListNode<>(curr.data);
			curr.next.next = temp;
			curr = temp;
		}
		curr = head;

		// Adjust the random pointers of the newly added nodes.
		while (curr != null) {
			if (curr.next != null) {
				if (curr.random != null) {
					curr.next.random = curr.random.next;
				} 
                else {
					curr.next.random = curr.random;
				}
			}

			// Move to the next newly added node by skipping an original node.
			if (curr.next != null) {
				curr = curr.next.next;
			} 
            else {
				curr = curr.next;
			}
		}

		LinkedListNode<Integer> original = head, copy = null;

		if (head != null) {
			copy = head.next;
		}

		// Save the start of copied linked list.
		temp = copy;

		// Now separate the original list and copied list.
		while (original != null && copy != null) {
			if (original.next != null) {
				original.next = original.next.next;
			}

			if (copy.next != null) {
				copy.next = copy.next.next;
			}
			original = original.next;
			copy = copy.next;
		}
		return temp;
	}
}
