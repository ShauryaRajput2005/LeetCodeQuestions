// Last updated: 8/4/2025, 6:01:30 PM
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // First column has only one way
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // First row has only one way
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of top and left cell
            }
        }
        return dp[m - 1][n - 1];
    }
}
