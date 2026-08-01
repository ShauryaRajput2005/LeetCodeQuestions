class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return solve(nums, 0, nums.length - 1, dp) >= 0;
    }

    private int solve(int[] nums, int st, int e, Integer[][] dp) {
        if (st == e)
            return nums[st];

        if (dp[st][e] != null)
            return dp[st][e];

        int takeLeft = nums[st] - solve(nums, st + 1, e, dp);

        int takeRight = nums[e] - solve(nums, st, e - 1, dp);

        return dp[st][e] = Math.max(takeLeft, takeRight);
    }
}