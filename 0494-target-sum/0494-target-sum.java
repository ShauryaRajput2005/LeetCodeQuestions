class Solution {
    static int cnt;
    public int findTargetSumWays(int[] nums, int target) {
        cnt=0;
        exp(nums,target,0,0);
        return cnt;
    }
    public static void exp(int[] nums,int target,int cur,int idx){
        if(idx>=nums.length && cur==target){
            cnt++;
            return;
        }
        if(idx>=nums.length){
            return;
        }
        exp(nums,target,cur+nums[idx],idx+1);
        exp(nums,target,cur-nums[idx],idx+1);
    }
}