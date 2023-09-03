/****************************************************************

 Following is the class structure of the Node class:

 static class Node
 {
     int data;
     Node next;
     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };


 *****************************************************************/
public class Solution {
    static class Stack {
        //Write your code here
        Node head;
        int size;
        Stack()
        {
            //Write your code here
            head = new Node();
            size = 0;
        }

        int getSize()
        {
            //Write your code here
            return size;
        }

        boolean isEmpty()
        {
            //Write your code here
            return size == 0;
        }

        void push(int data)
        {
            //Write your code here
            if (head == null) {
                head.data = data;
            } else {
                Node element = new Node(data);
                element.next = head;
                head = element;
            }
            size += 1;
        }

        void pop()
        {
            //Write your code here
            if (isEmpty())  return;
            head = head.next;
            size -= 1;
        }

        int getTop()
        {
            //Write your code here
            if (isEmpty())  return -1;
            return head.data;
        }
    }
}
