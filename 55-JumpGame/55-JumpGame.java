// Last updated: 8/4/2025, 6:01:35 PM
class Solution {
    public boolean canJump(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(idx<i){
                return false;
            }
            idx=Math.max(idx,nums[i]+i);
        }
    return true;
    }
}