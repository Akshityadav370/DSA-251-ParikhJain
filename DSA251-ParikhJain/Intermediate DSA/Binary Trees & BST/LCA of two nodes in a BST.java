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
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        // Write your code here.
        if (root==null) return null;
        // Recursive
        // Time: O(N)
        // Space: O(N)
        // if (p.data<root.data && q.data<root.data)
        //     return LCAinaBST(root.left, p, q);
        // else if (p.data>root.data && q.data>root.data)
        //     return LCAinaBST(root.right, p, q);
        // return root;
        
        // Iterative
        // Time: O(N)
        // Space: O(1)
        while(root!=null) {
            if (p.data<root.data && q.data<root.data)
                root = root.left;
            else if (p.data>root.data && q.data>root.data)
                root = root.right;
            else
                break;
        }

        return root;

    }
}