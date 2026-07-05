class Solution {
    static class Path {
        int score;
        int ways;

        Path(int score, int ways) {
            this.score = score;
            this.ways = ways;
        }
    }

    static Path[][] dp;
    static int n, m;
    static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {

        n = board.size();
        m = board.get(0).length();

        dp = new Path[n][m];

        // initialize every cell separately
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new Path(-1, 0);
            }
        }

        int[] dr = {0, 1, 1};
        int[] dc = {1, 1, 0};

        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {

                char ch = board.get(r).charAt(c);

                if (ch == 'X')
                    continue;

                if (r == n - 1 && c == m - 1) {
                    dp[r][c].score = 0;
                    dp[r][c].ways = 1;
                    continue;
                }

                int max = -1;
                int ways = 0;

                for (int k = 0; k < 3; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= n || nc >= m)
                        continue;

                    if (dp[nr][nc].score > max) {
                        max = dp[nr][nc].score;
                        ways = dp[nr][nc].ways;
                    } else if (dp[nr][nc].score == max && max != -1) {
                        ways = (ways + dp[nr][nc].ways) % MOD;
                    }
                }

                if (max == -1)
                    continue;

                dp[r][c].score = max;

                if (Character.isDigit(ch))
                    dp[r][c].score += ch - '0';

                dp[r][c].ways = ways;
            }
        }

        if (dp[0][0].ways == 0)
            return new int[]{0, 0};

        return new int[]{dp[0][0].score, dp[0][0].ways};
    }
}