// /*********************************************************

//  Following is the TreeNode structure:

//  class TreeNode {
//      int data;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {
//          this.data = 0;
//          this.left = null;
//          this.right = null;
//      }
//      TreeNode(int data) {
//          this.data = data;
//          this.left = null;
//          this.right = null;
//      }
//      TreeNode(int data, TreeNode left, TreeNode right) {
//          this.data = data;
//          this.left = left;
//          this.right = right;
//      }
//  };
//  ********************************************************/
// import java.util.*;

// public class Solution {
//     public static void inorder(TreeNode root, List<Integer> res) {
//         if (root == null)   return;

//         inorder(root.left, res);
//         res.add(root.data);
//         inorder(root.right, res);
//     }
//     public static boolean pairSumBst(TreeNode root, int k) {
//         // Write your code here.
//         List<Integer> res = new ArrayList<>();
//         inorder(root, res);

//         int i = 0, j = res.size()-1;

//         while (i<j) {
//             int sum = res.get(i)+res.get(j);
//             if (sum==k)
//                 return true;
//             else if (sum>k)
//                 j-=1;
//             else 
//                 i+=1;
//         }
//         return false;
//     }
// }
import java.util.*;
class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;
    
    public BSTIterator(TreeNode root,boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        if(!reverse) pushAll(node.right);  
        else pushAll(node.left);  
        return node.data;
    }
    
    private void pushAll(TreeNode node){
        while(node != null){
            st.push(node); 
            if(!reverse) node = node.left;
            else node = node.right;
        }
    }
}
class Solution {
    public static boolean pairSumBst(TreeNode root, int k) {
        if(root == null) return false;
        // l gives the elements from very smallest one to further greater
        BSTIterator l = new BSTIterator(root,false);
        // r gives the elements from very largest one to further smaller.
        BSTIterator r = new BSTIterator(root,true);
        
        int i = l.next();
        int j = r.next();
        // Now simple use 2 pointer in a sorted array to find the sum !
        while(i<j){
            if(i+j == k) return true;
            if(i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}