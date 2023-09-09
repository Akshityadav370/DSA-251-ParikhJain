import java.util.ArrayList;

// import javax.swing.tree.TreeNode;

import java.util.*;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

public class Solution {
    // public static void getInorder(TreeNode root, List<Integer> inorder) {
    //     if (root == null)   return;
    //     getInorder(root.left, inorder);
    //     inorder.add(root.data);
    //     getInorder(root.right, inorder);

    // }
    public static int kthSmallest(TreeNode root, int k) {
        // Write your code here.
        // List<Integer> inorder = new ArrayList<>();
        // getInorder(root, inorder);

        // return inorder.get(k-1);
        Stack<TreeNode> stack = new Stack<>();

        while (true) {

            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();

            if (k==1) {
                return root.data;
            }

            k -= 1;

            root = root.right;
        }
    }
}