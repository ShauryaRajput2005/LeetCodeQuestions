// Last updated: 7/31/2025, 10:34:45 PM
import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long pairCount = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int leftBound = binarySearch(nums, i + 1, nums.length - 1, lower - nums[i]);
            int rightBound = binarySearch(nums, i + 1, nums.length - 1, upper - nums[i] + 1) - 1;
            
            if (leftBound <= rightBound) {
                pairCount += (rightBound - leftBound + 1);
            }
        }
        
        return pairCount;
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
