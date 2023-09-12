import java.util.* ;

 import java.io.*;

  /************************************************************

   Following is the TreeNode class structure.

class TreeNode<T>  {

     public T data; 

    public TreeNode<T> left; 

    public TreeNode<T> right;

    TreeNode(T data)      {

         this.data = data;

         left = null;

         right = null;

     }

 }

************************************************************/

 

public class Solution {    

    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {

        // Write your code here.

        flatten(root, null);

        // prev = null;

        return root;

    } 

    // static TreeNode<Integer> prev = null;

    static void flatten(TreeNode<Integer> root, TreeNode<Integer> prev) {

        if (root==null)   

            return;  

       flatten(root.right, prev);  

       flatten(root.left, prev);  

       root.right = prev;  

       root.left = null;  

       prev = root;

    }

 }