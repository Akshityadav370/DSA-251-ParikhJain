// import java.util.* ;
// import java.io.*; 
// /**************************************************************

//     Following is the class structure of the Node class:

// 	class LinkedListNode {
// 	    public int data;
// 	    public LinkedListNode next;

// 	    LinkedListNode(int data) {
// 	        this.data = data;
// 	        this.next = null;
// 	    }
// 	}

// ***************************************************************/

// public class Solution {
// 	public static LinkedListNode partition(LinkedListNode head, int x) {
// 		LinkedListNode leftDummy = new LinkedListNode(-1);
// 		LinkedListNode rightDummy = new LinkedListNode(-1);
// 		LinkedListNode leftIt = leftDummy;
// 		LinkedListNode rightIt = rightDummy;

// 		LinkedListNode temp = head;

// 		while (temp != null) {
// 			if (temp.data < x) {
// 				leftIt.next = temp;
// 				leftIt = temp;
// 			} else {
// 				rightIt.next = temp;
// 				rightIt = temp;
// 			}
// 			temp = temp.next;
// 		}
		
// 		leftDummy = leftDummy.next;
// 		rightDummy = rightDummy.next;

// 		if (leftDummy!=null) {
// 			leftIt.next = rightDummy;
// 			rightIt.next = null;
// 			return leftDummy;
// 		} else {
// 			return rightDummy;
// 		}
		
// 	}
// 	public static LinkedListNode quickSort(LinkedListNode head) {
// 		if (head == null || head.next == null)
// 			return head;
		
// 		// Partition of the LL
// 		LinkedListNode pivot = head;
// 		LinkedListNode parted_head = partition(head, pivot.data);
		
// 		LinkedListNode left = parted_head;
// 		LinkedListNode right = pivot.next;

// 		// Isolating left, pivot and right
// 		if (left == pivot) {
// 			left = null;
// 		} else {
// 			LinkedListNode temp = left;
// 			while (temp.next != pivot) {
// 				temp = temp.next;
// 			}
// 			temp.next = null;
// 		}

// 		left = quickSort(left);
// 		right = quickSort(right);

// 		if (left!=null) {
// 			LinkedListNode Itt = left;
// 			while (Itt.next != null) {
// 				Itt = Itt.next;
// 			}
// 			Itt.next = pivot;
// 			pivot.next = right;
// 			return left;
// 		} else {
// 			pivot.next = right;
// 			return pivot;
// 		}
// 	}
// 	public static LinkedListNode quickSortLL(LinkedListNode head) {
// 		// Write your code here.
// 		if (head == null || head.next==null) {
// 			return head;
// 		}

// 		return quickSort(head);
// 	}
// }

/*
    Time Complexity: O(L ^ 2)
    Space complexity: O(L)
    
    Where 'L' is the number of nodes in the linked list.
*/

class pivotNewHeadTail {
	LinkedListNode newHead;
	LinkedListNode newTail;
	LinkedListNode pivot;

	public pivotNewHeadTail() {
	}

	public pivotNewHeadTail(LinkedListNode newHead, LinkedListNode newTail, LinkedListNode pivot) {
		this.newHead = newHead;
		this.newTail = newTail;
		this.pivot = pivot;
	}
}

public class Solution {

	// Returns the last node of the list.
	public static LinkedListNode getTail(LinkedListNode cur) {
		while (cur != null && cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}

	public static pivotNewHeadTail partition(LinkedListNode head, LinkedListNode tail, LinkedListNode newHead, LinkedListNode newTail) {
		LinkedListNode pivot = tail;
		LinkedListNode prev = null, cur = head;

		while (cur != pivot) {

			// Keep it at its current position.
			if (cur.data < pivot.data) {
				if ((newHead) == null) {
					(newHead) = cur;
				}

				prev = cur;
				cur = cur.next;
			}

			// Move it after tail.
			else {
				if (prev != null) {
					prev.next = cur.next;
				}
				LinkedListNode temp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = temp;
			}
		}

		if (newHead == null) {
			newHead = pivot;
		}

		newTail = tail;
		pivotNewHeadTail pivotHeadTail = new pivotNewHeadTail(newHead, newTail, pivot);
		return pivotHeadTail;
	}

	public static LinkedListNode quickSortHelper(LinkedListNode head, LinkedListNode tail) {

		// Base condition.
		if (head == null || head == tail) {
			return head;
		}

		LinkedListNode newHead = null, newTail = null;

		pivotNewHeadTail pivotHeadTail = partition(head, tail, newHead, newTail);
		LinkedListNode pivot = pivotHeadTail.pivot;
		newHead = pivotHeadTail.newHead;
		newTail = pivotHeadTail.newTail;

		// If pivot is head then we don't have left part.
		if (newHead != pivot) {
			LinkedListNode temp = newHead;
			while (temp.next != pivot) {
				temp = temp.next;
			}
			temp.next = null;

			newHead = quickSortHelper(newHead, temp);

			temp = getTail(newHead);
			temp.next = pivot;
		}

		pivot.next = quickSortHelper(pivot.next, newTail);

		return newHead;
	}

	public static LinkedListNode quickSortLL(LinkedListNode head) {
		LinkedListNode tail = getTail(head);
		head = quickSortHelper(head, tail);
		return head;
	}

}

