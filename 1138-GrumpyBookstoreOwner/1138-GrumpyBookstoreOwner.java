// Last updated: 8/4/2025, 5:58:36 PM
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int n = customers.length;

        // Step 1: Calculate always satisfied customers (when grumpy[i] == 0)
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }

        // Step 2: Sliding window to find maximum additional satisfied customers
        int extraSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extraSatisfied += customers[i];
            }
        }

        int maxExtra = extraSatisfied;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) extraSatisfied += customers[i];
            if (grumpy[i - minutes] == 1) extraSatisfied -= customers[i - minutes];
            maxExtra = Math.max(maxExtra, extraSatisfied);
        }

        return totalSatisfied + maxExtra;
    }
}
