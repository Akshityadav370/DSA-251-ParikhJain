import java.util.* ;

// import jdk.internal.util.xml.impl.Pair;

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
import java.util.*;

public class Solution 
{

    static class Pair {
        int hd;
        TreeNode node;
        public Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)   return res;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();

            int hdCurr = curr.hd;
            TreeNode<Integer> nodeCurr = curr.node;

            map.putIfAbsent(hdCurr, new ArrayList<Integer>());
            ArrayList<Integer> temp = map.get(hdCurr);
            temp.add(nodeCurr.data);
            map.put(hdCurr, temp);

            min = Math.min(min, hdCurr);
            max = Math.max(max, hdCurr);

            if (nodeCurr.left != null)
                queue.add(new Pair(hdCurr-1, nodeCurr.left));
            if (nodeCurr.right != null) 
                queue.add(new Pair(hdCurr+1, nodeCurr.right));
            
        }

        for (int i=min; i<=max; i++) {
            ArrayList<Integer> temp = map.get(i);
            for (Integer x: temp) {
                res.add(x);
            }
        }

        return res;

    }

    
}
