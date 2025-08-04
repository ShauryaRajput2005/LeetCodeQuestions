// Last updated: 8/4/2025, 6:00:22 PM
class Solution {
    public int rob(int[] nums) {
        if(nums.length ==0) return 0;
        if(nums.length==1) return nums[0];
        int n=nums.length;
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    private static int rob(int[] nums, int start,int end){
        int prev2=0,prev1=nums[start];
        for(int i=start+1;i<=end;i++){
            int cur=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=cur;
        }
    return prev1;
    }

}