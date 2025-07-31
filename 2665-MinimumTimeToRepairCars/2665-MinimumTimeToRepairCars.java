// Last updated: 7/31/2025, 10:34:46 PM
class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        int n = ranks.length;

        long left = 1;
        long right = (long) ranks[ranks.length - 1] * (long) cars * (long) cars;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (ispos(mid, ranks, cars)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean ispos(long time, int[] ranks, int cars) {
        long total = 0;
        for (int rank : ranks) {
            total += (long) Math.sqrt((double) time / rank);
            if (total >= cars) return true;
        }
        return false;
    }
}