// Last updated: 8/4/2025, 6:00:40 PM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int k = summ(numbers, target, numbers[i], i);
            if (k != -1) {
                return new int[]{i + 1, k + 1}; // Found valid indices
            }
        }
        return new int[]{-1, -1}; // No valid pair found
    }

    public static int summ(int[] nums, int target, int cur, int idx) {
        int left = idx + 1, right = nums.length - 1; // Fix bounds
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = nums[mid] + cur;
            if (sum == target) {
                return mid;
            } else if (sum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // No match found
    }
}
