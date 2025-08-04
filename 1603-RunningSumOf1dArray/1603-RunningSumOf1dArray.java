// Last updated: 8/4/2025, 5:58:14 PM
class Solution {
    public int[] runningSum(int[] nums) {
        summer(nums,1);
        return nums;

    }

    public static void summer(int[] nums,int index){
        if(nums.length==index){
            return;
        }
        nums[index]+=nums[index-1];
        summer(nums,index+1);
    }
}