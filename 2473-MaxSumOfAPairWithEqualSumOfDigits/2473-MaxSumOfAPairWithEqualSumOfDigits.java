// Last updated: 7/31/2025, 10:35:00 PM
class Solution {
    public int maximumSum(int[] nums) {
        int[] maxValues = new int[82]; // Max possible sum of digits is 81 (999 -> 9+9+9)
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (maxValues[digitSum] > 0) {
                maxSum = Math.max(maxSum, maxValues[digitSum] + num);
            }
            maxValues[digitSum] = Math.max(maxValues[digitSum], num);
        }
        return maxSum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}