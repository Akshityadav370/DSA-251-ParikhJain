import java.util.Scanner;

class Solution {

    // Approach 1 : Two Pointer
    // static String reverseStringWordWise(String input) {
    //     String[] words = input.split(" ");
    //     int i = 0, j = words.length - 1;
    //     while (i < j) {
    //         String temp = words[i];
    //         words[i] = words[j];
    //         words[j] = temp;
    //         i++;
    //         j--;
    //     }
    //     String ans = "";
    //     for (i = 0; i < words.length; i++) {
    //         ans += (words[i] + " ");
    //     }
    //     return ans;
    // }

    // Approach 2: Array Reversal
    // static String reverseStringWordWise(String input) {
    //     String[] str= input.split(" ");
    //     int n=str.length;
    //     for(int i=0;i<n/2;i++){
    //         String temp=str[i];
    //         str[i]=str[n-1-i];
    //         str[n-1-i]=temp;
    //     }
    //     return String.join(" ", str);
    // }


    static String reverseStringWordWise(String input) {
        // Write your code here
        String []words = input.split(" ");

        StringBuilder str = new StringBuilder();
        
        for(int i = words.length-1; i>=0; i--) {
            str.append(words[i]);
            if (i > 0) {
                str.append(" ");
            }
        }

        return str.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = reverseStringWordWise(input);
        System.out.println(ans);
    }
}