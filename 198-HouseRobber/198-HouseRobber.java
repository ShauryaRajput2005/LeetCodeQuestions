// Last updated: 8/4/2025, 6:00:35 PM
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int prev2=0, prev1=nums[0];

        for(int i=1;i<nums.length;i++){
            int cur=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}