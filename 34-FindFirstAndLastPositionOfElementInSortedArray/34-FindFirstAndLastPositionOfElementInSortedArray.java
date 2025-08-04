// Last updated: 8/4/2025, 6:01:58 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = position(nums, target, true);  // Find first position
        int l = position(nums, target, false); // Find last position
        return new int[] {f, l};
    }

    public static int position(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;  // Corrected bounds
        int pos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                pos = mid;
                
                if (first) {
                    right = mid - 1;
                } 
              
                else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;  
            } else {
                left = mid + 1; 
            }
        }
        return pos;
    }
}
