public class Solution {
    public static int search(int arr[], int key) {
        // Write your code here.
        int ans = -1;

        int low = 0, high=arr.length-1;

        while(low<=high) {
            int mid = (low+high)/2;

            if (arr[mid]==key) {
                return mid;
            }
            // Identifying the sorted part
            // Left sorted part
            if (arr[low] <= arr[mid]) {
                // Checking whether the target is in left sorted part or not
                if (arr[low]<=key && key<=arr[mid])
                    high = mid-1;
                else 
                    low = mid+1;
            }
            // Right sorted part
            else {
                // Checking whether the target is in right sorted part or not
                if (arr[mid]<=key && key<=arr[high])
                    low = mid+1;
                else 
                    high = mid-1;
            }
        }

        return ans;
    }
}