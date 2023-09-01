public class Solution
{
    public static Node findMiddle(Node head)
    {
        // Write your code here.
        // Optimal solution using slow N fast pointers.
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}