class Solution {
    static Boolean dp[][][];
    static int m,n;
    public boolean hasValidPath(char[][] grid) {
        if (grid[0][0] == ')')
            return false;
        m = grid.length;
        n = grid[0].length;
        dp = new Boolean[m][n][m + n - 1];
        return dfs(grid, 0, 0, 0);
    }

    public boolean dfs(char[][] grid, int b, int cr, int cc) {
        if (dp[cr][cc][b]!=null)
            return dp[cr][cc][b];
        if (b > (m - cr) + (n - cc)) return false;
        int t=b;
        if (grid[cr][cc] == ')' && b == 0) {
            return false;
        } else if (grid[cr][cc] == ')' && b > 0) {
            b--;
        } else {
            b++;
        }
        if (cr == grid.length - 1 && cc == grid[0].length - 1 && b == 0) {
            return true;
        }

        boolean right = (cc + 1 < grid[0].length) ? dfs(grid, b, cr, cc + 1) : false;
        boolean down = (cr + 1 < grid.length) ? dfs(grid, b, cr + 1, cc) : false;
        dp[cr][cc][t] = right || down;
        return right || down;

    }
}