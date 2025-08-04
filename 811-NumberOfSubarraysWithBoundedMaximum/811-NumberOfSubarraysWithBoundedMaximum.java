// Last updated: 8/4/2025, 5:59:00 PM
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans=0, cnt=0, prev=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > right) {
                cnt=0;
                prev=0;
            } else {
                cnt++;
                if (nums[i]>=left) {
                    prev=cnt;
                }
                ans+=prev;
            }
        }
        return ans;
    }
}
