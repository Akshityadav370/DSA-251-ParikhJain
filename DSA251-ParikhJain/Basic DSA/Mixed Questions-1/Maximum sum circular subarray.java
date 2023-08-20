public class Solution {
    public static int maxSubarraySum(int[] arr, int n) {
        // Write your code here.
        int maxStraightSum = Integer.MIN_VALUE;
        int minStraightSum = Integer.MAX_VALUE;

        int tempMaxSum = 0;
        int tempMinSum = 0;

        int arraySum = 0;

        for (int i = 0; i<n; i++) {
            arraySum += arr[i];

            tempMaxSum += arr[i];
            if (tempMaxSum > maxStraightSum)
                maxStraightSum = tempMaxSum;
            if (tempMaxSum<0)
                tempMaxSum = 0;

            tempMinSum += arr[i];
            if (tempMinSum < minStraightSum)
                minStraightSum = tempMinSum;
            if (tempMinSum>0)   
                tempMinSum = 0;
        }

        return (minStraightSum==arraySum) ? maxStraightSum : Math.max(maxStraightSum, (arraySum-minStraightSum));
    }
}
