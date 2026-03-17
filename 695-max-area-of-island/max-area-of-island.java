class Solution {
    static int cur;

    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    cur=0;
                    area(grid,j,i);
                    max=Math.max(max,cur);
                }
            }
        }
        return max;
    }

    public static void area(int[][] grid,int col,int row){
        if(grid[row][col]==0){
            return;
        }
        cur++;
        grid[row][col]=0;
        if(row<grid.length-1 && grid[row+1][col]==1){
            area(grid,col,row+1);
        }
        if(row>0 && grid[row-1][col]==1){
            area(grid,col,row-1);
        }
        if(col>0 && grid[row][col-1]==1){
            area(grid,col-1,row);
        }
        if(col<grid[0].length-1 && grid[row][col+1]==1){
            area(grid,col+1,row);
        }
    }
}