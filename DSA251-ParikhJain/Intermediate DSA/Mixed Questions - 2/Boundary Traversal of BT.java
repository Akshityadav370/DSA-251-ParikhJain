// /************************************************************

//  Following is the Binary Tree node structure:

//  class TreeNode {
//      int data;
//      TreeNode left;
//      TreeNode right;

//      TreeNode(int data) {
//          this.data = data;
//          this.left = null;
//          this.right = null;
//      }
//  }

//  ************************************************************/

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Stack;

// // import javax.swing.tree.TreeNode;

// public class Solution {
    // public static List<Integer> traverseBoundary(TreeNode root){
//         // Write your code here.
//         List<Integer> boundary = new ArrayList<>();
//         if (root==null) return boundary;

//         // Calculating the leftBoundary without leaf nodes
//         TreeNode temp = root;
//         while (true) {
//             boundary.add(temp.data);
            
//             if (temp.left != null) {
//                 temp = temp.left;
//             } else if (temp.right != null) {
//                 temp = temp.right;
//             } else {
//                 break;
//             }
//         }

//         // Calculating the leaf nodes using inorder traversal
//         Stack<TreeNode> stack = new Stack<>();
//         temp = root;
//         while (temp!=null || !stack.isEmpty()) {
            
//             while (temp!=null) {
//                 stack.push(temp);
//                 temp = temp.left;
//             }
//             temp = stack.pop();
//             boundary.add(temp.data);
//             temp = temp.right;
//         }

//         // Calculating the right boundary excluding leaf nodes
//         temp = root.right;
//         Stack<TreeNode> stack1 = new Stack<>();
//         while (true) {
//             stack1.add(temp);
//             if (temp.right != null) {
//                 temp = temp.right;
//             } else if (temp.left != null) {
//                 temp = temp.left;
//             } else {
//                 break;
//             }
//         }
//         while (!stack1.isEmpty()) {
//             boundary.add(stack1.pop().data);
//         }

//         return boundary;
//     }
// }
import java.util.*;
public class Solution {
    static void addLeftBoundary (TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr!=null) {
            if (isLeaf(curr)==false)    res.add(curr.data);
            if (curr.left != null)  curr = curr.left;
            else    curr = curr.right;
        }
    }
    static void addRightBoundary (TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr!=null) {
            if (isLeaf(curr)==false)    temp.add(curr.data);
            if (curr.right != null)  curr = curr.right;
            else    curr = curr.left;
        }
        for (int i=temp.size()-1; i>=0; i--) {
            res.add(temp.get(i));
        }
    }
    static void addLeaves (TreeNode root, List<Integer> res) {
        if (isLeaf(root)){
            res.add(root.data);
            return;
        }
        if (root.left != null)  addLeaves(root.left, res);
        if (root.right != null)  addLeaves(root.right, res);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (isLeaf(root)==false)    res.add(root.data);
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;
    }
    public static boolean isLeaf(TreeNode root) {
        if (root == null)   return false;
        if (root.left==null && root.right==null)    return true;
        return false;
    }
}