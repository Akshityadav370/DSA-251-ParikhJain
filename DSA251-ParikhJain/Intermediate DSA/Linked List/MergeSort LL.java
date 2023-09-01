/********************************************************************

    Following is the representation of the Singly Linked List Node:

    class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
        }
    }

********************************************************************/

public class Solution {

    public static Node<Integer> sortTwoLists(Node<Integer> first, Node<Integer> second) {
		// Write your code here.
        if (first == null)  return second;
        if (second == null) return first;

        Node<Integer> head, tail;

        if (first.data <= second.data) {
            head = first;
            tail = first;
            first = first.next;
        } else {
            head = second;
            tail = second;
            second = second.next;
        }

        while (first!=null && second!=null) {
            if (first.data <= second.data) {
                tail.next = first;
                tail = tail.next;
                first = first.next;
            } else {
                tail.next = second;
                tail = tail.next;
                second = second.next;
            }
        }
        while (first != null) {
            tail.next = first;
            tail = tail.next;
            first = first.next;
        }
        while (second != null) {
            tail.next = second;
            tail = tail.next;
            second = second.next;
        }

        return head;
	}

    public static Node<Integer> findTail(Node<Integer> curr) {
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public static Node<Integer> findMid(Node<Integer> head, Node<Integer> tail) {
        Node<Integer> first = head, second = head;

        while (first!=tail && first.next!=tail) {
            second = second.next;
            first = first.next.next;
        }
        
        return second;
    }

    public static Node<Integer> mergeSortHT(Node<Integer> head, Node<Integer> tail) {
        if (head == tail)   return head;

        Node<Integer> mid = findMid(head, tail);
        Node<Integer> firstHalf = mergeSortHT(head, mid);
        Node<Integer> temp = mid.next;
        mid.next = null;
        Node<Integer> secondHalf = mergeSortHT(temp, tail);

        Node<Integer> sorted = sortTwoLists(firstHalf, secondHalf);

        return sorted;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        // Write your code here.
        if (head==null || head.next == null)    return head;
        Node<Integer> tail = findTail(head);

        return mergeSortHT(head, tail);
    }
}
