import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        // Approach 1: Brute Force to find each elements frequency
        // Approach 2: Sorting
        // Approach 3: Hashing
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // ArrayList<Integer> ans = new ArrayList<>();

        // for (int i = 0; i<arr.size(); i++) {
        //     int key = arr.get(i);
        //     if(map.containsKey(key)) {
        //         map.put(key, map.get(key)+1);
        //     } else {
        //         map.put(key, 1);
        //     }
        // }

        // for (Integer key: map.keySet()) {
        //     if (map.get(key) > (arr.size()/3))
        //         ans.add(key);
        // }

        // return ans;

        // Approach 4: Moore's Voting Algo
        ArrayList<Integer> ans = new ArrayList<>();
        int el1=0, el2=0;
        int count1 = 0, count2 = 0;

        // Moore's checking
        for (int i=0; i<arr.size(); i++) {
            if (count1==0 && el2 != arr.get(i)) {
                count1 = 1;
                el1 = arr.get(i);
            } 
            else if (count2==0 && el1 != arr.get(i)) {
                count2 = 1; 
                el2 = arr.get(i);
            } 
            else if (el1 == arr.get(i)) {
                count1++;
            } 
            else if (el2 == arr.get(i)) {
                count2++;
            } else {
                count1--; count2--;
            }
        }

        // Performing manual checking
        count1 = 0; count2 = 0;
        for (int i = 0; i<arr.size();i++) {
            if (arr.get(i)==el1)    count1++;
            else if(arr.get(i)==el2)    count2++;
        }

        if (count1>(arr.size()/3))  ans.add(el1);
        if (count2>(arr.size()/3))  ans.add(el2);

        return ans;
        
    }
}