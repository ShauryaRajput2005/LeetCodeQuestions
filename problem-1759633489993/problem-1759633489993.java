// Last updated: 10/5/2025, 8:34:49 AM
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean zero=true;
        for(int n:nums){
            xor^=n;
            if(n!=0) zero=false;
        }
        if(xor!=0) return nums.length;
        if(zero) return 0;
        return nums.length-1;
    }
}