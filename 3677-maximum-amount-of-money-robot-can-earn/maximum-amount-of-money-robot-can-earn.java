class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        Integer[][][] dp = new Integer[m][n][3];
        return dfs(0, 0, coins, 2, dp);
    }

    private int dfs(int r, int c, int[][] coins, int k, Integer[][][] dp) {
        int m = coins.length, n = coins[0].length;

        if (r >= m || c >= n) return Integer.MIN_VALUE;

        if (dp[r][c][k] != null) return dp[r][c][k];

        int val = coins[r][c];

        // last cell
        if (r == m - 1 && c == n - 1) {
            if (val < 0 && k > 0) return dp[r][c][k] = 0;
            return dp[r][c][k] = val;
        }

        int best;

        if (val < 0 && k > 0) {
            // option 1: skip this negative
            int skip = Math.max(dfs(r + 1, c, coins, k - 1, dp),
                                dfs(r, c + 1, coins, k - 1, dp));

            // option 2: take it
            int take = val + Math.max(dfs(r + 1, c, coins, k, dp),
                                      dfs(r, c + 1, coins, k, dp));

            best = Math.max(skip, take);
        } else {
            best = val + Math.max(dfs(r + 1, c, coins, k, dp),
                                  dfs(r, c + 1, coins, k, dp));
        }

        return dp[r][c][k] = best;
    }
}