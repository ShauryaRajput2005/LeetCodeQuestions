class Solution {
    public int minPartitions(String n) {
        int ans=0;
        for(char ch:n.toCharArray()){
            int c=ch-'0';
            ans=Math.max(c,ans);
        }
        return ans;
    }
}