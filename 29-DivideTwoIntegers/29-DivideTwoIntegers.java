// Last updated: 8/4/2025, 6:02:04 PM
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        // Use long to handle overflow, then convert to absolute values
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                result |= (1 << i);
                a -= (b << i);
            }
        }

        // Apply the correct sign
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}
