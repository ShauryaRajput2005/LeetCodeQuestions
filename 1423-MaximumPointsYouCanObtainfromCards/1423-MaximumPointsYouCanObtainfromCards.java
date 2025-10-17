// Last updated: 10/17/2025, 3:46:22 PM
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int p : cardPoints)
            total += p;

        int window = n - k;
        if (window == 0)
            return total;

        int sum = 0;
        for (int i = 0; i < window; i++)
            sum += cardPoints[i];

        int minSum = sum;
        for (int i = window; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - window];
            minSum = Math.min(minSum, sum);
        }
        return total - minSum;
    }
}
