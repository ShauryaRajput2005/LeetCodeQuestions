// Last updated: 8/4/2025, 6:00:47 PM
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int max=nums[0];
        int min=nums[0];
        int result=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=max;
                max=min;
                min=temp;
            }

            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);
            result=Math.max(result,max);
        }
        return result;
    }
}