// import java.util.ArrayList;

// import java.util.List;

// public class Solution {

//     public static List<Integer> predecessorSuccessor(TreeNode root, int key) {

//         List<Integer>list=new ArrayList<>();

 

//         TreeNode temp=root;

//         int pre=-1;

//         int suc=-1;

 

//         //1)reach key node 

//         while(temp!=null){

//             if(temp.data==key){

//                 break;

//             }

//             else if(temp.data>key){

//                 //left subtree 

//                 suc=temp.data;

//                 temp=temp.left;

//             }

//             else{

//                 //right subtree

//                 pre=temp.data;

//                 temp=temp.right;

//             }

//         }

 

//         //2)prec find(left subtree max value)

//        if(temp!=null && temp.left!=null){

//             TreeNode leftsubtree=temp.left;

//             while(leftsubtree.right!=null){

//                 leftsubtree=leftsubtree.right;

//             }

//             pre=leftsubtree.data;

//        }

     

//         if(temp!=null && temp.right!=null){

//             //3)suc find(right subtree min value)

//             TreeNode rightsubtree=temp.right;

//             while(rightsubtree.left!=null){

//                 rightsubtree=rightsubtree.left;

//             }

//             suc=rightsubtree.data;

//         }

 

//         list.add(pre);

//         list.add(suc);

 

//         return list;

//     } 

// }
/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        int predecessor = -1;
        int successor = -1;

        // Initializing temporary node with head.
        TreeNode temp = root;

        // Traversing in tree.
        while (temp != null)
        {
            if (key > temp.data)
            {
                // Updating predecessor.
                predecessor = temp.data;
                temp = temp.right;
            }
            else
            {
                temp = temp.left;
            }
        }

        temp = root;

        // Traversing in tree.
        while (temp != null)
        {
            if (key >= temp.data)
            {
                temp = temp.right;
            }
            else
            {
                // Updating successor.
                successor = temp.data;
                temp = temp.left;
            }
        }

        List< Integer > sol = new ArrayList <> ();
        sol.add(predecessor);
        sol.add(successor);
        return sol;
    }
}