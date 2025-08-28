// Last updated: 8/28/2025, 9:53:58 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return power(n, 1);
    }

    public static boolean power(int n, int k) {
        if (k == n)
            return true;
        if (k > n || k == 0)
            return false; 
        return power(n, k * 2);
    }
}
