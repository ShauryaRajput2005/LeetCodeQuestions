// Last updated: 7/31/2025, 10:34:31 PM
class Solution {
    public int scoreOfString(String s) {
        int sum=0;
        for(int i=1;i<s.length();i++){
            int prev=(int) s.charAt(i-1);
            int cur=(int) s.charAt(i);
            sum+=Math.abs(cur-prev);
        }
        return sum;
    }
}