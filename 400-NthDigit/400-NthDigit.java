// Last updated: 8/4/2025, 5:59:42 PM
class Solution {
    public int findNthDigit(int n) {
         int digitLength = 1;
        long count = 9;
        long start = 1;

        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        long number = start + (n - 1) / digitLength;
        return String.valueOf(number).charAt((n - 1) % digitLength) - '0';
    }
}