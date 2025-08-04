// Last updated: 8/4/2025, 6:01:27 PM
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }
        return minsumpath(grid, 0, 0, memo);
    }

    public int minsumpath(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        if (i == m && j == n) {
            return grid[i][j];
        }

        if (i > m || j > n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

    
        int right = minsumpath(grid, i, j + 1, memo);
        int down = minsumpath(grid, i + 1, j, memo);

        memo[i][j] = grid[i][j] + Math.min(right, down);
        return memo[i][j];
    }
}
