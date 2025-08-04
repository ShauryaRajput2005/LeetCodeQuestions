// Last updated: 8/4/2025, 5:58:37 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isPossible(int max, int[] arr, int days) {
        int cursum = 0, req = 1;
        for (int weight : arr) {
            if (cursum + weight > max) {
                req++;
                cursum = weight;
                if (req > days) return false;
            } else {
                cursum += weight;
            }
        }
        return true;
    }
}
