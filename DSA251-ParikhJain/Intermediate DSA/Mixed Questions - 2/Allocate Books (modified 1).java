import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean isPossible(int totalDays, int totalChps, int[] time, long max) {
        int days = 1;
        int timeAllocate = 0;

        for (int i=0; i<totalChps; i++) {
            timeAllocate += time[i];

            if (timeAllocate > max) {
                timeAllocate = time[i];
                days+=1;
            }
            if (days > totalDays || time[i] > max) {
                return false;
            }
        }

        return true;
    }
    // public static long ayushGivesNinjatest(int n, int m, int[] time) {
    //     // Write your code here.
    //     long s = 0, e = 0, ans = -1;
    //     int maxTime = Integer.MIN_VALUE;
    //     for (int i=0; i<time.length; i++) {
    //         e += time[i];
    //         maxTime = Math.min(maxTime, time[i]);
    //     }

    //     s = maxTime;

    //     while (s<=e) {
    //         long mid = s + (e-s)/2;

    //         if (isPossible(n, m, time, mid)) {
    //             ans = mid;
    //             e = mid-1;
    //         } else {
    //             s = mid+1;
    //         }
    //     }

    //     return ans;
        
        
    // }

    // Brute Force
    // public static long ayushGivesNinjatest(int n, int m, int[] time) {

    //     long sum = 0;
    //     int maxTime = Integer.MIN_VALUE;
    //     // We will iterate through all the chapters and calculate the sum. 

    //     for (int i = 0; i < m; i++) {
    //         sum += time[i];
    //         maxTime = Math.max(maxTime , time[i]);
    //     }

    //     // We will iterate through all the possible values of answer.
    //     for (int i = maxTime; i <= sum; i++) {
            
    //         long days = 1;
    //         long currentTime = 0;
    //         for (int j = 0; j < m; j++) {
    //             currentTime += time[j];
    //             if (currentTime > i) {
    //                 days++;
    //                 currentTime = time[j];
    //             }

    //         }

    //         // If the days required to study all the chaptes is less than or equal to n than answer is possible and we will return it.
    //         if (days <= n) {
    //             return i;
    //         }

    //     }

    //     return -1;
    // }
    // Optimal
    public static long ayushGivesNinjatest(int n, int m, int[] time) {

        long sum = 0;
        
        int maxTime = Integer.MIN_VALUE;

        // We will iterate through all the chapters and calculate the sum. 
        for (int i = 0; i < m; i++) {
            sum += time[i];
            maxTime = Math.max(maxTime , time[i]);
        }

        // We will initialize the lower limit of binary search l with 1 and the upper limit of binary search with sum.
        long l = maxTime, r = sum, answer = sum;
        while (l <= r) {
            
            long mid = (l + r) / 2;
            long days = 1;
            long currentTime = 0;
            for (int i = 0; i < m; i++) {
                currentTime += time[i];
                if (currentTime > mid) {
                    days++;
                    currentTime = time[i];
                }

            }

            /*
                If the days required to study all the chaptes is greater than n than answer is not possible
                and we want more time to study in a given day so we will compress the range to the right hand side.
                Else we can study all the chapters and we will update the answer with mid.
            */
            if (days <= n) {
                answer = mid;
                r = mid - 1;
            }

            else {
                l = mid + 1;
            }

        }

        // We will return the final answer.
        return answer;
    }
}