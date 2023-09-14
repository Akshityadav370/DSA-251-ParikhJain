import java.util.* ;
import java.io.*; 

/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	static BinaryTreeNode<Integer> head, prev;
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		// Write your code here
		head = null;
		prev = null;
		helper(root);
		return head;
	}
	public static void helper(BinaryTreeNode<Integer> root) {
		if (root == null)	return;
		helper(root.left);
		if (prev==null)	head = root;
		else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		helper(root.right);
	}
	

}
