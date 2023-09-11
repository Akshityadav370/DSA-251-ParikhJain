import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!
		if (head == null || head.next == null)
            return true;
		// Optimised Approach
		
        // LinkedListNode<Integer> slow = head;
        // LinkedListNode<Integer> fast = head;
        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // LinkedListNode<Integer> reverseLinkedList = reverse(slow);
        // while (reverseLinkedList != null && head != null) {
        //     if (!head.data.equals(reverseLinkedList.data))
        //         return false;
        //     reverseLinkedList = reverseLinkedList.next;
        //     head = head.next;
        // }
        // return true;

		// Stack Approach
		Stack<Integer> stack = new Stack<>();

		LinkedListNode<Integer> curr = head;

		while (curr!=null) {
			stack.push(curr.data);
			curr = curr.next;
		}
		curr = head;
		while (curr!=null) {
			if (!stack.pop().equals(curr.data))
				return false;
			curr = curr.next;
		}
		
		return true;
	}
}