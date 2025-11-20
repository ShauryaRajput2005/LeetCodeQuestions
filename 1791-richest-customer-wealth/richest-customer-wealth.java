class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=0;
        for(int[] a:accounts){
            int sum=Arrays.stream(a).sum();
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}