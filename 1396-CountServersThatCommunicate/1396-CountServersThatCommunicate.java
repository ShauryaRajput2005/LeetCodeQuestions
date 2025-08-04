// Last updated: 8/4/2025, 5:58:20 PM
class Solution {
    public int countServers(int[][] grid) {
        int[] row=new int[grid.length];
        int[] col=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;                    
                }
            }
        }
        int server=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(row[i]>1 || col[j]>1){
                        server++;
                    }                    
                }
            }
        }

    return server;
    }
}