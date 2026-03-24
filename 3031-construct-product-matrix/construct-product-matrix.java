class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int p=1;
        int[][] pre=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pre[i][j]=p;
                p=(p*(grid[i][j]%12345))%12345;
            }
        }
        int[][] suf=new int[n][m];
        p=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                suf[i][j]=p;
                p=(p*(grid[i][j]%12345))%12345;

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=((suf[i][j]%12345)*(pre[i][j]%12345))%12345;
            }
        }
        return grid;
    }
}