// Last updated: 8/4/2025, 5:58:05 PM
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0, currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
