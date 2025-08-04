// Last updated: 8/4/2025, 5:59:14 PM
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double avg=sum/k;
        for(int i=k;i<nums.length;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            avg=Math.max(sum/k,avg);
        }
        return avg;
    }
}