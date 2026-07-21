class Solution {
    static class Pair {
        long max, min;
        Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Pair[][] dp = new Pair[n][m];
        dp[0][0] = new Pair(grid[0][0], grid[0][0]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;

                long mx = Long.MIN_VALUE;
                long mn = Long.MAX_VALUE;
                long val = grid[i][j];

                if (i > 0) {
                    long a = dp[i - 1][j].max * val;
                    long b = dp[i - 1][j].min * val;
                    mx = Math.max(mx, Math.max(a, b));
                    mn = Math.min(mn, Math.min(a, b));
                }

                if (j > 0) {
                    long a = dp[i][j - 1].max * val;
                    long b = dp[i][j - 1].min * val;
                    mx = Math.max(mx, Math.max(a, b));
                    mn = Math.min(mn, Math.min(a, b));
                }

                dp[i][j] = new Pair(mn, mx);
            }
        }

        long ans = dp[n - 1][m - 1].max;
        return ans < 0 ? -1 : (int) (ans % 1_000_000_007);
    }
}