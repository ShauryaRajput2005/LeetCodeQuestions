class Solution {
    public boolean predictTheWinner(int[] nums) {
        return recur(nums, 0, nums.length - 1) >= 0;
    }

    public int recur(int[] nums, int st, int e) {
        if (st == e) {
            return nums[st];
        }

        // player takes start
        int takeStart = nums[st] - recur(nums, st + 1, e);

        // player takes end
        int takeEnd = nums[e] - recur(nums, st, e - 1);

        return Math.max(takeStart, takeEnd);
    }
}