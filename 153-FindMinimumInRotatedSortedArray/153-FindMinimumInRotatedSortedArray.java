// Last updated: 8/4/2025, 6:00:46 PM
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[right]<nums[mid]){
                 left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}