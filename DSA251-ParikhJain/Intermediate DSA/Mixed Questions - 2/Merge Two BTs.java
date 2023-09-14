// import java.util.* ;
// import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/

// public class Solution {
// 	public static BinaryTreeNode mergeTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
// 		// Write your code here.
// 		if (root1==null)	return root2;
// 		if (root2==null)	return root1;

// 		root1.data += root2.data;

// 		root1.left = mergeTrees(root1.left, root2.left);
// 		root1.right = mergeTrees(root1.right, root2.right);

// 		return root1;

// 	}
// }

/*
	Time Complexiy : O(N)
	Space Complexity : O(N)

	Where N is the number of nodes in binary tree.
*/

import java.util.Stack;

public class Solution {
	public static BinaryTreeNode mergeTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}

		if (root1 == null || root2 == null) {

			return root1 != null ? root1 : root2;
		}

		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();

		s1.push(root1);
		s2.push(root2);

		while (!s1.empty()) {
			BinaryTreeNode c1 = (s1.peek());
			BinaryTreeNode c2 = (s2.peek());
			s1.pop();
			s2.pop();

			c1.data += c2.data;

			if (c1.left == null && c2.left != null) {
				c1.left = c2.left;
			} else if (c1.left != null && c2.left != null) {
				s1.push(c1.left);
				s2.push(c2.left);
			}

			if (c1.right == null && c2.right != null) {
				c1.right = c2.right;
			} else if (c1.right != null && c2.right != null) {
				s1.push(c1.right);
				s2.push(c2.right);
			}
		}
		return root1;
	}
}