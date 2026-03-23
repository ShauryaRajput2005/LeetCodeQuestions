class Solution {
    static int n;
    static int m;
    public int findMaxFish(int[][] grid) {
       int max = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    int cur=dfs(i, j, grid);
                    max=Math.max(cur,max);
                }
            }
        }
        return max;
    }

    public static int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0) {
            return 0;
        }
        int fish = grid[row][col];
        grid[row][col] = 0;
        fish += dfs(row - 1, col, grid);
        fish += dfs(row + 1, col, grid);
        fish += dfs(row, col - 1, grid);
        fish += dfs(row, col + 1, grid);

        return fish;
    }
}