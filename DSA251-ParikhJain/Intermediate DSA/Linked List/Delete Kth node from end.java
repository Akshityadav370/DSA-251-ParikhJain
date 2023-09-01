/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.
        // if (K==1) {
            // Node x = new Node(-1);
            // return x;
        // }
        if (head==null)  return head;
        

        int size = 1;
        Node temp = head;

        while (temp.next!=null) {
            size += 1;
            temp = temp.next;
        }

        // int pivot = size - K;
        if (size == K) {
            if (head.next == null) {
                // System.out.println(head);
                Node x = new Node(-1);
                return x;
            }
            return head.next;
        }

        int pivot = size - K - 1;
        // System.out.println(size);
        // System.out.println(pivot);
        temp = head;

        while (pivot!=0) {
            // System.out.println("im here");
            temp = temp.next;
            pivot -= 1;
        }
        // System.out.println(temp.data);
        temp.next = temp.next.next;
        // Node x = new Node(13);
        return head;

    }
}