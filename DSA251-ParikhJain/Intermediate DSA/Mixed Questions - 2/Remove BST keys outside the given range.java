import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution {

    public static TreeNode<Integer> removeOutsideRange(TreeNode<Integer> root, int min, int max) {

        // Write your code here.
        if (root == null)
            return root;

        // Making the LST & RST in the range then fixing it to the range
        root.left = removeOutsideRange(root.left, min, max);
        root.right = removeOutsideRange(root.right, min, max);

        // Now fixing the root in the range.
        // 2 possibilites are there:
        // 1. (root not in range)
        // 1.a)root is less than min
        if (root.data < min) {
            // TreeNode<Integer> rchild = root.right;
            // root = null;
            // return rchild;
            return root.right;
        }
        // 1.a) root is greater than min
        if (root.data > max) {
            // TreeNode<Integer> lchild = root.left;
            // root = null;
            // return lchild;
            return root.left;
        }

        // 2. (root in range)
        return root;
    }
}