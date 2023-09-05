/************************************************************

 Following is the TreeNode class structure

 class TreeNode<T>
 {
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

public class Solution {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        //    Write your code here.

        // 2. Optimised

        // base cases
        if (root == null)   return -1;
        if (root.data == x)     return x;
        if (root.data == y)     return y;

        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);

        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            // both left & right are not null, we found our result
            return root.data;
        }
    }

    // 1. Brute Force
    //    Finds the path from root to 'X' and return true if it exists.
//     private static boolean getPath(TreeNode<Integer> root, List<Integer> path, int x)
//     {
//         if (root == null)
//         {
//             //    Tree doesn't have any node.
//             return false;
//         }

//         //    Store the root node in the path
//         path.add(root.data);

//         //    Check if we reached to the destination node i.e. 'X'
//         if (root.data == x)
//         {
//             //    'X' is found.
//             return true;
//         }

//         //    Recur to find 'X' in the left subtree.
//         if (getPath(root.left, path, x))
//         {
//             //    'X' exists in the left subtree.
//             return true;
//         }

//         //    Recur to find 'X' in the right subtree.
//         if (getPath(root.right, path, x))
//         {
//             //    'X' exists in the right subtree.
//             return true;
//         }

//         //    Remove the root node because 'X' doesn't exists in the subtree rooted at "root".
//         path.remove(path.size() - 1);

//         return false;
//     }


//     public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y)
//     {
//         //    To store the path from the root node to 'X' and 'Y'
//         List<Integer> pathToX = new ArrayList<Integer>();
//         List<Integer> pathToY = new ArrayList<Integer>();

//         //    Get the path from the root node to node 'X'
//         getPath(root, pathToX, x);

//         //    Get the path from the root node to node 'Y'
//         getPath(root, pathToY, y);

//         int index;

//         //    Iterate while elements in the lists are equal.
//         for (index = 0; index < Math.min(pathToX.size(), pathToY.size()); index++)
//         {
//             if (pathToX.get(index) != pathToY.get(index))
//             {
//                 //    Elements are not same.
//                 break;
//             }
//         }

//         //    Return the LCA.
//         return pathToX.get(index - 1);
//     }
}
