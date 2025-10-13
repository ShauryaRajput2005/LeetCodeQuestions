class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = cost[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        long costsum = 0;
        for (int c : cost) costsum += c;

        long weight = 0;
        int i = 0;
        while (i < n && weight < (costsum + 1) / 2) {
            weight += pairs[i][1];
            i++;
        }

        int target = pairs[i - 1][0];
        return calc(nums, cost, target);
    }

    public static long calc(int[] nums, int[] cost, int num) {
        long price = 0;
        for (int i = 0; i < nums.length; i++) {
            long change = Math.abs(nums[i] - num);
            price += change * cost[i];
        }
        return price;
    }
}
