import java.util.ArrayList;

public class Solution 
{
    public static void helper(int n, int source, int aux, int dest, ArrayList<ArrayList<Integer>> res)  {
        if (n==0)   return;

        ArrayList<Integer> ans = new ArrayList<>();
        helper(n-1, source, dest, aux, res);

        ans.add(source);
        ans.add(dest);

        res.add(ans);

        helper(n-1, aux, source, dest, res);
    }
    public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n) 
    {
        //    Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        helper(n, 1, 2, 3, res);

        return res;
    }
}