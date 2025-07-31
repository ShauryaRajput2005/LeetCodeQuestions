// Last updated: 7/31/2025, 10:34:17 PM
class Solution {
    public int maxSum(int[] nums) {
        int n=nums.length;
        if(n<2) return nums[0];
        Arrays.sort(nums);
        if(nums[n-1]<0) return nums[n-1];
        int sum=0;
        int i=0;
        while(i<n){
            int cur=nums[i];
            while(i<n && nums[i]==cur){
                i++;
            }
            sum=Math.max(sum+cur,sum);
        }
    return sum;
    }
}