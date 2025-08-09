// Last updated: 8/9/2025, 7:50:04 PM
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        
        int[] diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

     
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            diff[l] -= 1;        
            if (r + 1 < n) {
                diff[r + 1] += 1;
            }
        }


        nums[0] = diff[0];
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }


        for (int val : nums) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }
}
