// Last updated: 8/4/2025, 5:57:51 PM
class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long evenPart = power(5, even);
        long oddPart = power(4, odd);

        return (int)((evenPart * oddPart) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}
