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
import java.util.*;

public class Solution 
{
    public static void leftView(TreeNode<Integer> root, int level, ArrayList<Integer> res) {
        if (root == null)   return;

        if (level == res.size()) {
            res.add(root.data);
        }

        leftView(root.left, level+1, res);
        leftView(root.right, level+1, res);
    }
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null)     return res;

        leftView(root, 0, res);
        return res;
    }
}
