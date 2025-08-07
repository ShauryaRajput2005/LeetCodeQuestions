// Last updated: 8/7/2025, 11:06:15 AM
class Solution {
    public int maximumCount(int[] nums) {
        int n=0;
        int p=0;
        for(int i:nums){
            if(i<0){
                n++;
            }
            if(i>0){
                p++;
            }
        }
        return Math.max(n,p);
    }
}