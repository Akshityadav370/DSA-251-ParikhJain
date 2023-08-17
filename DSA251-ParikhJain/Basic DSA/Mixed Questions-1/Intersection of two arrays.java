import java.util.* ;
import java.io.*; 
public class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		// Write Your Code Here.
		// ArrayList<Integer> ans = new ArrayList<>();

		// Using Hashmaps my approach works perfectly
		// HashMap<Integer, Integer> map1 = new HashMap<>();
		// HashMap<Integer, Integer> map2 = new HashMap<>();

		// TreeMap<Integer, Integer> table = new TreeMap<>();

		// for (int i = 0; i<n; i++) {
		// 	int key = arr1.get(i);
		// 	if (map1.containsKey(key))
		// 		map1.put(key, map1.get(key) + 1);
		// 	else 
		// 		map1.put(key, 1);
		// }

		// for (int i = 0; i<m; i++) {
		// 	int key = arr2.get(i);
		// 	if (map2.containsKey(key))
		// 		map2.put(key, map2.get(key) + 1);
		// 	else 
		// 		map2.put(key, 1);
		// }

		// int len = Math.min(map1.size(), map2.size());

		// boolean flag = (len==map1.size()) ? true : false;

		// if (true) {
		// 	// check map1
		// 	table.putAll(map1);

		// 	for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
		// 		int key = entry.getKey();
		// 		if (map2.containsKey(key)) {
		// 			int value = Math.min(map1.get(key), map2.get(key));
		// 			for (int i=0; i<value; i++) {
		// 				ans.add(key);
		// 			}
		// 		}
		// 	}
    
		// } else {
		// 	// check map2
		// 	table.putAll(map2);

		// 	for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
		// 		int key = entry.getKey();
		// 		if (map1.containsKey(key)) {
		// 			int value = Math.min(map2.get(key), map1.get(key));
		// 			for (int i=0; i<value; i++) {
		// 				ans.add(key);
		// 			}
		// 		}
		// 	}
		// }

		// return ans;


		// Approach 1: HashMap
		// Time Complexity: O(N+M)
		// Space Complexity: O(N)
		// ArrayList<Integer> ans = new ArrayList<Integer>();

        // HashMap<Integer, Integer> mp = new HashMap<>();

        // // Hashing the elements of the first array
        // for (int i = 0; i < n; i++)
        // {
        //     if (mp.containsKey(arr1.get(i)))
        //     {
        //         mp.put(arr1.get(i), 1 + mp.get(arr1.get(i)));
        //     }
        //     else
        //     {
        //         mp.put(arr1.get(i), 1);
        //     }
        // }

        // for (int j = 0; j < m; j++)
        // {
        //     // Checking if the elements are present in the second array or not.
        //     if (mp.containsKey(arr2.get(j)))
        //     {
        //         ans.add(arr2.get(j));
        //         mp.put(arr2.get(j), mp.get(arr2.get(j)) - 1);

        //         // Deleting the element if it's frequency is 0.
        //         if (mp.get(arr2.get(j)) == 0)
        //         {
        //             mp.remove(arr2.get(j));
        //         }
        //     }
        // }

        // return ans;

		// Approach 2: Two pointers
		// Time Complexity: O(max(N,M))
    	// Space Complexity: O(1)
		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0, j = 0;

		while(i<n && j<m) {
			if (arr1.get(i).equals(arr2.get(j))) {
				ans.add(arr1.get(i));
				i++;
				j++;
			} else if (arr1.get(i) > arr2.get(j)) {
				j++;
			} else {
				i++;
			}
		}

		return ans;
    
	}
}
