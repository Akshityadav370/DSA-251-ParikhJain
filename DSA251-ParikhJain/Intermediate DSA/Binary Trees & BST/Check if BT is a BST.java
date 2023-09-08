import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    // public static void getInorder(List<Integer> res, BinaryTreeNode<Integer> root) {
    //     if (root.left!=null)
    //         getInorder(res, root.left);
    //     res.add(root.data);
    //     if (root.right!=null)
    //         getInorder(res, root.right);
    // }
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        // if (root == null)   return true;

        // List<Integer> res = new ArrayList<>();

        // getInorder(res, root);

        // for (int i=1; i<res.size(); i++) {
        //     if (res.get(i) < res.get(i-1))
        //         return false;
        // }

        // return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean isValidBST(BinaryTreeNode<Integer> root, int minVal, int maxVal) {
        if (root == null)   return true;
        if (root.data > maxVal || root.data < minVal) return false;
        return isValidBST(root.left, minVal, root.data)
            && isValidBST(root.right, root.data, maxVal);
    }
}
