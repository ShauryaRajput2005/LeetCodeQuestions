// Last updated: 8/4/2025, 6:02:17 PM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result=strs[0];
        for(int i=1;i<strs.length;i++){
            int n=match(result,strs[i]);
            if(n<0) return "";
            result=result.substring(0,n);

        }
        return result;

    }

    public static int match(String res,String c){
        for(int i=0;i<Math.min(res.length(),c.length());i++){
            if(res.charAt(i)!=c.charAt(i)){
                return i;
            }
        }
        return Math.min(res.length(),c.length());
    }
}