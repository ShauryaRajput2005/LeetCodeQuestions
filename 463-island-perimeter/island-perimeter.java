class Solution {
    int pm = 0;
    boolean[][] vis;

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid);
                    return pm; // stop after first island
                }
            }
        }
        return pm;
    }

    public void dfs(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        if(grid[row][col] == 0 || vis[row][col])
            return;

        vis[row][col] = true;

        int side = 4;

        if(row > 0 && grid[row-1][col] == 1) side--;
        if(col > 0 && grid[row][col-1] == 1) side--;
        if(row < grid.length-1 && grid[row+1][col] == 1) side--;
        if(col < grid[0].length-1 && grid[row][col+1] == 1) side--;

        pm += side;

        dfs(row+1, col, grid);
        dfs(row-1, col, grid);
        dfs(row, col+1, grid);
        dfs(row, col-1, grid);
    }
}