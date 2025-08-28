// Last updated: 8/28/2025, 9:51:44 PM
class Solution {
    public int minimumArea(int[][] grid) {
        int minrow=Integer.MAX_VALUE,maxrow=Integer.MIN_VALUE;
        int mincol=Integer.MAX_VALUE,maxcol=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minrow=Math.min(minrow,i);
                    maxrow=Math.max(maxrow,i);
                    maxcol=Math.max(maxcol,j);
                    mincol=Math.min(mincol,j);
                }
            }
        }
        return (maxrow-minrow+1)*(1+maxcol-mincol);
    }
}