/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
public class Solution {
    // 1. Brute Force 
    // Time: O(n^2)
    // public static boolean isBST(TreeNode root) {
    //     if (root==null) return true;
    //     // if (isLeaf(root))   return true;
        
        
    //     if (root.left != null && root.left.data > root.data) {
    //         return false;
    //     }
    //     if (root.right != null && root.right.data < root.data) {
    //         return false;
    //     }
        
    //     boolean leftSide = isBST(root.left);
    //     boolean rightSide = isBST(root.right);

    //     return leftSide && rightSide;
    // }
    // static int size = 0;
    // public static void calSize(TreeNode root) {
    //     if (root == null)   return;
    //     calSize(root.left);
    //     size+=1;
    //     calSize(root.right);
    // }
    // public static int largestBST(TreeNode root) {
    //     // Write your code here.
    //     if (root==null) return 0;

    //     int ans = 0;
    //     if (isBST(root)) {
    //         size = 0;
    //         calSize(root);
    //         // ans = Math.max(ans, size);
    //         ans = size;
    //     } else {
    //         int leftAns = largestBST(root.left);
    //         int rightAns = largestBST(root.right);
    //         return Math.max(leftAns, rightAns);
    //     }
    //     return ans;
    // }
    // 2. Optimised (max, min, size from left n right)
    private static NodeValue largestBSTHelper (TreeNode root) {
        // An empty tree is a BST of size 0
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left & right ST of current tree
        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        // Current node is greater than max in left &
        // smaller than in min in right, it is a BST
        if (left.maxNode<root.data && right.minNode>root.data) {
            // It is BST
            return new NodeValue(Math.min(left.minNode, root.data), Math.max(right.maxNode, root.data), 
                                    left.maxSize+right.maxSize+1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 
        Math.max(left.maxSize, right.maxSize));
    }
    public static int largestBST (TreeNode root) {
        return largestBSTHelper(root).maxSize;
    }
}