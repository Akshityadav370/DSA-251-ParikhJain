// import java.util.* ;

// // import javax.swing.tree.TreeNode;

// import java.io.*; 
// /*
	
// 	Following is the Binary Tree node structure:

// 	public class TreeNode {
// 	    int data;
// 	    TreeNode left;
// 	    TreeNode right;
// 	    TreeNode() {}
// 	    TreeNode(int val) { this.data = val; }
// 	    TreeNode(int val, TreeNode left, TreeNode right) {
// 	       this.data = val;
// 	        this.left = left;
// 	        this.right = right;
// 	    }
// 	}

// */

// public class Solution {
// 	// public static void helper(TreeNode root, List<Integer> res) {
// 	// 	if (root == null)	return;
// 	// 	res.add(root.data);
// 	// 	helper(root.left, res);
// 	// 	helper(root.right, res);
// 	// }
//     public static List < Integer > getPreOrderTraversal(TreeNode root) {
//     	// Write your code here.
// 		List<Integer> res = new ArrayList<>();
// 		if (root == null)	return res;

// 		// helper(root, res);
// 		// return res;

// 		Stack datastruct = new Stack<>();

// 		datastruct.push(root);

// 		while (!datastruct.isEmpty()) {
// 			TreeNode curr = datastruct.pop();

// 			res.add(curr.data);

// 			if (curr.right != null) 
// 				datastruct.push(curr.right);
// 			if (curr.left != null)
// 				datastruct.push(curr.left);
			
// 		}

// 		return res;
//     }
// }
/*
    Following is the TreeNode class structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    };
*/

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Stack;

// // import javax.swing.tree.TreeNode;

// public class Solution {
//     // public static void helper(List<Integer> res, TreeNode root) {
//     //     if (root==null)
//     //         return ;
//     //     helper(res, root.left);
//     //     res.add(root.data);
//     //     helper(res, root.right);
//     // }
//     public static List< Integer > getInOrderTraversal(TreeNode root) {
//         // Write your code here.
//         List<Integer> res = new ArrayList<>();
//         if (root == null)   return res;

//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;

//         while (true) {
//             if (curr!=null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 if (stack.isEmpty())
//                     break;
//                 curr = stack.pop();
//                 res.add(curr.data);
//                 curr = curr.right;
//             }
//         }

//         return res;
//     }
// }

import java.util.* ;

// import javax.swing.tree.TreeNode;

import java.io.*; 
/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/

public class Solution {
    // public static List < Integer > getPostOrderTraversal(TreeNode root) {
    // 	// Write your code here.
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null)   return res;

    //     Stack<TreeNode> st1 = new Stack<>();
    //     Stack<TreeNode> st2 = new Stack<>();

    //     st1.push(root);

    //     while (!st1.isEmpty()) {
    //         TreeNode curr = st1.pop();

    //         st2.push(curr);
            
    //         if (curr.left != null)  st1.push(curr.left);
    //         if (curr.right != null) st1.push(curr.right);
    //     }

    //     while (!st2.isEmpty()) {
    //         TreeNode curr = st2.pop();
    //         res.add(curr.data);
    //     }

    //     return res;
    // }
    public static List < Integer > getPostOrderTraversal(TreeNode root) {

        // Create answer array to store traversal.
        List < Integer > answer = new ArrayList < Integer > ();

        // Base case.
        if (root == null) {
            return answer;
        }

        // Create an empty stack.
        Stack st = new Stack();
        TreeNode current = root;

        // Push 'ROOT' to stack.
        st.push(current);

        // Run a loop until stack is not empty.
        while (st.empty() == false) {

            // Pop a node from 'S'.
            current = (TreeNode) st.peek();
            st.pop();

            // Add data of popped node to 'ANSWER'.
            answer.add(current.data);

            // Push left child of current node  to stack.
            if (current.left != null) {
                st.push(current.left);
            }

            // Push right child of current node  to stack.
            if (current.right != null) {
                st.push(current.right);
            }
        }

        // Reverse all elements of 'ANSWER' array.
        Collections.reverse(answer);

        // Return answer.
        return answer;
    }
}