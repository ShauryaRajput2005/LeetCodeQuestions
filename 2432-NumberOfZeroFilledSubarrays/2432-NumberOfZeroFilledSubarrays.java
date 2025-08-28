// Last updated: 8/28/2025, 9:52:03 PM
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur++;
                cnt += cur;   
            } else {
                cur = 0;      
            }
        }

        return cnt;
    }
}
