class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];

        dp[1] = 1;
        long active = 0;

        for (int i = 2; i <= n; i++) {
            if (i - delay >= 1)
                active = (active + dp[i - delay]) % MOD;
            if (i - forget >= 1)
                active = (active - dp[i - forget] + MOD) % MOD;
            dp[i] = active % MOD;  // normalize
        }

        long total = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1)
                total = (total + dp[i]) % MOD;
        }
        return (int) total;
    }
}
