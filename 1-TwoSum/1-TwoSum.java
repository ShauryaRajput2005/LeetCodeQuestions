// Last updated: 8/4/2025, 6:02:39 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] arr=new int[2];
      for(int i=0;i<nums.length-1;i++){
        for(int j=i+1;j<=nums.length-1;j++){
            if(nums[i]+nums[j]==target){
                arr[0]=i;
                arr[1]=j;
            }
        }
      }
      return arr;  
    }
}