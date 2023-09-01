import java.util.* ;
import java.io.*; 
/****************************************************************
    Following is the Linked List node structure

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

public class Solution
{
    
public static Node insertionSortLL(Node head)
    {
        // Write your code here
        if (head==null || head.next==null)  return head;

        Node dummy = new Node(1000);

        while (head!=null) {
            Node temp = dummy;

            Node next = head.next;

            while(temp.next!=null && temp.next.data <= head.data) {
                temp = temp.next;
            }
            head.next = temp.next;
            temp.next = head;
            head = next;

        }

        return dummy.next;
    }
}
