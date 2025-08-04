// Last updated: 8/4/2025, 5:58:41 PM
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}