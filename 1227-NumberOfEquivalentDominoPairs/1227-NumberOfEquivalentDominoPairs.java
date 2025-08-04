// Last updated: 8/4/2025, 5:58:29 PM
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int cnt=0;
        
        int[] count=new int[100];
        for(int[] d : dominoes){
            int k=Math.min(d[0],d[1])*10+Math.max(d[0],d[1]);
            cnt+=count[k];
            count[k]++;
        }
        return cnt;
    }
}