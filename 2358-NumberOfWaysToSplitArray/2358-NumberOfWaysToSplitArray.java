// Last updated: 8/7/2025, 11:06:28 AM
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        
        // Compute prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;
        // Check split points from index 0 to n - 2
        for (int i = 0; i < n - 1; i++) {
            long leftSum = prefixSum[i];
            long rightSum = prefixSum[n - 1] - prefixSum[i];
            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}
