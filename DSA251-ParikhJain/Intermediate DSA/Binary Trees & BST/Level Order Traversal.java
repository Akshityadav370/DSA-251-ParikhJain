import java.util.* ;
import java.io.*; 
/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {

	// 1. Brute Force/ Naive
// 	public static int calcHeight(BinaryTreeNode root) {
// 		if (root == null)	return 0;

// 		return 1 + Math.max(calcHeight(root.left), calcHeight(root.right));
// 	}

// 	public static void getLevel(BinaryTreeNode root, int level, ArrayList<Integer> res) {
// 		if (root == null) {
// 			return;
// 		}
// 		if (level == 1) {
// 			res.add(root.val);
// 		} else {
// 			getLevel(root.left, level-1, res);
// 			getLevel(root.right, level-1, res);
// 		}
// 	}
//   public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
//     //Your code goes here
// 	ArrayList<Integer> res = new ArrayList<>();	

// 	int h = calcHeight(root);
// 	for (int i=1; i<=h; i++) {
// 		getLevel(root, i, res);
// 	}

// 	return res;
//   }

	// 2. Optimised
	public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();

		if (root==null)	return res;

		Queue<BinaryTreeNode> queue = new LinkedList<>();

		queue.add(root);

		while(!queue.isEmpty()) {
			BinaryTreeNode first = queue.remove();

			res.add(first.val);

			if (first.left != null)
				queue.add(first.left);
			if (first.right != null)
				queue.add(first.right);
		}

		return res;
	}

}