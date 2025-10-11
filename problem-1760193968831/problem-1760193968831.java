// Last updated: 10/11/2025, 8:16:08 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        if(n<3) return n;

        int max=2;
        int cur=2;
        for(int i=2;i<n;i++){
            if(nums[i]==nums[i-1]+nums[i-2]){
                cur++;
            }else{
                cur=2;
            }
            max=Math.max(max,cur);
        }
    return max;
    }
}