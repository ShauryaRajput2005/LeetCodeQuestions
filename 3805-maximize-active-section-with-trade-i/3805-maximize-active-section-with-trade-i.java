class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int left=-1;
        int right=0;
        int ones=0;
        int max=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                ones++;
                continue;
            }
            while(i<n && s.charAt(i)=='0'){
                right++;
                i++;
            }
            if(left!=-1){
                max=Math.max(right+left,max);
                left=right;
                right=0;
            }else{
                left=right;
                right=0;
            }

            i--;
        }
    return max+ones;
    }
}