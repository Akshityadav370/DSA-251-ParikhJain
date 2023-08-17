public class Solution 
{
    public static char kThCharaterOfDecryptedString(String s, Long k) 
    {
        // Write your code here
        // String expand = "";

        String subString = "";
        long freqOfSubString = 0;

        for(int i=0; i<s.length(); ) {
            subString="";
            freqOfSubString=0;
            long lenOfSubString=0;

            while(i<s.length() && s.charAt(i)>='a' && s.charAt(i)<='z') {
                subString += s.charAt(i);
                i++;
                lenOfSubString++;
            }

            while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
                freqOfSubString = freqOfSubString*10 + s.charAt(i) - '0';
                i++;
            }

            // for(int j=1; j<=freqOfSubString; j++)
            //     expand += subString;

            Long t = lenOfSubString*freqOfSubString;

            if (t<k) k-=t;
            else {
                // k %= lenOfSubString;
                long ind = (k-1)%lenOfSubString;
                int index = (int)ind;
                return subString.charAt(index);
            }
            // i--;
        }

        // if (freqOfSubString ==0)
        //     expand += subString;

        // char[] ans = expand.toCharArray();
        // return ans[k];
        return 'a';
    }
}