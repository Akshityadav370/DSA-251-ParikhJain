/*****************************************************
  
  Following is the structure of Node.
  public static class Node {
    
    int data;
    Node next;

    Node(int data) {
      this . data = data;
      this . next = null;
    }
  }

*****************************************************/

import java.util.ArrayList;

public class Solution {

  public static Node detectCycle(Node head) {
    Node slow=head, fast = head;

    while (fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return slow;
      }
    }

    return null;
  }
  public static Node removeLoop(Node head) {
    // Write your code here.
    if (head == null || head.next==null)  return head;

    Node meet = detectCycle(head);
    if (meet == null)   return head;

    Node start = head;
    
    // System.out.println("coming here");
    while (start != meet) {
      start = start.next;
      meet = meet.next;
    }

    Node temp = meet;

    while (temp.next != meet) {
      temp = temp.next;
    }

    temp.next = null;

    return head;
  }
}