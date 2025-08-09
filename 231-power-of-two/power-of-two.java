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
