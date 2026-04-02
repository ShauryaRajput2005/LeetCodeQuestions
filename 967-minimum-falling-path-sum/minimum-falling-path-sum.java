class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int cur=matrix[i][j];
                int k1=(j>0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int k2=dp[i-1][j];
                int k3=(j<m-1) ? dp[i-1][j+1]: Integer.MAX_VALUE;
                dp[i][j]=cur+Math.min(k1,Math.min(k2,k3));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}