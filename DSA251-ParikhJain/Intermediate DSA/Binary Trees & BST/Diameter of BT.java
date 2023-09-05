// /*
//     Time Complexity : O(N ^ 2)
//     Space Complexity : O(N)

//     Where 'N' is the number of nodes in the given binary tree.
// */

// public class Solution {

//     // Returns the height of the tree.
//     public static int getHeight(TreeNode<Integer> root) {
//         if (root == null) {
//             // Height of empty tree is 0.
//             return 0;
//         }

//         // Get the height of left subtree.
//         int leftHeight = getHeight(root.left);

//         // Get the height of right subtree.
//         int rightHeight = getHeight(root.right);

//         // Height of the given binary tree will be 1 greater than maximum of "leftHeight" and "rightHeight".
//         int height = Math.max(leftHeight, rightHeight) + 1;

//         return height;
//     }

//     // Returns the diameter of the given subtree rooted at the 'root' node.
//     public static int getDiameter(TreeNode<Integer> root) {
//         if (root == null) {
//             // Diameter of an empty tree will be 0.
//             return 0;
//         }

//         // Get the height of left and right subtrees.
//         int leftHeight = getHeight(root.left);
//         int rightHeight = getHeight(root.right);

//         // Recur for left subtree and get the diameter.
//         int leftDiameter = getDiameter(root.left);

//         // Recur for right subtree and get the diameter.
//         int rightDiameter = getDiameter(root.right);

//         // Diamter of given binary tree.
//         int diameter = Math.max(leftDiameter, Math.max(rightDiameter, leftHeight + rightHeight));

//         return diameter;
//     }

//     public static int diameterOfBinaryTree(TreeNode < Integer > root) {
//         return getDiameter(root);
//     }
// }
/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    Where 'N' is the number of nodes in the given binary tree.
*/

public class Solution {

    // Returns the diameter of the given subtree rooted at the 'root' node.
    public static int getDiameter(TreeNode<Integer> root, int[] height) {
        if (root == null) {
            // Height and diameter of an empty tree will be 0.
            height[0] = 0;
            return 0;
        }

        // To store the height of left and right subtrees.
        int[] leftHeight = { 0 };
        int[] rightHeight = { 0 };

        // Recur for left subtree and get the height as well as diameter.
        int leftDiameter = getDiameter(root.left, leftHeight);

        // Recur for right subtree and get the height as well as diameter.
        int rightDiameter = getDiameter(root.right, rightHeight);

        // Update the height of the given binary tree.
        height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;

        // Diameter of given binary tree.
        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, leftHeight[0] + rightHeight[0]));

        return diameter;
    }

    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        // To store the height of the of binary tree.
        int[] height = { 0 };

        return getDiameter(root, height);
    }
}