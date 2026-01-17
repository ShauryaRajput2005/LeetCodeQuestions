class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // if(k==1) return (double) Arrays.stream(nums).max().getAsInt();
        double max=Integer.MIN_VALUE;
        double sum=0;
        for(int i=0;i<nums.length;i++){
            if(i>k-1){
                max=Math.max(max,sum/k);
                sum-=nums[i-k];
            }
            sum+=nums[i];
        }
        max=Math.max(sum/k,max);
        return max;
    }
}