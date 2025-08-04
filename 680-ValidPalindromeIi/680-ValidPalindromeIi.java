// Last updated: 8/4/2025, 5:59:09 PM
class Solution {
    public boolean validPalindrome(String s) {
    return ispal(s,0,s.length()-1,true);
    }

    public static boolean ispal(String s,int left,int right,boolean candel){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                if(!candel) return false;

                return ispal(s,left+1,right,false) || ispal(s,left,right-1,false);
            }
            left++;
            right--;
        }
    return true;
    }
}