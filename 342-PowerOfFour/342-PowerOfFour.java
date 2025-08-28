// Last updated: 8/28/2025, 9:53:47 PM
class Solution {
    public boolean isPowerOfFour(int n) {
          return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}