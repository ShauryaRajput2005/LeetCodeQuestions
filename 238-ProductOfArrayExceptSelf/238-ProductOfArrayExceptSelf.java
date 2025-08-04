// Last updated: 8/4/2025, 6:00:13 PM
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int mul=1;

        left[0]=1;
        for(int i=1;i<n;i++){
            mul*=nums[i-1];
            left[i]=mul;

        }
        mul=1;
        int[] right=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            mul*=nums[i+1];
            right[i]=mul;
        }

        for(int i=0;i<n;i++){
            left[i]=left[i]*right[i];
        }
        return left;

    }
}