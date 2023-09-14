import java.util.* ;
import java.io.*; 
/*************************************************************
 
    Following is the Binary Tree node structure

   class BinaryTreeNode<T> {
   
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = right = null;
    }

};

*************************************************************/

// public class Solution
// {
//     public static ArrayList<Integer> bottomRightView(BinaryTreeNode<Integer> root)
//     {
//         // Write your code here.
//         ArrayList<Integer> res = new ArrayList<>();
//         if (root == null)
//             return res;
        
//         Map<Integer, Integer> map = new HashMap<>();
//         solve(root, map, 0);

//         for (Integer key: map.keySet()) {
//             res.add(map.get(key));
//         }

//         Collections.sort(res);
//         return res;
//     }
//     static void solve(BinaryTreeNode<Integer> root, Map<Integer, Integer> map, int d) {
//         if (root == null)
//             return;
            
//         // Traverse Diagonally
//         map.put(d, root.data);
//         solve(root.left, map, d+1);
//         solve(root.right, map, d);
//     }
// }
public class Solution
{
    public static int maxLevel = 0;
    
	public static void bottomRightViewUtil(BinaryTreeNode<Integer> root, int level,  ArrayList<Integer> answer) {
    if (root == null) {
        return;
    }

    // Call the right child with same level
    bottomRightViewUtil(root.right, level,  answer);

    // If current node at the maxlevel
    if (maxLevel <= level) {
        answer.add(root.data);
        maxLevel = maxLevel + 1;
    }

    // Call the left child with +1 level
    bottomRightViewUtil(root.left, level + 1,  answer);
}

public static ArrayList<Integer> bottomRightView(BinaryTreeNode<Integer> root) {
    
    // Current maximum level
    maxLevel = 0;
    
	ArrayList<Integer> answer = new ArrayList<Integer>();

    bottomRightViewUtil(root, 0, answer);

    // To return sorted 'answer' list
    Collections.sort(answer);
    return answer;
}
}