// Last updated: 8/4/2025, 5:57:46 PM
class Solution {
    public int maximumDifference(int[] nums) {
        int maxdiff=-1;
        int min=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]>min){
                maxdiff=Math.max(maxdiff,nums[i]-min);
            }else{
                min=nums[i];
            }
        }
        return maxdiff;
        }
}