// Last updated: 8/4/2025, 5:59:52 PM
class Solution {
    public boolean isPerfectSquare(int num) {
         if (num < 2) {
        return true; // 0 and 1 are perfect squares
    }
    
    long start = 1, end = num;
    
    while (start <= end) {
        long mid = start + (end - start) / 2;
        long midSquared = mid * mid;
        
        if (midSquared == num) {
            return true;
        } else if (midSquared < num) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    
    return false;
    }
}
