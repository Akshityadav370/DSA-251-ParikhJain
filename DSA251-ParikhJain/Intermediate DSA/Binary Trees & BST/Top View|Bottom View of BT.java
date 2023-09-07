/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.*;

public class Solution {
    static class Pair {
        int hd;
        TreeNode node;

        public Pair(int hd, TreeNode node) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();


        queue.add(new Pair(0, root));
        int max = 0, min = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();

            int hd = curr.hd;
            TreeNode temp = curr.node;

            if (map.get(hd)==null)  map.put(hd, temp.data);
            // Bottom View
            // map.put(hd, temp.data);

            max = Math.max(max, hd);
            min = Math.min(min, hd);
            if (temp.left!=null)
                queue.add(new Pair(hd-1, temp.left));
            if (temp.right!=null) 
                queue.add(new Pair(hd+1, temp.right));
        }

        // for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        //     res.add(entry.getValue());
        // }

        for (int i=min; i<=max; i++) {
            res.add(map.get(i));
        }

        return res;

    }
}
