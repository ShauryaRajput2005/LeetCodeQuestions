// Last updated: 7/31/2025, 10:35:05 PM
class Solution {
    public int longestSubsequence(String s, int k) {
        int zeros = 0, ones = 0, value = 0, pow = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            char cur=s.charAt(i);
            if(cur=='1'){
               if(value+pow>k){
                continue;
               }
               value+=pow;
               ones++;
            }
            pow<<=1;

            if(pow>k){
                break;
            }
        }
    return zeros+ones;
    }
}