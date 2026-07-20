class Solution {
    static int sum;
    public int subsetXORSum(int[] nums) {
        sum=0;
        back(nums,0,0);
        return sum;
    }
    public static void back(int[] nums,int idx,int xor){
        if(idx>=nums.length){
            sum+=xor;
            return;
        }
        int pre=xor;
        pre^=nums[idx];
        back(nums,idx+1,xor);
        back(nums,idx+1,pre);
    }
}