/*
    Time Complexity : O(N + M)
    Space Complexity : O(N + M)

    Where, 'N' and 'M' are the number of nodes in the first BST and the second BST respectively.

*/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Store the in-order traversal of tree1 in an array.
        List<Integer> temp1 = new ArrayList<>();
        storeInOrder(root1, temp1);

        // Store the in-order traversal of tree2 in an array.
        List<Integer> temp2 = new ArrayList<>();
        storeInOrder(root2, temp2);

        // Merge the two sorted arrays.
        List<Integer> answer = mergeSortedArrays(temp1, temp2);

        // Construct the balanced BST from this sorted array.
        return answer;
    }

    // Function to merge two sorted array/lists.
    public static List<Integer> mergeSortedArrays(List<Integer> arr1, List<Integer> arr2)
    {
        int i = 0, j = 0;
        List<Integer> arr = new ArrayList<>();

        // Traversing in both arrays.
        while (i < arr1.size() && j < arr2.size())
        {
            // Comparing array elements.
            if (arr1.get(i) < arr2.get(j))
            {
                arr.add(arr1.get(i));
                i++;
            }
            else
            {
                arr.add(arr2.get(j));
                j++;
            }
        }

        // Pushing rest elements.
        while (i < arr1.size())
        {
            arr.add(arr1.get(i));
            i++;
        }

        // Pushing rest elements.
        while (j < arr2.size())
        {
            arr.add(arr2.get(j));
            j++;
        }

        return arr;
    }

    // Function to store the inorder traversal of tree in a list.
    public static void storeInOrder(TreeNode root, List<Integer> arr)
    {
        if (root != null)
        {
            storeInOrder(root.left, arr);
            arr.add(root.data);
            storeInOrder(root.right, arr);
        }
    }
}