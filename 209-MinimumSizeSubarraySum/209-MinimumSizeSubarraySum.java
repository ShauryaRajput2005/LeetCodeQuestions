// Last updated: 8/4/2025, 6:00:24 PM
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=1,right=nums.length, ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isValid(mid,nums,target)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
    return ans;
    }
    public static boolean isValid(int k,int[] nums,int target){
        int ans=0,sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        ans=sum;
        if(ans>=target) return true;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            if(sum>=target){
                return true;
            }
        }
    return false;
    }

}