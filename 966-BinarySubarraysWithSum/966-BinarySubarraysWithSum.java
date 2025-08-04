// Last updated: 8/4/2025, 5:58:47 PM
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt1 = counter(nums, goal);
        int cnt2 = counter(nums, goal - 1);
        return cnt1 - cnt2;
    }

    public static int counter(int[] nums, int tar) {
        if (tar < 0) return 0;
        int sum = 0;
        int l = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (l <= i && sum > tar) {
                sum -= nums[l];
                l++;
            }
            res += (i - l + 1);  
        }
        return res;
    }
}
