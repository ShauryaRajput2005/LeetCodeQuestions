// Last updated: 7/31/2025, 10:34:36 PM
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;
        int maxLeft = nums[0];

        for (int j = 1; j < n - 1; j++) {
            maxLeft = Math.max(maxLeft, nums[j - 1]); 
            for (int k = j + 1; k < n; k++) {
                long tripletValue = (long) (maxLeft - nums[j]) * nums[k];
                maxValue = Math.max(maxValue, tripletValue);
            }
        }

        return maxValue;
    }
}
