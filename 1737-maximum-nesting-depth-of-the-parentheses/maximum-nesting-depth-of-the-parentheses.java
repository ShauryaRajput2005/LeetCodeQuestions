class Solution {
    public int maxDepth(String s) {
        int cnt=0;
        int max=0;
        int i=0;
        while(i<s.length()){
            char cur=s.charAt(i);
            if(cur=='('){
                cnt++;
                max=Math.max(max,cnt);
            }else if(cur==')'){
                cnt--;
            }
        i++;
        }
        return max;
    }
}