class Solution {

    static int mod = 1000000007;
    int[][][] dp;

    public int numOfArrays(int n, int m, int k) {

        dp = new int[51][51][101];

        for(int i=0;i<=n;i++)
            for(int j=0;j<=k;j++)
                Arrays.fill(dp[i][j], -1);

        return solve(0, 0, 0, n, m, k);
    }

    public int solve(int idx, int cost, int maxo, int n, int m, int k) {

        if(idx == n)
            return cost == k ? 1 : 0;

        if(dp[idx][cost][maxo] != -1)
            return dp[idx][cost][maxo];

        int res = 0;

        for(int i=1;i<=m;i++) {

            if(i > maxo)
                res = (res + solve(idx+1, cost+1, i, n, m, k)) % mod;

            else
                res = (res + solve(idx+1, cost, maxo, n, m, k)) % mod;
        }

        return dp[idx][cost][maxo] = res;
    }
}
