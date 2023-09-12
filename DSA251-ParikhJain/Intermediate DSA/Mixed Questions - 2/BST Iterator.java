import java.util.* ;
import java.io.*; 
/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
public class Solution {
    // static Stack<TreeNode<Integer>> stack = new Stack<>();
    // static TreeNode<Integer> curr = null;
    static class BSTIterator{
        Stack<TreeNode<Integer>> stack;
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            stack = new Stack<>();
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            // System.out.println("Executing cons");
        }


        int next(){
            // Write your code here
            // System.out.println("Executing next");
            TreeNode<Integer> top = stack.pop();
            TreeNode<Integer> temp = top.right;
            while (temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }
            return top.data;
        }

        boolean hasNext(){
            // Write your code here
            // System.out.println("Executing has");
            // if (!stack.isEmpty()) {
            //     System.out.println(stack.peek().data);
            // }
            return !stack.isEmpty();
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
