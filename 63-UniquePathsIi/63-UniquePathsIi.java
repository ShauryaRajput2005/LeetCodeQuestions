// Last updated: 8/4/2025, 6:01:28 PM
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        int[][] dp=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    int top=i>0 ? dp[i-1][j] :0;
                    int left=j>0 ? dp[i][j-1] :0;
                    dp[i][j]=left+top;
                }
            }
        }
        return  dp[n-1][m-1];
    }
}