// // This solution is not considering all the possible combinations
// public class Solution {
//     public static int makeBeautiful(String str) {
//         int count = 0;

//         if (str.charAt(0) == '0') {
//             for (int i = 1; i<str.length(); i++) {
//                 if (i%2 != 0) {
//                     if (str.charAt(i) != '1')
//                         count++;
//                 } else {
//                     if (str.charAt(i) != '0')
//                         count++;
//                 }
//             }
//         }
//         if (str.charAt(0) == '1') {
//             for (int i = 1; i<str.length(); i++) {
//                 if (i%2 != 0) {
//                     if (str.charAt(i) != '0')
//                         count++;
//                 } else {
//                     if (str.charAt(i) != '1')
//                         count++;
//                 }
//             }
//         }

//         return count;
//     }
// }

// Approach 1
// Time: O(n) Space: O(1)
// public class Solution {
//     public static int makeBeautiful(String str) {
//         int n = str.length();

//         int op1=0, op2=0;
//         for(int i = 0; i<n; i++) {
//             if (i%2 == 0) {
//                 if (str.charAt(i) == '0') {
//                     op1++;
//                 }
//             }
//             if (i%2 != 0) {
//                 if (str.charAt(i) == '1') {
//                     op1++;
//                 }
//             }
//         }

//         for(int i = 0; i<n; i++) {
//             if (i%2 == 0) {
//                 if (str.charAt(i) == '1') {
//                     op2++;
//                 }
//             }
//             if (i%2 != 0) {
//                 if (str.charAt(i) == '0') {
//                     op2++;
//                 }
//             }
               
//         }

//         return Math.min(op1, op2);
//     }
// }

// Approach 2
// Time: O(n), Space: O(n)
public class Solution {
    public static int makeBeautiful(String str) {
        int n = str.length();

        char[] b1 = new char[n]; // Strings starting with '0'
        char[] b2 = new char[n]; // Strings starting with '1'
        
        char[] inputArr1 = str.toCharArray();
        char[] inputArr2 = str.toCharArray();

        int count1 = 0;// No. of changes for string starting with '0'
        int count2 = 0;// No. of changes for string starting with '1'

        // To create possible combinations
        for (int i=0; i<n; i++) {
            if ( (i+1)%2 == 0) {
                b1[i] = '1';
                b2[i] = '0';
            } else {
                b1[i] = '0';
                b2[i] = '1';
            }
        }

        // Verifying against the possible arrays and 
        // incrementing the count
        for(int i=0; i<n; i++) {
            if(inputArr1[i] != b1[i]) {
                inputArr1[i] = b1[i];
                count1++;
            } else {
                inputArr2[i] = b2[i];
                count2++;
            }
        }

        return (count1>count2) ? count2 : count1;
        
        
    }
}