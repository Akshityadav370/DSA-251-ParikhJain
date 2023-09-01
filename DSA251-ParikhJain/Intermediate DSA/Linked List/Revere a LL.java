import java.io.*;
import java.util.* ;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{	
	public static LinkedListNode<Integer> recRev(LinkedListNode<Integer> prev, LinkedListNode<Integer> curr) {
		if (curr==null) {
			return prev;
		}
		LinkedListNode<Integer> next = curr.next;
		curr.next = prev;

		return recRev(curr, next);
	}
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		// Approach using Iteration
		// if (head==null) 	return null;

		// LinkedListNode<Integer> curr = head;
		// LinkedListNode<Integer> prev = null;

		// while (curr!=null) {
		// 	LinkedListNode<Integer> next;
		// 	next = curr.next;
		// 	curr.next = prev;
		// 	prev = curr;
		// 	curr = next;
		// }

		// return prev;

		// Approach using Recursion 1 (rest_head & rest_tail)
		// if (head == null || head.next == null) 	return head;

		// LinkedListNode<Integer> rest_head = reverseLinkedList(head.next);
		// LinkedListNode<Integer> rest_tail = head.next;

		// rest_tail.next = head;
		// head.next = null;

		// return rest_head;

		// Approach using Recursion 2 (same as iterative method but in recursive manner)

		return recRev (null, head);
    }
}