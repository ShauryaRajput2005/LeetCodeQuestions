// Last updated: 8/4/2025, 6:00:43 PM
class Solution {
    public int findPeakElement(int[] nums) {
        return peakIndex(nums);
    }

    public static int peakIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) return nums[0] > nums[1] ? 0 : 1;
        
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return maxidx(nums);
    }
    public static int maxidx(int[] nums){
        int max=0;
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
                idx=i;
            }
        }
    return idx;
    }

}