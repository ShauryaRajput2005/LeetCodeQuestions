class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> {
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxl = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {

                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxl = Math.max(maxl, dp[i]);
                }
            }
        }

        return maxl;
    }
}