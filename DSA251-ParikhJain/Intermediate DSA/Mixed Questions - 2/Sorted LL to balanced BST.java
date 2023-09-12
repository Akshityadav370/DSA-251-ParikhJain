// public class Solution
// {
// 	public static Node<Integer> getMid(Node<Integer> head) {
// 		if (head == null)
// 			return null;
// 		Node<Integer> slow = head, fast = head;

// 		while (fast!=null && fast.next!=null) {
// 			slow = slow.next;
// 			fast = fast.next.next;
// 		}
// 		return slow;
// 	}
// 	public static TreeNode<Integer> sortedListToBST(Node<Integer> head)
// 	{
// 		// Write your code here.
// 		if (head==null) {
// 			return null;
// 		}
// 		if (head.next==null) {
// 			TreeNode<Integer> root = new TreeNode<>(head.data);
// 			return root;
// 		}

// 		Node<Integer> mid = getMid(head);
// 		TreeNode<Integer> root = new TreeNode<>(mid.data);

// 		// separating the left, mid, right;
// 		Node<Integer> left = head, temp = head, right = mid.next;;
// 		while (temp.next!=mid) {
// 			temp = temp.next;
// 		}
// 		temp.next = null;

// 		TreeNode<Integer> leftST = sortedListToBST(left);
// 		TreeNode<Integer> rightST = sortedListToBST(right);

// 		root.left = leftST;
// 		root.right = rightST;

// 		return root;
// 	}
// }
 /*
    Time Complexity: O(N)
    Space Complexity: O(logN)
    
    Where 'N' is the total number of nodes in the Linked List.
*/

import java.util.*;

public class Solution
{
public static TreeNode<Integer> inorder(List head, int leftBoundary, int rightBoundary)
    {

        if (leftBoundary > rightBoundary)
        {
            return null;
        }
        int mid = (leftBoundary + rightBoundary + 1) / 2;
        TreeNode newNode = new TreeNode((int)head.get(mid));

        // Recursing on the left subtree
        newNode.left = inorder(head, leftBoundary, mid - 1);

        // Recursing on the right subtree
        newNode.right = inorder(head, mid + 1, rightBoundary);

        return newNode;
    }

public static TreeNode<Integer> sortedListToBST(Node<Integer> head)
    {
        List temp = new ArrayList();
        while (head != null)
        {
            temp.add(head.data);
            head = head.next;
        }
        return inorder(temp, 0, temp.size() - 1);
    }
}
