class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int mindel = n;

        for (int i = 0; i < n; i++) {
            long limit = (long) nums[i] * k;  
            int j = upperBound(nums, limit);
            int keep = j - i + 1;
            int del = n - keep;
            mindel = Math.min(mindel, del);
        }

        return mindel;
    }


    public static int upperBound(int[] nums, long target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
