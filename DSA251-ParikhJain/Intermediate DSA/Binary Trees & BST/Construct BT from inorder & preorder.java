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
import java.util.*;
public class Solution {
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        // Write your code here.
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            inOrderIndexMap.put(inorder[i], i);
        
        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length-1);
    }
    public static TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);

        // Create left and right subtree
        int mid = inOrderIndexMap.get(preorder[rootIndex]);

        if (mid>left) {
            root.left = splitTree(preorder, inOrderIndexMap, rootIndex+1, left, mid-1);
        }
        if (mid<right) {
            root.right = splitTree(preorder, inOrderIndexMap, rootIndex+1 +mid-left, mid+1, right);
        }

        return root;
    }
}