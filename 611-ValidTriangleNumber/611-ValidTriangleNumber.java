// Last updated: 8/4/2025, 5:59:17 PM
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt=0;
        for(int i=nums.length-1;i>=1;i--){
            int left=0;
            int right=i-1;

            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    cnt+=right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return cnt;
    }
}