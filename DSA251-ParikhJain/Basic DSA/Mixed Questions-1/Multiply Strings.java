
public class Solution {

    public static String multiplyStrings(String a, String b) {
        // Write your code here!

        // converting char to int (subtract '0')
        // converting int to char (add '0')

        // int n1 = 0, n2 = 0;

        // // calculating number1
        // for (int i = 0; i<a.length(); i++) {
        //     int digit = a.charAt(i) - '0';
        //     n1 = n1*10 + digit;
        // }

        // // calculating number2
        // for (int i = 0; i<b.length(); i++) {
        //     int digit = b.charAt(i) - '0';
        //     n2 = n2*10 + digit;
        // }
        // // System.out.println(n1+ " "+n2);

        // int sum = n1 * n2;
        // String ans = "";

        // if (sum == 0) {
        //     return "0";
        // }

        // while(sum>0) {
        //     int digit = sum%10;
        //     sum = sum/10;

        //     char digit_str = (char)(digit + '0');
        //     ans = digit_str+ans;
        // }

        // return ans;

        int m = a.length();
        int n = b.length();

        // Base Conditions
        if (m==0 || n==0 || "0".equals(a) || "0".equals(b))     return "0";

        if (a.equals("1"))
            return b;
        if (b.equals("1"))
            return a;

        // Result can be maximum of length M+N
        // ex: 99 * 999 = 98901
        int[] result = new int[m+n];

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                int product = (a.charAt(i)-'0') * (b.charAt(j)-'0');
                // Adding previous values in result array into this project
                product += result[i+j+1];

                // Adding the new product into the result array
                result[i+j+1] = product%10;
                result[i+j] += product/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r: result) {
            if (sb.length()==0 && r==0)
                continue;
            sb.append(r);
        }

        return sb.toString();

    }

}