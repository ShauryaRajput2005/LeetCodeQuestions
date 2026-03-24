class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mod = 12345;

        int[][] pre = new int[n][m];
        int[][] suf = new int[n][m];

        int p = 1;

        // prefix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i][j] = p;
                int val = grid[i][j] % mod;
                p = (p * val) % mod;
            }
        }

        p = 1;

        // suffix
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suf[i][j] = p;
                int val = grid[i][j] % mod;
                p = (p * val) % mod;
            }
        }

        // result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (pre[i][j] * suf[i][j]) % mod;
            }
        }

        return grid;
    }
}