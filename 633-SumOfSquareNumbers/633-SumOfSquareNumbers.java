// Last updated: 8/4/2025, 5:59:16 PM
class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            long sum = (long) left * left + (long) right * right; // Prevent overflow
            if (sum == c) return true;
            else if (sum < c) left++;
            else right--;
        }
        return false;
    }
}
