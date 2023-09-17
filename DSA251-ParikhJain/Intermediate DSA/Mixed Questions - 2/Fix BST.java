/*******************************************************
 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int x) {
         this.data = x;
         this.left = null;
         this.right = null;
     }
     TreeNode(int x, TreeNode left, TreeNode right) {
         this.data = x;
         this.left = left;
         this.right = right;
     }
 };
 *******************************************************/
public class Solution {
    private static TreeNode prev;
    private static TreeNode first;
    private static TreeNode midd;
    private static TreeNode last;
    public static void inorder(TreeNode root) {
        if (root==null) return;

        inorder(root.left);
        if (prev!=null && (root.data < prev.data)) {
            if (first==null) {
                first = prev;
                midd = root;
            }else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);

    }
    public static TreeNode FixBST(TreeNode root) {
        // Write your code here
        // if (root == null)   return root;
        // int temp = root.data;
        first = midd = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if (first != null && last != null) {
            int t = first.data;
            first.data = last.data;
            last.data = t;
        }
        else {
            int t = first.data;
            first.data = midd.data;
            midd.data = t;
        }
        
        
        return root;
    }
}