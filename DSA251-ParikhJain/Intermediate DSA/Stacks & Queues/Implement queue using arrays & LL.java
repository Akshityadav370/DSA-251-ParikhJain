import java.util.* ;
import java.io.*; 

public class Queue {

    // Using Linked List
    // static class Node
    // {
    //     int data;
    //     Node next;
    //     Node()
    //     {
    //         this.data = 0;
    //         this.next = null;
    //     }
    //     Node(int data)
    //     {
    //         this.data = data;
    //         this.next = null;
    //     }
    //     Node(int data, Node next)
    //     {
    //         this.data = data;
    //         this.next = next;
    //     }
    // };

    
    // Node head, tail;
    // int size;

    // Queue() {
    //     // Implement the Constructor
    //     head = null;
    //     tail = null;
    //     size = 0;
    // }

    // /*----------------- Public Functions of Queue -----------------*/

    // boolean isEmpty() {
    //     // Implement the isEmpty() function
    //     return size==0;
    // }

    // void enqueue(int data) {
    //     // Implement the enqueue() function
    //     Node ele = new Node(data);
    //     if (head == null) {
    //         head = ele;
    //         tail = ele;
    //         size += 1;
    //         return;
    //     }
        
    //     tail.next = ele;
    //     tail = ele;
    //     size += 1;
    // }

    // int dequeue() {
    //     // Implement the dequeue() function
    //     if (isEmpty())  return -1;
    //     if (head.next == null) {
    //         int data = head.data;
    //         head = null;
    //         tail = head;
    //         size -= 1;
    //         return data;
    //     }
    //     int data = head.data;
    //     head = head.next;
    //     size -= 1;
    //     return data;
        
    // }

    // int front() {
    //     // Implement the front() function
    //     if (isEmpty())  return -1;
    //     else 
    //         return head.data;
    // }

    // Using Arrays
    int qfront, rear, size, queueSize;
    int[] q;

    Queue() {

        // Intialise the queue with 0 elements.
        rear = 0;
        qfront = 0;
        size = 0;
        queueSize = 100010;
        q = new int[100010];
    }

    // Function to check if the queue is empty.
    boolean isEmpty() {
        if (qfront == rear) {
            return true;
        }
        return false;
    }

    void enqueue(int data) {

        // Push the current element in the queue.
        q[rear] = data;
        rear = rear + 1;

        // Increase the value of size.
        size++;
    }

    int dequeue() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        int ans = q[qfront];
        qfront++;
        size--;
        if (qfront == rear) {
            qfront = 0;
            rear = 0;
        }
        return ans;
    }

    int front() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        // Return the element at front.
        return q[qfront];
    }


}
